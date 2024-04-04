package Assembly.Commands.Memory;

import Assembly.AsmCommand;
import Assembly.AsmCommons;

public class MovCommand extends AsmCommand {
    public MovCommand(){
        identifier = "mov";
    }
    @Override
    public String parse(String[] sectors) {
        StringBuilder out = new StringBuilder();

        //decode the inputted sectors
        int address1 = Integer.decode(sectors[1]);
        int address2 = Integer.decode(sectors[2]);

        //move the data
        out.append(AsmCommons.moveValue(address1,address2));

        return out.toString();
    }
}
