package Assembly.Commands.Memory;

import Assembly.AsmCommand;
import Assembly.AsmCommons;

public class SbmCommand extends AsmCommand {
    public SbmCommand(){
        identifier = "sbm";
    }
    @Override
    public String parse(String[] sectors) {
        /*
            this command is the same as ADM, but it subtracts from address 1 instead of adding
        */

        StringBuilder out = new StringBuilder();

        //decode the inputted sectors
        int address1 = Integer.decode(sectors[1]);
        int address2 = Integer.decode(sectors[2]);

        //move the pointer to the specified address 1
        out.append(AsmCommons.movePointer(address2));

        //open loop that moves (subtracts) data from address 2 to address 1
        out.append("[");

        //move from address 2 to address 1
        out.append(AsmCommons.resetPointer(address2));
        out.append(AsmCommons.movePointer(address1));

        //decrement address1
        out.append("-");

        //reset to 0x0000
        out.append(AsmCommons.resetPointer(address1));

        //increment 0x0000
        out.append("+");

        //move to address 2
        out.append(AsmCommons.movePointer(address2));

        //decrement address 2
        out.append("-");

        //close loop when address 2 is 0
        out.append("]");

        //move the pointer to 0x0000
        out.append(AsmCommons.resetPointer(address2));

        //open loop that sets address 2 back to its original value
        out.append("[");

        //move the pointer to address 2
        out.append(AsmCommons.movePointer(address2));

        //increment address 2
        out.append("+");

        //move to 0x0000
        out.append(AsmCommons.resetPointer(address2));

        //decrement 0x0000
        out.append("-");

        //close loop when 0x0000 is 0
        out.append("]");

        return out.toString();
    }
}
