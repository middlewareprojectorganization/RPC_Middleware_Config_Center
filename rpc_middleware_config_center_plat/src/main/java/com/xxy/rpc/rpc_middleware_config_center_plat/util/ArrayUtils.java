package com.xxy.rpc.rpc_middleware_config_center_plat.util;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayUtils {
/**
 * 两个数组相加
 * @param target
 * @param source
 * @return 相加后新的数组集合
 */
public static Field[] addAll(Field[] target, Field[] source) {
    if (target != null) {
        List<Field>  fieldTarget = Stream.of(target).collect(Collectors.toList());
        if (source != null) {
            List<Field> fieldsSource = Stream.of(source).collect(Collectors.toList());
            for (Field field : fieldsSource) {
                fieldTarget.add(field);
            }
        }
        target = fieldTarget.toArray(new Field[fieldTarget.size()]);
        return target;
    }
    return target;
}

}