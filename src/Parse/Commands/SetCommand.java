package Parse.Commands;


import Parse.AsmCommand;

public class SetCommand extends AsmCommand {
    public SetCommand(){
        identifier = "set";
    }

    @Override
    public String parse(String[] sectors) {
        StringBuilder out = new StringBuilder();

        //decode the inputted sectors
        int hexAddress = Integer.decode(sectors[1]);
        int value = Integer.decode(sectors[2]);

        //move the pointer to the specified address


        //set address to 0
        out.append("[-]");

        //set address to the specified value
        for (int i = 0; i < value; i++) {
            out.append("+");
        }

        //move the pointer back to 0x0000
        for (int i = 0; i < hexAddress; i++) {
            out.append("<");
        }

        return out.toString();
    }
}
