package com.thor.pawPrint.core.utils.object;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.thor.pawPrint.core.common.constant.BeanVariable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 对象转换
 * Created by Thor on 2017/2/6.
 * happy coding - 1203!
 */
@Slf4j
public class ObjectTransformUtil {
    /**
     * 将javabean实体类转为map类型，然后返回一个map类型的值
     *
     * @param bean 需要转换的对象
     * @return 转换后的map
     */
    public static Map<String, Object> beanToMap(Object bean) {
        //对象为空，直接返回空
        if (ObjectUtils.isEmpty(bean)) {
            return Maps.newHashMap();
        }

        //对象转换
        Map<String, Object> result = new HashMap<>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            result.putAll(setAttributeMap(bean, propertyDescriptors));

            // 过滤敏感信息: class属性
            result.remove(BeanVariable.CLASS);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("beanToMap, 对象转换出错: " + bean);
        }
        return result;
    }

    /**
     * 将javabean实体类转为map类型，然后返回一个map类型的值
     *
     * @param bean       需要转换的对象
     * @param attributes 不包括这些属性
     * @return 转换后的map
     */
    public static Map<String, Object> beanToMap(Object bean, Set<String> attributes) {
        //对象为空，直接返回空
        if (ObjectUtils.isEmpty(bean)) {
            return Maps.newHashMap();
        }

        //对象转换
        Map<String, Object> result = new HashMap<>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor temp : propertyDescriptors) {
                String key = temp.getName();
                //排除属性
                if (ObjectUtils.isEmpty(attributes) || !attributes.contains(key)) {
                    Method getter = temp.getReadMethod();
                    Object value = getter.invoke(bean);
                    result.put(key, value);
                }
            }
            // 过滤敏感信息: class属性
            result.remove(BeanVariable.CLASS);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("beanToMap, 对象转换出错: " + bean);
        }

        return result;
    }

    /**
     * 将javabean实体类转为map类型（键值都是字符串），然后返回一个map类型的值
     *
     * @param bean 需要转换的对象
     * @return 转换后的map
     */
    public static Map<String, String> beanToStringMap(Object bean) {
        //对象为空，直接返回空
        if (ObjectUtils.isEmpty(bean)) {
            return Maps.newHashMap();
        }

        //对象转换
        Map<String, String> result = new HashMap<>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            result.putAll(setAttributeMap(bean, propertyDescriptors));

            // 过滤敏感信息: class属性
            result.remove(BeanVariable.CLASS);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("beanToStringMap, 对象转换出错: " + bean);
        }
        return result;
    }

    /**
     * 将javabean实体类转为map类型（键值都是字符串），然后返回一个map类型的值
     *
     * @param bean       需要转换的对象
     * @param attributes 不包括这些属性
     * @return 转换后的map
     */
    public static Map<String, String> beanToStringMap(Object bean, Set<String> attributes) {
        //对象为空，直接返回空
        if (ObjectUtils.isEmpty(bean)) {
            return Maps.newHashMap();
        }

        //对象转换
        Map<String, String> result = new HashMap<>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor temp : propertyDescriptors) {
                String key = temp.getName();
                //排除属性
                if (ObjectUtils.isEmpty(attributes) || !attributes.contains(key)) {
                    Method getter = temp.getReadMethod();
                    String value = String.valueOf(getter.invoke(bean));
                    result.put(key, value);
                }
            }
            // 过滤敏感信息: class属性
            result.remove(BeanVariable.CLASS);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("beanToStringMap, 对象转换出错: " + bean);
        }

        return result;
    }

    /**
     * map转对象
     *
     * @param map map
     * @param clz 类型
     * @param <T> 泛型
     * @return 对象
     */
    public static <T> T mapToBean(Map map, Class<T> clz) {
        T obj = null;

        try {
            //获取类属性
            BeanInfo beanInfo = Introspector.getBeanInfo(clz);
            //创建 JavaBean 对象
            obj = clz.newInstance();
            //属性
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                String propertyName = propertyDescriptor.getName();

                if (map.containsKey(propertyName)) {
                    Object value = map.get(propertyName);
                    propertyDescriptor.getWriteMethod().invoke(obj, value);
                }
            }
        } catch (IntrospectionException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
            log.error("ObjectTransformUtil -> mapToBean: {}", e.toString());
        }

        return obj;
    }

    public static <T, K, V> List<T> mapToBean(List<Map<K, V>> mapList, Class<T> clz) {
        List<T> result = Lists.newArrayList();

        for (Map<K, V> map : mapList) {
            T t = mapToBean(map, clz);
            result.add(t);
        }

        return result;
    }

    public static Integer stringToInteger(String string) throws Exception {
        if (ObjectUtils.isEmpty(string)) {
            return null;
        }

        return Integer.parseInt(string);
    }

    public static Integer[] stringToInteger(String[] strings) throws Exception {
        if (ObjectUtils.isEmpty(strings)) {
            return new Integer[0];
        }

        Integer[] result = new Integer[strings.length];
        for (int i = 0; i < strings.length; i++) {
            result[i] = Integer.parseInt(strings[i]);
        }

        return result;
    }

    private static Map<? extends String, ? extends String> setAttributeMap(Object bean, PropertyDescriptor[] propertyDescriptors) throws InvocationTargetException, IllegalAccessException {
        Map<String, String> result = new HashMap<>();
        for (PropertyDescriptor temp : propertyDescriptors) {
            String key = temp.getName();
            Method getter = temp.getReadMethod();
            String value = String.valueOf(getter.invoke(bean));
            result.put(key, value);
        }
        return result;
    }

}
