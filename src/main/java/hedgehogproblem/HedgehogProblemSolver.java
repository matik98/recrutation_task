package hedgehogproblem;

public interface HedgehogProblemSolver {
    static long solve(long[][] gardenMatrix) {
        InstanceSolver instanceSolver = new InstanceSolver(gardenMatrix);
        return instanceSolver.process();
    }
}
