package info.developia.detestable.field

import java.lang.reflect.Field

class Final {

    static void set(String fieldName, Object value, Object obj) {
        Field f = obj.getClass().getDeclaredField(fieldName);
        f.setAccessible(true);
        f.set(obj, value);
    }

}
