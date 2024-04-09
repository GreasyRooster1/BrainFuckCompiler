package Assembly.Commands.Memory;


import Assembly.Util.AsmCommand;
import Assembly.Util.AsmCommons;

import java.util.Arrays;

public class SetCommand extends AsmCommand {
    public SetCommand(){
        identifier = "set";
    }

    @Override
    public String parse(String[] sectors) {
        StringBuilder out = new StringBuilder();

        //decode the inputted sectors
        int hexAddress = Integer.decode(sectors[1]);
        int value = Integer.decode(sectors[2]);

        //move the pointer to the specified address
        out.append(AsmCommons.movePointer(hexAddress));

        //set address to 0
        out.append(AsmCommons.clearValue());

        //set address to the specified value
        out.append(AsmCommons.writeVal(value));

        //move the pointer back to 0x0000
        out.append(AsmCommons.resetPointer(hexAddress));

        return out.toString();
    }

    @Override
    public String parseWithFlags(String[] sectors, String[] flags) {
        String regular = this.parse(sectors);
        if(!Arrays.asList(flags).contains("{no-reset}")){
            return regular;
            //return when there isn't the static flag
        }
        //remove the reset [-]
        return regular.replace("[-]","");
    }
}
