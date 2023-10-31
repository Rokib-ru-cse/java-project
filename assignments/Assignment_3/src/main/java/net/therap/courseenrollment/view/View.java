package net.therap.courseenrollment.view;

import net.therap.courseenrollment.model.dto.ConsoleRequest;
import net.therap.courseenrollment.model.dto.ModelAndView;

/**
 * @author rokib.ahmed
 * @since 10/30/23
 */
public interface View {

    ModelAndView view(ConsoleRequest object);

}
