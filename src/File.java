import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoadFile {
    public static String loadFile(String path){
        String out = "";
        try {
            File file = new File(path);
            Scanner reader = new Scanner(file);
            out= reader.toString();
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
        return out;
    }
}
