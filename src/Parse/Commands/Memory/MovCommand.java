package Parse.Commands.Memory;

import Parse.AsmCommand;
import Parse.AsmCommons;

public class MovCommand extends AsmCommand {
    public MovCommand(){
        identifier = "mov";
    }
    @Override
    public String parse(String[] sectors) {
        StringBuilder out = new StringBuilder();

        //decode the inputted sectors
        int address1 = Integer.decode(sectors[1]);
        int address2 = Integer.decode(sectors[2]);

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
