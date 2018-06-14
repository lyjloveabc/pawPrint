package com.thor.pawPrint.core.utils.object;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 对象copy工具
 * Created by Thor on 2017/2/6.
 * happy coding - 1203!
 */
@Slf4j
public class ObjectCopyUtil {
    public static <S, T> T copyObject(S source, Class<T> target) {
        if (ObjectUtils.isEmpty(source)) {
            return null;
        }

        T result = null;
        try {
            result = target.newInstance();
            BeanUtils.copyProperties(source, result);
        } catch (Exception e) {
            log.error("对象copy失败, ", e);
        }
        return result;
    }

    public static <S, T> List<T> copyObjects(Collection<S> sources, Class<T> target) {
        if (CollectionUtils.isEmpty(sources)) {
            return Lists.newArrayList();
        }

        List<T> result = Lists.newArrayList();
        for (S temp : sources) {
            result.add(copyObject(temp, target));
        }
        return result;
    }

    public static <S, T, K> Map<K, T> copyObjects(Map<K, S> sources, Class<T> target) {
        if (CollectionUtils.isEmpty(sources)) {
            return Maps.newHashMap();
        }

        Map<K, T> result = Maps.newHashMap();
        for (Map.Entry<K, S> temp : sources.entrySet()) {
            K key = temp.getKey();
            S val = temp.getValue();
            result.put(key, copyObject(val, target));
        }
        return result;
    }

}
