package AssemblyParse.Commands.ControlFlow;

import AssemblyParse.AsmCommand;
import AssemblyParse.AsmCommons;

public class IfoCommand extends AsmCommand {
    public IfoCommand(){
        identifier = "ifo";
    }

    @Override
    public String parse(String[] sectors) {
        StringBuilder out = new StringBuilder();

        int address = Integer.decode(sectors[1]);

        //move pointer to address
        out.append(AsmCommons.movePointer(address));

        //open loop, this will skip the whole execution block if the address is 0
        out.append("[");
        out.append(AsmCommons.resetPointer(address));

        //we dont close the [] block because the ifc command closes it
        return out.toString();
    }
}
