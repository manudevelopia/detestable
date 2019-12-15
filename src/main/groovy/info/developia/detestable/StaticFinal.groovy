package info.developia.detestable

import java.lang.reflect.Field
import java.lang.reflect.Modifier

class StaticFinal {

    static void set(String fieldName, Object value, Object toObj) {
        def field = toObj.class.getDeclaredField(fieldName)

        def modifiersField = Field.class.getDeclaredField("modifiers")
        modifiersField.setAccessible(true)
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL)

        def fieldType = Field.getDeclaredField("type")
        fieldType.setAccessible(true)
        fieldType.set(field, Object)

        field.setAccessible(true)
        field.set(null, value)
    }

}
