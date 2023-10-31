package net.therap.courseenrollment.bootstrap;

import net.therap.courseenrollment.exception.ViewNotFoundException;
import net.therap.courseenrollment.utils.Constant;
import net.therap.courseenrollment.view.View;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static net.therap.courseenrollment.repository.db.ConnectionPool.PROPERTIES;

/**
 * @author rokib.ahmed
 * @since 10/30/23
 */
public class ViewResolver {

    private static final Map<String, Class<?>> views = new HashMap<>();

    public static void register() throws ClassNotFoundException {
        String basePackage = PROPERTIES.getProperty("basePackage");
        String basePath = basePackage.replace(".", "/");
        String classpath = Constant.PROJECT_ROOT + "/src/main/java/" + basePath;

        String viewPath = classpath + PROPERTIES.getProperty("viewPath");
        String viewPackage = basePackage + "." + PROPERTIES.getProperty("viewPath").replace("/", "");

        scanViews(new File(viewPath), viewPackage, viewPackage, views);
    }

    public static View resolve(String viewName) throws InstantiationException, IllegalAccessException, ViewNotFoundException {

        Class<?> resolvedViewClass = views.get(viewName);
        Object resolvedView = resolvedViewClass.newInstance();

        if (resolvedView instanceof View) {
            if (resolvedView instanceof View) {
                return (View) resolvedView;

            } else {
                throw new IllegalArgumentException("Invalid view class: " + resolvedViewClass);
            }
        }

        throw new ViewNotFoundException("View not found");
    }


    private static void scanViews(File directory, String viewPackage, String viewPath, Map<String, Class<?>> views) throws ClassNotFoundException {

        File[] files = directory.listFiles();

        if (Objects.isNull(files)) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                scanViews(file, viewPackage, viewPath + "." + file.getName(), views);

            } else if (file.getName().endsWith(".java")) {
                String fileName = file.getName().replace(".java", "");
                String className = viewPath + "." + fileName;

                Class<?> clazz = Class.forName(className);

                String fileNameWithFolder = fileName.toLowerCase();

                if (!viewPackage.equals(viewPath)) {
                    fileNameWithFolder = viewPath.substring(viewPackage.length() + 1) + "." + fileNameWithFolder;

                    fileNameWithFolder = Arrays.stream(fileNameWithFolder.split("\\.")).collect(Collectors.joining("/"));
                }
                views.put(fileNameWithFolder, clazz);
            }
        }
    }

}
