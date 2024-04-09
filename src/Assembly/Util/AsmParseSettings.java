package Assembly.Util;

import Utils.File;
import org.json.*;

public class AsmParseSettings {
    public int optLevel = 3;
    public boolean useFlags = true;
    public boolean preserveComments = false;
    public boolean preserveDocComments = false;
    public boolean splitInstructions = false;
    public boolean includeInstructions = false;

    public AsmParseSettings(String path) {
        String jsonString = File.loadAsString(path);
        System.out.println(jsonString);
        if(jsonString==null){
            return;
        }

        JSONObject obj = new JSONObject(jsonString);

        optLevel = obj.getInt("optLevel");
        useFlags = obj.getBoolean("useFlags");
        preserveComments = obj.getBoolean("preserveComments");
        preserveDocComments = obj.getBoolean("preserveDocComments");
        splitInstructions = obj.getBoolean("splitInstructions");
        includeInstructions = obj.getBoolean("includeInstructions");
    }
}