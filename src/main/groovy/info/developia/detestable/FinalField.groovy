package info.developia.detestable

import java.lang.reflect.Field
import java.lang.reflect.Modifier

class FinalField {

    static void set(String fieldName, Object value, Object obj) {
        Field f = obj.getClass().getDeclaredField(fieldName);
        f.setAccessible(true);
        f.set(obj, value);
    }

}
