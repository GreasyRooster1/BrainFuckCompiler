package Parse.Commands.Memory;

import Parse.AsmCommand;
import Parse.AsmCommons;

public class AdmCommand extends AsmCommand {
    public AdmCommand(){
        identifier = "adm";
    }
    @Override
    public String parse(String[] sectors) {
        /*
            this command is a bit complex so ill explain what its actually doing here.
            first, we create a loop that goes back and forth between address 1 and address 2.
            it adds 1 to address 1 and 0x0000 and subtracts 1 from address 2, essentially adding the two values together.
            this leaves address 1 with the result of address 1 + address 2, and address 2 at 0.
            we need to set address 2 back to its original value, so we do another loop.
            this time we add 1 to address 2 and subtract 1 from 0x0000.
            after this we will be left with this:
            0x0000: 0
            address 1: the sum of address 1 and address 2
            address 2: the same as it was before

            this command has 2 MOV commands inside it, but this would be too complex to leave out of BASM
        */

        StringBuilder out = new StringBuilder();

        //decode the inputted sectors
        int address1 = Integer.decode(sectors[1]);
        int address2 = Integer.decode(sectors[2]);

        //move the pointer to the specified address 1
        out.append(AsmCommons.movePointer(address2));

        //open loop that"moves (adds) data from address 2 to address 1
        out.append("[");

        //move from address 2 to address 1
        out.append(AsmCommons.resetPointer(address2));
        out.append(AsmCommons.movePointer(address1));

        //increment address1
        out.append("+");

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

        //move data from 0x0000 back to address 2
        out.append(AsmCommons.moveValue(0,address2));

        return out.toString();
    }
}
