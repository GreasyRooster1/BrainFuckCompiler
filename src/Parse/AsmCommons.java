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
}
