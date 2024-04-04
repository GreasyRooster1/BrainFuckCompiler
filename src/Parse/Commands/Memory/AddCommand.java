package Parse.Commands.Memory;

import Parse.AsmCommand;
import Parse.AsmCommons;

public class AddCommand extends AsmCommand {
    public AddCommand(){
        identifier = "add";
    }
    @Override
    public String parse(String[] sectors) {
        StringBuilder out = new StringBuilder();

        //decode the inputted sectors
        int address = Integer.decode(sectors[1]);
        int value = Integer.decode(sectors[2]);

        //move the pointer to the specified address
        out.append(AsmCommons.movePointer(address));

        //add value to address
        out.append(AsmCommons.addVal(value));

        //move the pointer back to 0x0000
        out.append(AsmCommons.resetPointer(address));

        return out.toString();
    }
}
