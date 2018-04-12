package com.hbth.mylibrary.utils;


import java.lang.reflect.ParameterizedType;

/**
 * Created by Kevin on 16/11/28.
 */

public class TypeUtil {

    public static <T> T getTypeObject(Object o, int i) {
        try {

            return ((Class<T>) ((ParameterizedType) (o.getClass()
                    .getGenericSuperclass()))
                    .getActualTypeArguments()[i])
                    .newInstance();

        } catch (InstantiationException | IllegalAccessException | ClassCastException e) {
            e.printStackTrace();
        }

        return null;
    }


}
