import Parse.Parser;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] programLines = File.loadFile("program.ebf");

        Parser parser = new Parser();

        parser.load(programLines);

        System.out.println(parser.parse());
    }
}