package Parse.Commands.IO;

import Parse.AsmCommand;
import Parse.AsmCommons;

public class PntCommand extends AsmCommand {
    public PntCommand(){
        identifier = "pnt";
    }

    @Override
    public String parse(String[] sectors) {
        StringBuilder out = new StringBuilder();

        //decode the inputted sectors
        int address = Integer.decode(sectors[1]);
        int value = Integer.decode(sectors[2]);

        //move pointer to address
        out.append(AsmCommons.movePointer(address));

        //print value
        for (int i = 0; i < value; i++) {
            out.append(".>");
        }

        //reset pointer
        out.append(AsmCommons.resetPointer(address+value));

        return out.toString();
    }
}
