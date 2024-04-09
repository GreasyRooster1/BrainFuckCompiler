package Assembly.Optimizations;

import Assembly.Optimizations.Phases.PointerPhase;
import Assembly.Optimizations.Phases.WhitespacePhase;

import static Utils.Utils.append;

public class Optimizer {
    public int optLevel;

    public OptimizingPhase[] optimizations = {};

    public Optimizer(int _optLevel){
        optLevel = _optLevel;
        optimizations = (OptimizingPhase[]) append(optimizations,new WhitespacePhase());
        optimizations = (OptimizingPhase[]) append(optimizations,new PointerPhase());
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
