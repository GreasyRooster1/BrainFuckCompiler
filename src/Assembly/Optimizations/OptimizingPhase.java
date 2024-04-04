package Assembly.Optimizations;

public abstract class OptimizingPhase {
    public int optLevel = 3;

    public String optimize(String program) {
        return program;
    }
}
