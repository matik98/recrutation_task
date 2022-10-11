package hedgehogproblem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.junit.MatcherAssert.assertThat;


class InstanceSolverTest {

    @Test
    void shouldHaveExpectedTempSumsOfApplesBeforeReachingTreeForMoreRows() {
        //given
        long[][] gardenMatrix = {{1L, 2L, 3L, 4L}};
        int expectedLength = 1;
        long[] expectedTempSumList = {10L};
        InstanceSolver instanceSolver = new InstanceSolver(gardenMatrix);

        //when
        instanceSolver.process();

        //then
        assertThat(instanceSolver.getTempSumsOfApplesBeforeReachingTree().length, is(expectedLength));
        assertThat(instanceSolver.getTempSumsOfApplesBeforeReachingTree(), is(expectedTempSumList));
    }

    @Test
    void shouldHaveExpectedTempSumsOfApplesBeforeReachingTreeForMoreColumns() {
        //given
        long[][] gardenMatrix = {{1L}, {2L}, {3L}, {4L}};
        int expectedLength = 1;
        long[] expectedTempSumList = {10L};
        InstanceSolver instanceSolver = new InstanceSolver(gardenMatrix);

        //when
        instanceSolver.process();

        //then
        assertThat(instanceSolver.getTempSumsOfApplesBeforeReachingTree().length, is(expectedLength));
        assertThat(instanceSolver.getTempSumsOfApplesBeforeReachingTree(), is(expectedTempSumList));
    }

    @ParameterizedTest
    @MethodSource
    void shouldCalculateCorrectValue(long[][] gardenMatrix, long expectedValue) {
        //given
        InstanceSolver instanceSolver = new InstanceSolver(gardenMatrix);

        //when
        long actualValue = instanceSolver.process();

        //then
        assertThat(actualValue, is(expectedValue));

    }

    private static Stream<Arguments> shouldCalculateCorrectValue() {
        long[][] matrix1 = {{1L}};
        long[][] matrix2 = {{1L, 2L}};
        long[][] matrix3 = {{1L}, {2L}};
        long[][] matrix4 = {{1L, 2L}, {1L, 2L}};
        long[][] matrix5 = {{1L, 1L}, {2L, 2L}};
        long[][] matrix6 = {{1L, 2L, 3L}, {1L, 2L, 3L}, {1L, 2L, 3L}};
        long[][] matrix7 = {{1L, 1L, 1L}, {2L, 2L, 2L}, {3L, 3L, 3L}};
        long[][] matrix8 = {{1L, 1L, 1L}, {1L, 5L, 1L}, {1L, 1L, 1L}};
        long[][] matrix9 = {{1L, 2L, 1L, 1L}, {1L, 5L, 1L, 1L}, {1L, 2L, 5L, 1L}};
        return Stream.of(
                Arguments.of(matrix1, 1L),
                Arguments.of(matrix2, 3L),
                Arguments.of(matrix3, 3L),
                Arguments.of(matrix4, 5L),
                Arguments.of(matrix5, 5L),
                Arguments.of(matrix6, 12L),
                Arguments.of(matrix7, 12L),
                Arguments.of(matrix8, 9L),
                Arguments.of(matrix9, 16L)
        );
    }
}