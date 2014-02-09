/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package croz.parser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stojan
 */
public class IOUtils {

    @Deprecated
    public byte[] readSmallFileBytes(String name) {
        byte[] filearray = null;
        try {
            Path path = FileSystems.getDefault().getPath(".", name);
            return Files.readAllBytes(path);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return filearray;
    }

    public List<String> readAllLines(String path, String name) throws IOException {
        return Files.readAllLines(
                FileSystems.getDefault().getPath(path, name),
                Charset.defaultCharset());
    }

    public List<String> readLargeFileLines(String name) {
        try {
            BufferedReader reader
                    = Files.newBufferedReader(
                            FileSystems.getDefault().getPath(".", name),
                            Charset.defaultCharset());

            List<String> lines = new ArrayList<>();
            String line = null;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            return lines;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

    public List<String> readLargeFileLinesMixed(String name) {
        try {
            Path path = FileSystems.getDefault().getPath(".", name);
            InputStream in = Files.newInputStream(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            List<String> lines = new ArrayList<>();
            String line = null;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            return lines;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return null;
    }

    public void writeFileBytes(String path, String filename, String content) throws IOException {
        Files.write(FileSystems.getDefault().getPath(path, filename),
                content.getBytes(),
                StandardOpenOption.APPEND);
    }

    void writeFileBytesBuffered(String filename, String content) {
        try {
            BufferedWriter writer
                    = Files.newBufferedWriter(
                            FileSystems.getDefault().getPath(".", filename),
                            Charset.forName("US-ASCII"),
                            StandardOpenOption.CREATE);

            writer.write(content, 0, content.length());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public Path createFile(String path, String fileName) throws IOException {
        Path newFile = FileSystems.getDefault().getPath(path, fileName);
        Files.deleteIfExists(newFile);
        return Files.createFile(newFile);
    }

    public BufferedWriter openFileForWriting(String path, String fileName, Charset charset) throws IOException {
//        Path newFile = createFile(path, fileName);
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
