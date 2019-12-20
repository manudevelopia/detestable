package info.developia.detestable

import info.developia.detestable.field.Final
import info.developia.detestable.field.StaticFinal
import info.developia.detestable.method.Private

class Detestable {

    static void setFinal(String fieldName, Object value, Object toObj) {
        Final.set(fieldName, value, toObj)
    }

    static void setStaticFinal(String fieldName, Object value, Object toObj) {
        StaticFinal.set(fieldName, value, toObj)
    }

    static void setPrivate(String fieldNAme, Object newValue, Object objTo) {
        info.developia.detestable.field.Private.set(fieldNAme, newValue, objTo)
    }

    static def callPrivate(String methodName, Object object) {
        Private.call(methodName, object)
    }

    static def callPrivate(String methodName, Object object, Object... args) {
        Private.call(methodName, object, args)
    }

}
