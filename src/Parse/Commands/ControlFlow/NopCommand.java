package Parse.Commands.ControlFlow;

import Parse.AsmCommand;

public class NopCommand extends AsmCommand {
    public NopCommand(){identifier="nop";}

    @Override
    public String parse(String[] sectors) {
        //literally does nothing
        return "";
    }
}
