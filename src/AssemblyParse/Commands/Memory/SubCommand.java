package AssemblyParse.Commands.Memory;

import AssemblyParse.AsmCommand;
import AssemblyParse.AsmCommons;

public class SubCommand extends AsmCommand {
    public SubCommand(){
        identifier = "sub";
    }
    @Override
    public String parse(String[] sectors) {
        StringBuilder out = new StringBuilder();

        //decode the inputted sectors
        int address = Integer.decode(sectors[1]);
        int value = Integer.decode(sectors[2]);

        //move the pointer to the specified address
        out.append(AsmCommons.movePointer(address));

        //subtract value from address
        out.append(AsmCommons.subVal(value));

        //move the pointer back to 0x0000
        out.append(AsmCommons.resetPointer(address));

        return out.toString();
    }
}
