package Assembly.Commands.ControlFlow;

import Assembly.AsmCommand;

public class NopCommand extends AsmCommand {
    public NopCommand(){identifier="nop";}

    @Override
    public String parse(String[] sectors) {
        //literally does nothing
        return "";
    }
}
