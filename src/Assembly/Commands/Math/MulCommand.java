package Assembly.Commands.Math;

import Assembly.AsmCommand;
import Assembly.Util.AsmCommons;

public class MulCommand extends AsmCommand {
    public MulCommand(){
        identifier = "mul";
    }
    @Override
    public String parse(String[] sectors) {
        StringBuilder out = new StringBuilder();

        //decode the inputted sectors
        int address = Integer.decode(sectors[1]);
        int value = Integer.decode(sectors[2]);

        //move pointer to address
        out.append(AsmCommons.movePointer(address));


        //open loop to move data from address to 0x0000
        out.append("[");

        //move to 0x0000
        out.append(AsmCommons.resetPointer(address));

        //add 1 to 0x0000
        out.append("+");

        //move to address
        out.append(AsmCommons.movePointer(address));

        //subtract 1 from address
        out.append("-");

        //close loop when address is 0
        out.append("]");


        //set address to value
        out.append(AsmCommons.writeVal(value));

        //move back to 0x0000
        out.append(AsmCommons.resetPointer(address));

        //subtract 1 from 0x0000
        out.append("-");


        //open loop
        out.append("[");

        //move pointer to address
        out.append(AsmCommons.movePointer(address));

        //add value to address
        out.append(AsmCommons.addVal(value));

        //move to 0x0000
        out.append(AsmCommons.resetPointer(address));

        //subtract 1 from 0x0000
        out.append("-");

        //close loop
        out.append("]");


        return out.toString();
    }
}
