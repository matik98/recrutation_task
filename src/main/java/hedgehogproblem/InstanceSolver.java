package hedgehogproblem;

import lombok.Getter;


@Getter
class InstanceSolver {
    private final GardenMatrix gardenMatrix;
    private long[] tempSumsOfApplesBeforeReachingTree;

    public InstanceSolver(long[][] gardenMatrixInstance) {
        this.gardenMatrix = new GardenMatrix(gardenMatrixInstance);
    }

    public long process() {
        if(gardenMatrix.getRowsCount() < gardenMatrix.getColumnsCount()) {
            return processOverColumns();
        } else {
            return processOverRows();
        }
    }

    private long processOverRows() {
        int columnsCount = gardenMatrix.getColumnsCount();
        int rowsCount = gardenMatrix.getRowsCount();
        tempSumsOfApplesBeforeReachingTree = new long[columnsCount];
        for (int rowNum = 0; rowNum < rowsCount; rowNum++) {
            for (int colNum = 0; colNum < gardenMatrix.getColumnsCount(); colNum++) {
                processCurrentTree(colNum, gardenMatrix.getField(colNum, rowNum));
            }
        }
        return tempSumsOfApplesBeforeReachingTree[tempSumsOfApplesBeforeReachingTree.length - 1];
    }

    private long processOverColumns() {
        int columnsCount = gardenMatrix.getColumnsCount();
        int rowsCount = gardenMatrix.getRowsCount();
        tempSumsOfApplesBeforeReachingTree = new long[rowsCount];
        for (int colNum = 0; colNum < columnsCount; colNum++) {
            for (int rowNum = 0; rowNum < rowsCount; rowNum++) {
                processCurrentTree(rowNum, gardenMatrix.getField(colNum, rowNum));
            }
        }
        return tempSumsOfApplesBeforeReachingTree[tempSumsOfApplesBeforeReachingTree.length - 1];
    }

    private void processCurrentTree(int currentPosition, long applesUnderCurrentTree) {
        long currentApplesCount = tempSumsOfApplesBeforeReachingTree[currentPosition] + applesUnderCurrentTree;
        replaceAplesCountForNextTreeIfBetter(currentPosition, currentApplesCount);
        tempSumsOfApplesBeforeReachingTree[currentPosition] = currentApplesCount;
    }

    private void replaceAplesCountForNextTreeIfBetter(int currentPosition, long currentApplesCount) {
        if (hasNextTreeInLine(currentPosition) && isCurrentPathBetterForNexTreeInLine(currentPosition, currentApplesCount)) {
            tempSumsOfApplesBeforeReachingTree[currentPosition + 1] = currentApplesCount;
        }
    }

    private boolean isCurrentPathBetterForNexTreeInLine(int currentPosition, long currentApplesCount) {
        return tempSumsOfApplesBeforeReachingTree[currentPosition + 1] < currentApplesCount;
    }

    private boolean hasNextTreeInLine(int position) {
        return position < tempSumsOfApplesBeforeReachingTree.length - 1;
    }

}


