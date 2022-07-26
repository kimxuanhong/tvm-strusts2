package com.xhk.travinhmotel.auth.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ObjectUtils {

    private ObjectUtils() {
    }

    public static List<String> getListField(Class<?> o) {
        List<String> listField = new ArrayList<>();
        for (Field field : o.getDeclaredFields()) {
            listField.add(field.getName());
        }
        return listField;
    }

    public static Object getFieldFromObject(Object fromObj, String fieldName) throws IllegalAccessException, NoSuchFieldException {
        Class<?> clazz = fromObj.getClass();
        Field field;
        try {
            field = clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException nsf) {
            field = clazz.getSuperclass().getDeclaredField(fieldName);
        }

        return field.get(fromObj);
    }
}
