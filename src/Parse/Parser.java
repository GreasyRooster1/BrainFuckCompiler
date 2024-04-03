package Parse;

import java.lang.reflect.Array;
import java.util.Arrays;

import static Utils.Utils.append;

public class Parser {
    public String[] lines;
    public AsmCommand[] assemblyCommands = {};

    public Parser setup(){
        assemblyCommands = (AsmCommand[]) append(assemblyCommands,new SetCommand());
        return this;
    }
    public void load(String[] _lines) {
        lines=_lines;
    }
    public String parse(){
        String[] parsedComments = parseComments(lines);
        String[] parsedAsm = parseAsmCommands(parsedComments);

        return String.join(" ",parsedAsm);
    }

    public String[] parseAsmCommands(String[] programLines){
        String[] out = new String[0];
        for (String line:programLines) {
            String[] sectors = line.split(" ");
            for (AsmCommand command:assemblyCommands) {
                if(sectors[0].equals(command.identifier)){
                    out = append(out,command.parse(sectors));
                }
            }
        }
        return out;
    }

    public String[] parseComments(String[] programLines) {
        String[] out = new String[0];
        for (String line: programLines) {
            if(!line.startsWith("//") || line.startsWith("///")){
                out = append(out,line);
            }
        }
        return out;
    }
}
