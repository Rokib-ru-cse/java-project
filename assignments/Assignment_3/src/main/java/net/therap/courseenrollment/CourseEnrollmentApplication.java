package net.therap.courseenrollment;

import net.therap.courseenrollment.bootstrap.DispatcherServlet;
import net.therap.courseenrollment.bootstrap.IOCContainer;
import net.therap.courseenrollment.exception.ViewNotFoundException;
import net.therap.courseenrollment.bootstrap.ViewResolver;
import net.therap.courseenrollment.repository.db.DBMigration;

import java.lang.reflect.InvocationTargetException;

/**
 * @author rokib.ahmed
 * @since 10/26/23
 */
public class CourseEnrollmentApplication {

    public static void main(String[] args) throws
            ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            ViewNotFoundException,
            InvocationTargetException,
            NoSuchMethodException {

        new IOCContainer().register();

        DBMigration.createTables();

        ViewResolver.register();

        new DispatcherServlet().dispatch();
    }

}
