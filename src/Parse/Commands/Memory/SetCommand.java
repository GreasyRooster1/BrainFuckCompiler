package Parse.Commands.Memory;


import Parse.AsmCommand;
import Parse.AsmCommons;

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
        out.append(AsmCommons.movePointer(hexAddress));

        //set address to 0
        out.append(AsmCommons.clearValue());

        //set address to the specified value
        out.append(AsmCommons.writeVal(value));

        //move the pointer back to 0x0000
        out.append(AsmCommons.resetPointer(hexAddress));

        return out.toString();
    }
}
