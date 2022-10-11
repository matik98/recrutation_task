package io;


import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.junit.MatcherAssert.assertThat;

class MatrixReaderTest {

    @Test
    void shouldConvertFileToMatrix() throws IOException, CsvException {
        //given
        Path filePath = Paths.get("src","test", "resources", "testMatrix.txt");
        System.out.println(filePath);
        long[][] expectedMatrix = {{1L, 2L, 3L}, {1L, 2L, 3L}, {1L, 2L, 3L}};

        //when
        long[][] matrix = MatrixReader.readMatrixFromFile(filePath);

        //then
        assertThat(matrix, is(expectedMatrix));
    }

}