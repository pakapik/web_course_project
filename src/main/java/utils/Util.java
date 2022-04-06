package utils;

import annotattions.FrontDisplay;
import annotattions.SetterOptions;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;

public class Util {

    public static String getDateFormatPattern() {
        return "yyyy-MM-dd";
    }
    public static SimpleDateFormat getDefaultSimpleDateFormat() { return new SimpleDateFormat(getDateFormatPattern()); }

    public static List<Method> getMethodsAnnotatedWith(final Class<?> type, final Class<? extends Annotation> annotation) {
        final List<Method> methods = new ArrayList<>();
        Class<?> klass = type;
        while (klass != Object.class) {
            for (final Method method : klass.getDeclaredMethods()) {
                if (method.isAnnotationPresent(annotation)) {
                    Annotation annotInstance = method.getAnnotation(annotation);
                    methods.add(method);
                }
            }
            klass = klass.getSuperclass();
        }
        return methods;
    }

    public static List<Tuple<Method, FrontDisplay>> getMethodsAnnotatedDisplayedWithOrdered(final Class<?> type) {
        var annotation = FrontDisplay.class;
        var list = new ArrayList<Tuple<Method, FrontDisplay>>();
        Class<?> klass = type;
        while (klass != Object.class) {
            for (final Method method : klass.getDeclaredMethods()) {
                if (method.isAnnotationPresent(annotation)) {
                    var annotInstance = method.getAnnotation(annotation);
                    list.add(new Tuple<>(method, annotInstance));
                }
            }
            klass = klass.getSuperclass();
        }

        return list.stream().sorted(Comparator.comparingInt(o -> o.getItem2().orderPlace())).toList();
    }

    public static List<Tuple<Method, SetterOptions>> getMethodsAnnotatedSetterWith(final Class<?> type) {
        var annotation = SetterOptions.class;
        var list = new ArrayList<Tuple<Method, SetterOptions>>();
        Class<?> klass = type;
        while (klass != Object.class) {
            for (final Method method : klass.getDeclaredMethods()) {
                if (method.isAnnotationPresent(annotation)) {
                    var annotInstance = method.getAnnotation(annotation);
                    list.add(new Tuple<>(method, annotInstance));
                }
            }
            klass = klass.getSuperclass();
        }

        return list;
    }
}
