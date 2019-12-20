package info.developia.detestable.field

class Private {
    static void set(String fieldNAme, Object newValue, Object objTo){
        objTo.@"$fieldNAme" = newValue
    }
}
