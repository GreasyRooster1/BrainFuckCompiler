package Parse.Commands.Memory;

import Parse.AsmCommand;
import Parse.AsmCommons;

public class CpyCommand extends AsmCommand {
    public CpyCommand(){
        identifier = "cpy";
    }
    @Override
    public String parse(String[] sectors) {
        StringBuilder out = new StringBuilder();

        //decode the inputted sectors
        int address1 = Integer.decode(sectors[1]);
        int address2 = Integer.decode(sectors[2]);

        //copy data in address 1 to address 2 and 0x0000

        //move pointer to address 2
        out.append(AsmCommons.movePointer(address2));

        //clear address 2
        out.append("[-]");

        //move back to 0x0000
        out.append(AsmCommons.resetPointer(address2));

        //move pointer to address 1
        out.append(AsmCommons.movePointer(address1));

        //open loop that moves (adds) data from address 1 to address 2 and 0x0000
        out.append("[");

        //move pointer from address 1 to address 2
        out.append(AsmCommons.resetPointer(address1));
        out.append(AsmCommons.movePointer(address2));

        //increment address 2
        out.append("+");

        //reset to 0x0000
        out.append(AsmCommons.resetPointer(address2));

        //increment 0x0000
        out.append("+");

        //move to address 1
        out.append(AsmCommons.movePointer(address1));

        //decrement address 1
        out.append("-");

        //close loop when address 1 is 0
        out.append("]");

        //reset back to 0x0000
        out.append(AsmCommons.resetPointer(address1));

        //move data from 0x0000 to address 1
        out.append(AsmCommons.moveValue(0,address1));


        return out.toString();
    }
}
