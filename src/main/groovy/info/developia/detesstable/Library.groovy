package info.developia.detesstable

import java.lang.reflect.Field
import java.lang.reflect.Modifier

class Library {
    public static void setFinalStaticField(String fieldName, Object value, Object toObj)
            throws ReflectiveOperationException {

        Field field = toObj.class.getDeclaredField(fieldName);
        field.setAccessible(true);

        Field modifiers = Field.class.getDeclaredField("modifiers");
        modifiers.setAccessible(true);
        modifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        field.set(null, value);
    }

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

    static void setInt(String fieldName, int value, Object toObj) {
        def field = toObj.class.getDeclaredField(fieldName)

        def modifiersField = Field.class.getDeclaredField("modifiers")
        modifiersField.setAccessible(true)
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL)

        def fieldType = Field.getDeclaredField("type")
        fieldType.setAccessible(true)
        fieldType.set(field, Integer)

        field.setAccessible(true)
        field.set(null, value)
    }

    static void setNonStatic(String fieldName, Object value, Object obj) {
        Field f = obj.getClass().getDeclaredField(fieldName);
        f.setAccessible(true);
        f.set(obj, value);
    }

    static def callMethod(String methodName, Object object) {
        object."${methodName}"()
    }

    static def callMethod(String methodName, Object object, Object... args) {
        object."${methodName}"(*args)
    }
}
