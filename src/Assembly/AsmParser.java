package Assembly;

import Assembly.Commands.Advanced.RawCommand;
import Assembly.Commands.ControlFlow.*;
import Assembly.Commands.IO.DbgCommand;
import Assembly.Commands.IO.InpCommand;
import Assembly.Commands.IO.PntCommand;
import Assembly.Commands.Math.*;
import Assembly.Commands.Memory.*;
import Assembly.Optimizations.Optimizer;
import Assembly.Util.AsmCommand;
import Assembly.Util.AsmParseSettings;

import static Utils.Utils.append;

public class AsmParser {
    public String[] lines;
    public AsmCommand[] assemblyCommands = {};
    public Optimizer optimizer;
    public AsmParseSettings settings;

    public AsmParser(AsmParseSettings _settings){
        settings = _settings;
        setup();
    }

    public AsmParser setup(){
        //TODO: DYS DYF
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
        assemblyCommands = (AsmCommand[]) append(assemblyCommands,new SbmCommand());
        assemblyCommands = (AsmCommand[]) append(assemblyCommands,new MovCommand());
        assemblyCommands = (AsmCommand[]) append(assemblyCommands,new DbgCommand());
        assemblyCommands = (AsmCommand[]) append(assemblyCommands,new NopCommand());
        assemblyCommands = (AsmCommand[]) append(assemblyCommands,new CpyCommand());
        assemblyCommands = (AsmCommand[]) append(assemblyCommands,new SwpCommand());
        assemblyCommands = (AsmCommand[]) append(assemblyCommands,new MulCommand());
        assemblyCommands = (AsmCommand[]) append(assemblyCommands,new RawCommand());

        optimizer = new Optimizer(settings.optLevel);
        return this;
    }
    public void load(String[] _lines) {
        lines=_lines;
    }
    public String parse(){
        String[] parsedComments = parseComments(lines);
        String[] parsedAsm = parseAsmCommands(parsedComments);

        String rawParsed = String.join(" ",parsedAsm);

        String optimized = optimizer.optimize(rawParsed);

        return optimized;
    }

    public String[] parseAsmCommands(String[] programLines){
        String[] out = new String[0];
        for (String line:programLines) {
            String[] sectors = line
                    .strip()
                    .replace(" ","~")
                    .replaceAll("\\s+","")
                    .split("~");

            String[] flags = findFlags(sectors);
            boolean hasFlags = flags.length>=1;

            for (AsmCommand command:assemblyCommands) {
                if(sectors[0].toLowerCase().equals(command.identifier)){
                    String parsed;
                    if(hasFlags){
                        parsed = command.parseWithFlags(sectors,flags);
                    }else{
                        parsed = command.parse(sectors);
                    }
                    out = append(out,parsed);
                }
            }
        }
        return out;
    }

    public String[] findFlags(String[] sectors){
        boolean hasFlags = false;
        String[] flags = {};

        for(String sector : sectors){
            if(sector.startsWith("{")&&sector.endsWith("}")){
                hasFlags = true;
                flags = append(flags,sector);
            }
        }
        return flags;
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
