package com.cws.users.copyUtil;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.HashSet;
import java.util.Set;

/**
 * 解决BeanUtils.copyProperties复制null属性的问题
 *
 *
 * @version $Id: $Id
 * 使用 BeanUtils.copyProperties时候,a对象里null会覆盖b对象中已存在的值,此工具类解决了这个问题;
 */
public class CopyUtils {
    /**
     * BeanUtils.copyProperties(source, target, getNullPropertyNames(source)); <br>
     *     可忽略null属性
     *
     * @param source a {@link java.lang.Object} object.
     * @return java.lang.String[]
     */
    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }

        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}