package Assembly.Optimizations;

import Assembly.Optimizations.Phases.PointerPhase;
import Assembly.Optimizations.Phases.WhitespacePhase;

import static Utils.Utils.append;

public class Optimizer {
    public int optLevel = 3;
    public boolean includeComments = false;
    public boolean includeCommandNames = false;

    public OptimizingPhase[] optimizations = {};
    public Optimizer setup(){
        optimizations = (OptimizingPhase[]) append(optimizations,new WhitespacePhase());
        optimizations = (OptimizingPhase[]) append(optimizations,new PointerPhase());

        return this;
    }

    public String optimize(String program){
        for (OptimizingPhase optimization:optimizations) {
            if(optimization.optLevel<=optLevel) {
                program = optimization.optimize(program);
            }
        }
        return program;
    }
}
