package com.thor.pawPrint.core.utils.object;

import com.google.common.collect.Sets;
import org.springframework.util.ObjectUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * 对象、参数校验工具类
 * Created by Thor on 2017/2/6.
 * happy coding - 1203!
 */
public class ValidationUtil {
    /**
     * 校验bean中是否有空值
     *
     * @param t   bean
     * @param <T> 泛型标志
     * @return 是有空值true or false
     */
    public static <T> boolean checkParamAttributeEmpty(T t) {
        return checkParamAttributeEmpty(t, null);
    }

    /**
     * 校验bean中是否有空值
     *
     * @param t   bean
     * @param <T> 泛型标志
     * @return 是有空值true or false
     */
    public static <T> boolean checkParamAttributeEmpty(T t, Set<String> filterAttribute) {
        if (ObjectUtils.isEmpty(t)) {
            return true;
        }

        boolean result = false;

        if (ObjectUtils.isEmpty(filterAttribute)) {
            filterAttribute = Sets.newHashSet();
        }

        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(t.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                String name = propertyDescriptor.getName();
                Method getter = propertyDescriptor.getReadMethod();
                Object value = getter.invoke(t);

                if (!filterAttribute.contains(name) && ObjectUtils.isEmpty(value)) {
                    result = true;
                    break;
                }
            }
        } catch (IntrospectionException | InvocationTargetException | IllegalAccessException e) {
            result = true;
            e.printStackTrace();
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(checkParamAttributeEmpty(null));
    }

}
