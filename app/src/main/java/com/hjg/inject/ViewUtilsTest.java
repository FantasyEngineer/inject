package com.hjg.inject;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author houjiguo
 * @data 2018/12/5 17:00
 * @description
 */

public class ViewUtilsTest {
    public static void bind(final Activity activity) {
        /**
         * 通过字节码获取activity 类中所有的字段，在获取Field的时候需要使用getDeclaredFields();
         * 因为只有这个方法才能获取到所有共有包括私有权限修饰的Field.
         */
        Class clz = activity.getClass();
        Field[] fields = clz.getDeclaredFields();
        //一个类中可能有多个对象，这里需要遍历
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            //设置为可访问，暴力反射，就算是私有的也能访问
            field.setAccessible(true);
            //获取字段上的注解对象
            ViewInject annotation = (ViewInject) field.getAnnotation(ViewInject.class);
            if (annotation == null) {
                return;
            }
            //获取注解中的值
            int id = annotation.value();
            View view = activity.findViewById(id);
            try {
                field.set(activity, view);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }

        Method[] declaredMethods = clz.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            final Method method = declaredMethods[i];
            OnClick annotation = method.getAnnotation(OnClick.class);
            if (annotation == null) {
                return;
            }
            int[] ids = annotation.value();
            for (int j = 0; j < ids.length; j++) {
                int id = ids[j];
                final View view = activity.findViewById(id);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            method.invoke(activity, view);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }

    }
}
