import Assembly.AsmParser;

public class Main {
    public static void main(String[] args) {
        String[] programLines = File.loadFile("programs/program.basm");

        AsmParser asmParser = new AsmParser().setup();

        asmParser.load(programLines);

        System.out.println(asmParser.parse());
    }
}