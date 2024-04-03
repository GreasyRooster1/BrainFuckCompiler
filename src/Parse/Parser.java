package Parse;

import Parse.Commands.IO.InpCommand;
import Parse.Commands.IO.PntCommand;
import Parse.Commands.If.IfcCommand;
import Parse.Commands.If.IfoCommand;
import Parse.Commands.Memory.SetCommand;

import static Utils.Utils.append;

public class Parser {
    public String[] lines;
    public AsmCommand[] assemblyCommands = {};

    public Parser setup(){
        assemblyCommands = (AsmCommand[]) append(assemblyCommands,new SetCommand());
        assemblyCommands = (AsmCommand[]) append(assemblyCommands,new PntCommand());
        assemblyCommands = (AsmCommand[]) append(assemblyCommands,new InpCommand());
        assemblyCommands = (AsmCommand[]) append(assemblyCommands,new IfoCommand());
        assemblyCommands = (AsmCommand[]) append(assemblyCommands,new IfcCommand());
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
            String[] sectors = line
                    .strip()
                    .replace(" ","~")
                    .replaceAll("\\s+","")
                    .split("~");
            for (AsmCommand command:assemblyCommands) {
                if(sectors[0].equals(command.identifier)){
                    String parsed = command.parse(sectors);
                    //System.out.println(parsed);
                    out = append(out,parsed);
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
