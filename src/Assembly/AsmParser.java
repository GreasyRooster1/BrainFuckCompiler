package Assembly;

import Assembly.Optimizations.Optimizer;
import Assembly.Util.AsmCommandRegistry;
import Assembly.Util.AsmParseSettings;

import static Utils.Utils.append;

public class AsmParser {
    public String[] lines;
    public Optimizer optimizer;
    public AsmParseSettings settings;

    public AsmParser(AsmParseSettings _settings) {
        settings = _settings;
        optimizer = new Optimizer(settings.optLevel);
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

            for (AsmCommand command: AsmCommandRegistry.registry) {
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
