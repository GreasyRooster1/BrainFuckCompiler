package Assembly.Commands.ControlFlow;

import Assembly.AsmCommand;
import Assembly.Util.AsmCommons;

public class JmpCommand extends AsmCommand {
    public JmpCommand(){
        identifier = "jmp";
    }

    @Override
    public String parse(String[] sectors) {
        StringBuilder out = new StringBuilder();

        int address = Integer.decode(sectors[1]);

        //move pointer to address
        out.append(AsmCommons.movePointer(address));

        //close loop and exit if address is 0
        out.append("]");

        out.append(AsmCommons.resetPointer(address));

        return out.toString();
    }
}
