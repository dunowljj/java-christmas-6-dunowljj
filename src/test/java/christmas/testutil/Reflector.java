package christmas.testutil;

import java.lang.reflect.Field;

public class Reflector {
    public static Object getValue(Object object, int index) throws IllegalAccessException {
        Class<?> totalOrderAmountClass = object.getClass();
        Field[] fields = totalOrderAmountClass.getDeclaredFields();
        fields[index].setAccessible(true);
        Object value = fields[index].get(object);
        return value;
    }
}
