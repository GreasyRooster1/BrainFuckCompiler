package Parse;

import Parse.Commands.ControlFlow.JmpCommand;
import Parse.Commands.ControlFlow.JptCommand;
import Parse.Commands.IO.InpCommand;
import Parse.Commands.IO.PntCommand;
import Parse.Commands.ControlFlow.IfcCommand;
import Parse.Commands.ControlFlow.IfoCommand;
import Parse.Commands.Memory.AddCommand;
import Parse.Commands.Memory.AdmCommand;
import Parse.Commands.Memory.SetCommand;
import Parse.Commands.Memory.SubCommand;

import static Utils.Utils.append;

public class Parser {
    public String[] lines;
    public AsmCommand[] assemblyCommands = {};

    public Parser setup(){
        //TODO: ADR SBR DBG NOP MOV CPY
        assemblyCommands = (AsmCommand[]) append(assemblyCommands,new SetCommand());
        assemblyCommands = (AsmCommand[]) append(assemblyCommands,new PntCommand());
        assemblyCommands = (AsmCommand[]) append(assemblyCommands,new InpCommand());
        assemblyCommands = (AsmCommand[]) append(assemblyCommands,new IfoCommand());
        assemblyCommands = (AsmCommand[]) append(assemblyCommands,new IfcCommand());
        assemblyCommands = (AsmCommand[]) append(assemblyCommands,new JptCommand());
        assemblyCommands = (AsmCommand[]) append(assemblyCommands,new JmpCommand());
        assemblyCommands = (AsmCommand[]) append(assemblyCommands,new AddCommand());
        assemblyCommands = (AsmCommand[]) append(assemblyCommands,new SubCommand());
        assemblyCommands = (AsmCommand[]) append(assemblyCommands,new AdmCommand());
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
