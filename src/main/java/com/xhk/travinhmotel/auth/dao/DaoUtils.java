package com.xhk.travinhmotel.auth.dao;

import com.xhk.travinhmotel.auth.dao.base.Query;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Optional;

public class DaoUtils {

    public static <T> Optional<T> fetchOne(Method method){
        Query query = method.getAnnotation(Query.class);

        // print Annotation Details
        System.out.println("Annotation for Method Object" + " having name: " + method.getName());
        System.out.println("Key Attribute of Annotation: " + query.value());
        System.out.println("Value Attribute of Annotation: " + query.nativeQuery());

        return Optional.empty();
    }
}
