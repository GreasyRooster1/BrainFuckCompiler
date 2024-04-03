package Parse;

import static Utils.Utils.append;

public class Parser {
    public String[] lines;
    public boolean includeDocs = false;

    public void load(String[] _lines) {
        lines=_lines;
    }
    public String parse(){
        return "";
    }


    public static String[] parseComments(String[] programLines) {
        String[] out = new String[0];
        for (String line: programLines) {
            if(!line.startsWith("//")){
                out = append(out,line);
            }
        }
        return out;
    }
}
