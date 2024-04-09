package Assembly.Commands.Advanced;

import Assembly.Util.AsmCommand;

import java.util.Arrays;

public class RawCommand extends AsmCommand {
    public RawCommand(){identifier="raw";}

    @Override
    public String parse(String[] sectors) {
        return String.join(" ", Arrays.copyOfRange(sectors, 1, sectors.length));
    }
}
