package com.cws.users.designPattern.factoryPattern;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wenshuo.chen@hand-china.com 2019/11/13 9:35
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
