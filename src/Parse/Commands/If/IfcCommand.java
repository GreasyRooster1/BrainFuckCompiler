package Parse.Commands.If;

import Parse.AsmCommand;
import Parse.AsmCommons;

public class IfcCommand extends AsmCommand{
    public IfcCommand(){
        identifier = "ifc";
    }

    @Override
    public String parse(String[] sectors) {
        StringBuilder out = new StringBuilder();

        int address = Integer.decode(sectors[1]);

        //make sure pointer will reset correctly
        out.append(AsmCommons.movePointer(address));

        //close loop block
        out.append("]");

        //reset pointer
        out.append(AsmCommons.resetPointer(address));


        return out.toString();
    }
}
