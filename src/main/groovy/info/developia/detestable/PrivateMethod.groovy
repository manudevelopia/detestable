package info.developia.detestable

class PrivateMethod {

    static def call(String methodName, Object object) {
        object."${methodName}"()
    }

    static def call(String methodName, Object object, Object... args) {
        object."${methodName}"(*args)
    }

}
