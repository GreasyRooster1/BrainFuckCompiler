package AssemblyParse.Commands.ControlFlow;

import AssemblyParse.AsmCommand;

public class NopCommand extends AsmCommand {
    public NopCommand(){identifier="nop";}

    @Override
    public String parse(String[] sectors) {
        //literally does nothing
        return "";
    }
}
