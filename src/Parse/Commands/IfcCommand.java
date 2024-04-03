package Parse.Commands;

import Parse.AsmCommand;
import Parse.AsmCommons;

public class IfcCommand extends AsmCommand{
    public IfcCommand(){
        identifier = "ifc";
    }

    @Override
    public String parse(String[] sectors) {

        //close loop block
        return "]";
    }
}
