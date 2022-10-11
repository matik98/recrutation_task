package runner;

import hedgehogproblem.HedgehogProblemSolver;
import io.MatrixReader;
import io.ResultWriter;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.Paths;
import java.util.Arrays;

@Slf4j
public class Main {
    public static void main(String[] args) {
        try {
            long[][] treeMatrix = MatrixReader.readMatrixFromFile(Paths.get("Input.txt"));
            log.info("Loaded matrix form file");
            log.debug("Matrix: {}", Arrays.asList(treeMatrix));
            long result = HedgehogProblemSolver.solve(treeMatrix);
            ResultWriter.saveResultToFile(result, "Output.txt");
        } catch(Exception e) {
            log.error("Couldn't solve hedgehog problem", e);
        }
    }
}
