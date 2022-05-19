package CTCI;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;

public class TestBase {
    protected void assertEqualMatrix(int [][] expectedMatrix, int[][] actualMatrix) {

        SoftAssertions softAssert = new SoftAssertions();
        int expectedRow = expectedMatrix.length;
        int expectedCol = expectedMatrix[0].length;

        int actualRow = actualMatrix.length;
        int actualCol = actualMatrix[0].length;

        softAssert.assertThat(expectedRow).describedAs("Row is not equal").isEqualTo(actualRow);
        softAssert.assertThat(expectedCol).describedAs("Col is not equal").isEqualTo(actualCol);

        for(int i = 0; i < expectedRow; i++) {
            for (int j = 0; j < expectedCol; j++) {
                int expectedVal = expectedMatrix[i][j];
                int actualVal = actualMatrix[i][j];
                softAssert.assertThat(expectedVal).describedAs("Value at row %d and col %d is not equal",i,j).isEqualTo(actualVal);
            }
        }
        softAssert.assertAll();
    }
}
