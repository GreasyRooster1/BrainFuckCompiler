import Utils.Utils;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static Utils.Utils.append;

public class File {
    public static String[] loadFile(String path){
        String[] out = new String[0];
        try {
            java.io.File file = new java.io.File(path);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                out = append(out,reader.nextLine());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
        return out;
    }


}
