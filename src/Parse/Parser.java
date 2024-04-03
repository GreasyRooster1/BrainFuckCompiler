package Parse;

import java.lang.reflect.Array;
import java.util.Arrays;

import static Utils.Utils.append;

public class Parser {
    public String[] lines;
    public boolean includeDocs = false;
    public int[] pointers = {};

    public void load(String[] _lines) {
        lines=_lines;
    }
    public String parse(){
        String[] parsedComments = parseComments(lines);
        String[] parsedVariables = parseVariables(parsedComments);
        return String.join(" ",parsedVariables);
    }

    public static String[] parseVariables(String[] programLines){
        String[] variableLines={};
        int[] variableLineIndex={};

        int i=0;
        for (String line: programLines) {
            if(line.startsWith("var")) {
                append(variableLines, line);
                append(variableLineIndex,i);
            }
            i++;
        }

        for (int j=0;j<variableLines.length;j++) {
            String line = variableLines[j];
            int index = variableLineIndex[j];


        }
        return programLines;
    }
    public static String[] parseComments(String[] programLines) {
        String[] out = new String[0];
        for (String line: programLines) {
            if(!line.startsWith("//") || line.startsWith("///")){
                out = append(out,line);
            }
        }
        return out;
    }
}
