package Assembly.Commands.Advanced;

import Assembly.AsmCommand;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RawCommand extends AsmCommand {
    public RawCommand(){identifier="raw";}

    @Override
    public String parse(String[] sectors) {
        return String.join(" ", Arrays.copyOfRange(sectors, 1, sectors.length));
    }
}
