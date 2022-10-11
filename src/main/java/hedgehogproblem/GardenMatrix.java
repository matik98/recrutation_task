package hedgehogproblem;

import lombok.Getter;

class GardenMatrix {
    private static final String MATRIX_CANNOT_BE_EMPTY_EXCEPTION_MESSAGE = "Matrix cannot be empty";
    private static final String MATRIX_CANNOT_HAVE_EMPTY_COLUMNS_EXCEPTION_MESSAGE = "Matrix cannot have empty columns";
    private static final String MATRIX_COLUMNS_HAVE_TO_HAVE_THE_SAME_NUMBER_OF_ELEMENTS_EXCEPTION_MESSAGE = "Matrix's columns have to have the same number of elements";

    @Getter
    private final long[][] gardenMatrixInstance;

    public GardenMatrix(long[][] gardenMatrixInstance) {
        this.validateMatrixInstance(gardenMatrixInstance);
        this.gardenMatrixInstance = gardenMatrixInstance;
    }

    public long getField(int column, int row) {
        return gardenMatrixInstance[column][row];
    }

    public int getColumnsCount() {
        return gardenMatrixInstance.length;
    }

    public int getRowsCount() {
        return gardenMatrixInstance[0].length;
    }

    private void validateMatrixInstance(long[][] gardenMatrixInstance) {
        if (gardenMatrixInstance.length == 0) {
            throw new IncorrectMatrixException(MATRIX_CANNOT_BE_EMPTY_EXCEPTION_MESSAGE);
        }
        int firstColumnLength = gardenMatrixInstance[0].length;
        if (firstColumnLength == 0) {
            throw new IncorrectMatrixException(MATRIX_CANNOT_HAVE_EMPTY_COLUMNS_EXCEPTION_MESSAGE);
        }
        for (long[] column : gardenMatrixInstance) {
            if (column.length != firstColumnLength) {
                throw new IncorrectMatrixException(MATRIX_COLUMNS_HAVE_TO_HAVE_THE_SAME_NUMBER_OF_ELEMENTS_EXCEPTION_MESSAGE);
            }
        }
    }

}
