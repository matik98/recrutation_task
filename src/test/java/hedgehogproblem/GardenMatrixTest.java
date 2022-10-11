package hedgehogproblem;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.junit.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GardenMatrixTest {
    private static final String MATRIX_CANNOT_BE_EMPTY_EXCEPTION_MESSAGE = "Matrix cannot be empty";
    private static final String MATRIX_CANNOT_HAVE_EMPTY_COLUMNS_EXCEPTION_MESSAGE = "Matrix cannot have empty columns";
    private static final String MATRIX_COLUMNS_HAVE_TO_HAVE_THE_SAME_NUMBER_OF_ELEMENTS_EXCEPTION_MESSAGE = "Matrix's columns have to have the same number of elements";

    @ParameterizedTest
    @MethodSource
    void shouldCreateGardenMatrixObject(long[][] matrix) {
        //when
        GardenMatrix gardenMatrix = new GardenMatrix(matrix);

        //then
        assertThat(gardenMatrix.getGardenMatrixInstance(), is(matrix));
    }

    @ParameterizedTest
    @MethodSource
    void shouldThrowIncorrectMatrixException(long[][] matrix, String message) {
        //when
        Exception exception = assertThrows(IncorrectMatrixException.class, () -> new GardenMatrix(matrix));

        //then
        assertThat(exception.getMessage(), is(message));
    }

    public static Stream<long[][]> shouldCreateGardenMatrixObject() {
        long[][] matrix1 = {{1L}};
        long[][] matrix2 = {{1L, 2L}};
        long[][] matrix3 = {{1L}, {2L}};
        long[][] matrix4 = {{1L, 2L}, {1L, 2L}};
        long[][] matrix5 = {{1L, 1L}, {2L, 2L}};
        long[][] matrix6 = {{1L, 2L, 3L}, {1L, 2L, 3L}, {1L, 2L, 3L}};
        long[][] matrix7 = {{1L, 1L, 1L}, {2L, 2L, 2L}, {3L, 3L, 3L}};
        long[][] matrix8 = {{1L, 1L, 1L}, {1L, 5L, 1L}, {1L, 1L, 1L}};
        long[][] matrix9 = {{1L, 2L, 1L, 1L}, {1L, 5L, 1L, 1L}, {1L, 2L, 5L, 1L}};
        return Stream.of(matrix1, matrix2, matrix3, matrix4, matrix5, matrix6, matrix7, matrix8, matrix9);
    }

    private static Stream<Arguments> shouldThrowIncorrectMatrixException() {
        long[][] matrix1 = {};
        long[][] matrix2 = {{}};
        long[][] matrix3 = {{}, {2L}};
        long[][] matrix4 = {{1L, 2L}, {1L}};
        long[][] matrix5 = {{1L}, {2L, 2L}};
        long[][] matrix6 = {{1L, 1L, 1L}, {1L, 5L, 1L}, {1L}};
        return Stream.of(
                Arguments.of(matrix1, MATRIX_CANNOT_BE_EMPTY_EXCEPTION_MESSAGE),
                Arguments.of(matrix2, MATRIX_CANNOT_HAVE_EMPTY_COLUMNS_EXCEPTION_MESSAGE),
                Arguments.of(matrix3, MATRIX_CANNOT_HAVE_EMPTY_COLUMNS_EXCEPTION_MESSAGE),
                Arguments.of(matrix4, MATRIX_COLUMNS_HAVE_TO_HAVE_THE_SAME_NUMBER_OF_ELEMENTS_EXCEPTION_MESSAGE),
                Arguments.of(matrix5, MATRIX_COLUMNS_HAVE_TO_HAVE_THE_SAME_NUMBER_OF_ELEMENTS_EXCEPTION_MESSAGE),
                Arguments.of(matrix6, MATRIX_COLUMNS_HAVE_TO_HAVE_THE_SAME_NUMBER_OF_ELEMENTS_EXCEPTION_MESSAGE)
        );
    }
}