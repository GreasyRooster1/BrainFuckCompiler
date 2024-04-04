package Parse.Commands.Memory;

import Parse.AsmCommand;
import Parse.AsmCommons;

public class SwpCommand extends AsmCommand {
    public SwpCommand(){
        identifier = "swp";
    }
    @Override
    public String parse(String[] sectors) {
        StringBuilder out = new StringBuilder();

        //decode the inputted sectors
        int address1 = Integer.decode(sectors[1]);
        int address2 = Integer.decode(sectors[2]);

        //move address 1 into 0x0000
        out.append(AsmCommons.moveValue(address1,0x0000));

        //move address 2 into address1
        out.append(AsmCommons.moveValue(address2,address1));

        //move 0x0000 into address 2
        out.append(AsmCommons.moveValue(0x0000,address2));

        return out.toString();
    }
}
