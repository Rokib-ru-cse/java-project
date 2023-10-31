package net.therap.validator.model.annotation;

/**
 * @author rokib.ahmed
 * @since 10/22/23
 */
public class IntegerValueProvider implements ValueProvider {

    @Override
    public int getValue(Object fieldValue) {
        return (Integer) fieldValue;
    }

}
