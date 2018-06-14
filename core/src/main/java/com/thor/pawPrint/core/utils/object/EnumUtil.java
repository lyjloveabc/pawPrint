package com.thor.pawPrint.core.utils.object;

import org.springframework.util.ObjectUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 枚举工具类
 * Created by Thor on 2017/2/6.
 * happy coding - 1203!
 */
public class EnumUtil {
    /**
     * 根据一个枚举值获取枚举对象
     *
     * @param clazz     类
     * @param attribute 属性
     * @param val       目标值
     * @param <T>       泛型
     * @return 枚举对象
     * @throws IntrospectionException    异常
     * @throws InvocationTargetException 异常
     * @throws IllegalAccessException    异常
     */
    public static <T> T getEnum(Class<T> clazz, String attribute, String val) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        if (ObjectUtils.isEmpty(attribute) || ObjectUtils.isEmpty(val)) {
            return null;
        }

        T[] enumConstants = clazz.getEnumConstants();
        BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

        for (T t : enumConstants) {
            for (PropertyDescriptor temp : propertyDescriptors) {

                String key = temp.getName();
                if (attribute.equals(key)) {
                    Method getter = temp.getReadMethod();
                    Object value = getter.invoke(t);

                    if (val.equals(value)) {
                        return t;
                    }
                }

            }
        }

        return null;
    }

}
