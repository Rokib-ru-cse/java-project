package net.therap.validator.model.annotation;

import net.therap.validator.model.Status;

/**
 * @author rokib.ahmed
 * @since 10/23/23
 */
public class EnumValueProvider implements ValueProvider {

    @Override
    public int getValue(Object fieldValue) {
        return ((Status) fieldValue).toString().length();
    }

}
