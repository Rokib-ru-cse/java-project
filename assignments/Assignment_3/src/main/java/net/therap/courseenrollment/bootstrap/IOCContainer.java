package net.therap.courseenrollment.bootstrap;

import net.therap.courseenrollment.annotation.Controller;
import net.therap.courseenrollment.utils.Constant;

import java.lang.annotation.Annotation;
import java.util.*;

/**
 * @author rokib.ahmed
 * @since 10/24/23
 */
public class IOCContainer {

    private static List<Class<? extends Annotation>> annotations = new ArrayList<>();
    private static final Map<Class<?>, Object> instances = new HashMap<>();

    static {
        annotations.add(Controller.class);

        annotations = Collections.unmodifiableList(annotations);
    }

    public void register() throws ClassNotFoundException {
        List<Class<?>> components = ComponentScanner.scan(Constant.BASE_PACKAGE, annotations);

        for (Class<?> clazz : components) {
            try {
                Object object = createDependencyInstance(clazz);

                instances.put(clazz, object);

            } catch (InstantiationException | IllegalAccessException e) {
                System.out.println(String.format(Constant.INSTANCE_CREATION_FAILED, clazz.getName()));
            }
        }
    }

    private Object createDependencyInstance(Class<?> dependencyClass)
            throws InstantiationException, IllegalAccessException {

        return dependencyClass.newInstance();
    }

    public static <T> T resolve(Class<?> clazz) {
        if (instances.containsKey(clazz)) {
            return (T) instances.get(clazz);

        } else {
            throw new RuntimeException(Constant.DEPENDENCY_NOT_REGISTERED_MESSAGE);
        }
    }

}
