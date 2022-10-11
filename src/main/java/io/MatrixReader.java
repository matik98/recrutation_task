package io;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MatrixReader {
    public static long[][] readMatrixFromFile(Path pathToFile) throws IOException, CsvException {
        try (Reader reader = Files.newBufferedReader(pathToFile)) {
            CSVParser parser = new CSVParserBuilder()
                    .withSeparator(' ')
                    .withIgnoreQuotations(true)
                    .build();
            CSVReaderBuilder builder = new CSVReaderBuilder(reader)
                    .withCSVParser(parser)
                    .withSkipLines(1);
            try (CSVReader csvReader = builder.build()) {
                return csvReader.readAll()
                        .stream()
                        .map(MatrixReader::mapToLongArray)
                        .collect(Collectors.toList())
                        .toArray(long[][]::new);
            }
        }
    }

    private static long[] mapToLongArray(String[] matrixRow) {
        long[] convertedColumn = new long[matrixRow.length];
        for (int i = 0; i < matrixRow.length; i++) {
            convertedColumn[i] = Long.parseLong(matrixRow[i]);
        }
        return convertedColumn;
    }
}
