package Assembly;

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

    public static String moveValue(int address1,int address2) {
        StringBuilder out = new StringBuilder();

        //move the pointer to address 2
        out.append(AsmCommons.movePointer(address2));

        //reset address 2
        out.append("[-]");

        //reset back to 0x0000
        out.append(AsmCommons.resetPointer(address2));

        //move the pointer to address 1
        out.append(AsmCommons.movePointer(address1));

        //open loop that moves data from address 1 to address 2
        out.append("[");

        //move from address 1 to address 2
        out.append(AsmCommons.resetPointer(address1));
        out.append(AsmCommons.movePointer(address2));

        //increment address 2
        out.append("+");

        //reset to 0x0000
        out.append(AsmCommons.resetPointer(address2));

        //move to address 1
        out.append(AsmCommons.movePointer(address1));

        //decrement address 1
        out.append("-");

        //close loop when address 1 is 0
        out.append("]");

        //reset back to 0x0000
        out.append(AsmCommons.resetPointer(address1));

        return out.toString();
    }
}
