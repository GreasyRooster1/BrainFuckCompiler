import Assembly.AsmParseSettings;
import Assembly.AsmParser;
import Utils.File;

public class Main {
    public static void main(String[] args) {
        String[] programLines = File.loadFile("programs/alphabet-opt.basm");

        AsmParseSettings settings = new AsmParseSettings("programs/settings/asm-parse-settings.json");
        AsmParser asmParser = new AsmParser().setup();

        asmParser.load(programLines);

        System.out.println(asmParser.parse());
    }
}