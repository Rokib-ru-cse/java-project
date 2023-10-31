package net.therap.courseenrollment.bootstrap;

import net.therap.courseenrollment.utils.Constant;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author rokib.ahmed
 * @since 10/24/23
 */
public class ComponentScanner {

    public static List<Class<?>> scan(String basePackage,
                                      List<Class<? extends Annotation>> annotations)
            throws ClassNotFoundException {

        List<Class<?>> components = new ArrayList<>();

        String basePath = basePackage.replace(".", "/");
        String classpath = Constant.PROJECT_ROOT + "/src/main/java/" + basePath;

        scanPackage(new File(classpath), basePackage, components, annotations);

        return components;
    }

    private static void scanPackage(File directory,
                                    String basePackage,
                                    List<Class<?>> components,
                                    List<Class<? extends Annotation>> annotations)
            throws ClassNotFoundException {

        File[] files = directory.listFiles();

        if (Objects.isNull(files)) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                scanPackage(file, basePackage + "." + file.getName(), components, annotations);

            } else if (file.getName().endsWith(".java")) {
                String className = basePackage + "." + file.getName().replace(".java", "");
                Class<?> clazz = Class.forName(className);

                boolean hasAnyAnnotation = annotations.stream().anyMatch(clazz::isAnnotationPresent);

                if (hasAnyAnnotation) {
                    components.add(clazz);
                }
            }
        }
    }

}
