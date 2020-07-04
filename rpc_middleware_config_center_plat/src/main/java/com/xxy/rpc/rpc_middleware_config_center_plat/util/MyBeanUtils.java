package com.xxy.rpc.rpc_middleware_config_center_plat.util;

import java.util.function.Supplier;

public class MyBeanUtils extends org.springframework.beans.BeanUtils {

    public static <T> T copyPropertiesChaining(Object source, T target) {
        org.springframework.beans.BeanUtils.copyProperties(source, target);
        return target;
    }

    public static <T> T copyPropertiesChaining(Object source, Supplier<T> supplier) {
        return copyPropertiesChaining(source, supplier.get());
    }

}
