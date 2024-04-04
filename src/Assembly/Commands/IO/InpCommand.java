package Assembly.Commands.IO;

import Assembly.AsmCommand;
import Assembly.AsmCommons;

public class InpCommand extends AsmCommand {
    public InpCommand(){
        identifier = "inp";
    }

    @Override
    public String parse(String[] sectors) {
        StringBuilder out = new StringBuilder();

        //decode the inputted sectors
        int address = Integer.decode(sectors[1]);
        int value = Integer.decode(sectors[2]);

        //move pointer to address
        out.append(AsmCommons.movePointer(address));

        //write input to address
        for(int i=0;i<value;i++) {
            out.append(",>");
        }

        //reset pointer
        out.append(AsmCommons.resetPointer(address+value));

        return out.toString();
    }
}
