package Parse.Commands;

import Parse.AsmCommand;
import Parse.AsmCommons;

public class InpCommand extends AsmCommand {
    public InpCommand(){
        identifier = "inp";
    }

    @Override
    public String parse(String[] sectors) {
        StringBuilder out = new StringBuilder();

        //decode the inputted sectors
        int address = Integer.decode(sectors[1]);

        //move pointer to address
        out.append(AsmCommons.movePointer(address));

        //write input to address
        out.append(",");

        //reset pointer
        out.append(AsmCommons.resetPointer(address));

        return out.toString();
    }
}
