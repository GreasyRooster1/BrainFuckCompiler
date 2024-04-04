package Assembly.Optimizations.Phases;

import Assembly.Optimizations.OptimizingPhase;

public class WhitespacePhase extends OptimizingPhase {
    public WhitespacePhase(){
        optLevel = 1;
    }

    @Override
    public String optimize(String program) {
        return program.replaceAll("\\s","");
    }
}
