package Parse;

public class AsmCommons {
    public static String movePointer(int address){
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < address; i++) {
            out.append(">");
        }
        return out.toString();
    }

    public static String resetPointer(int address){
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < address; i++) {
            out.append("<");
        }
        return out.toString();
    }

    public static String clearValue(){
        return "[-]";
    }

    public static String writeVal(int value) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < value; i++) {
            out.append("+");
        }
        return out.toString();
    }
    public static String addVal(int value) {
        return writeVal(value);
    }

    public static String subVal(int value) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < value; i++) {
            out.append("-");
        }
        return out.toString();
    }
}
