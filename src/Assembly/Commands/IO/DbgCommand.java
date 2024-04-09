package Assembly.Commands.IO;

import Assembly.AsmCommand;

public class DbgCommand extends AsmCommand {
    public DbgCommand(){identifier="dbg";}

    @Override
    public String parse(String[] sectors) {
        //just returns the debug character
        return "#";
    }
}
