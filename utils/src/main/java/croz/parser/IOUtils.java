/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package croz.parser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 *
 * @author stojan
 */
public class IOUtils {

    public List<String> readAllLines(String path, String name) throws IOException {
        return Files.readAllLines(
                FileSystems.getDefault().getPath(path, name),
                Charset.defaultCharset());
    }

    public void readAllLinesLargeFile(String path, String name, LineProcessor processor) throws IOException {
        BufferedReader reader
                = Files.newBufferedReader(
                        FileSystems.getDefault().getPath(path, name),
                        Charset.defaultCharset());

        String line;
        while ((line = reader.readLine()) != null) {
            processor.processLine(line);
        }

    }

    public Path createFile(String path, String fileName) throws IOException {
        Path newFile = FileSystems.getDefault().getPath(path, fileName);
        Files.deleteIfExists(newFile);
        return Files.createFile(newFile);
    }

    public BufferedWriter openFileForWriting(String path, String fileName, Charset charset) throws IOException {
        Path newFile = FileSystems.getDefault().getPath(path, fileName);
        BufferedWriter writer
                = Files.newBufferedWriter(newFile, charset);
        return writer;
    }

    public void finishWriting(BufferedWriter writer) throws IOException {
        writer.flush();
        writer.close();
    }

}
