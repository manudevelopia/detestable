package info.developia.detestable.method

class Private {

    static def call(String methodName, Object object) {
        object."${methodName}"()
    }

    static def call(String methodName, Object object, Object... args) {
        object."${methodName}"(*args)
    }

}
