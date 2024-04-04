package Assembly.Optimizations.Phases;

import Assembly.Optimizations.OptimizingPhase;

import java.lang.reflect.Array;
import java.util.Arrays;

import static Utils.Utils.append;

public class PointerPhase extends OptimizingPhase {
    public PointerPhase(){
        optLevel = 1;
    }
    @Override
    public String optimize(String program) {
        char[] chars = program.toCharArray();
        boolean canStop = false;
        while (!canStop) {
            canStop = true;
            for (int i = 1; i < chars.length - 1; i++) {
                if (chars[i] == '>' && chars[i - 1] == '<' || chars[i] == '<' && chars[i - 1] == '>') {
                    chars[i]='@';
                    chars[i-1]='@';
                    canStop=false;
                }
            }
            char[] newChars = {};
            for (int i = 1; i < chars.length - 1; i++) {
                if(chars[i]!='@') {
                    newChars = append(newChars, chars[i]);
                }
            }
            chars=newChars;
        }
        return new String(chars);
    }
}
