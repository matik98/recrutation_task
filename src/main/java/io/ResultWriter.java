package io;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResultWriter {
    public static void saveResultToFile(long result, String filepath) throws IOException {
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(filepath, true))) {
                writer.append(Long.toString(result));
            }
    }
}
