import Parse.Parser;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] programLines = File.loadFile("program.basm");

        Parser parser = new Parser().setup();

        parser.load(programLines);

        System.out.println(parser.parse());
    }
}