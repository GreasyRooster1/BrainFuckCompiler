package Assembly.Commands.ControlFlow;

import Assembly.AsmCommand;
import Assembly.Util.AsmCommons;

public class JptCommand extends AsmCommand {
    public JptCommand(){
        identifier = "jpt";
    }

    @Override
    public String parse(String[] sectors) {
        StringBuilder out = new StringBuilder();

        int address = Integer.decode(sectors[1]);

        //go to address
        out.append(AsmCommons.movePointer(address));

        //open loop
        out.append("[");

        //reset back to 0x0000
        out.append(AsmCommons.resetPointer(address));

        return out.toString();
    }
}
