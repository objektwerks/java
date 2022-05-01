package objektwerks;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.junit.jupiter.api.Test;

class IOTest {
    String newFileName() {
        return "./target/" + UUID.randomUUID() + ".txt";
    }

    @Test void createNewFileTest() throws IOException {
        var newFile = new File(newFileName());
        boolean success = newFile.createNewFile();
        assert(success);
    }

    @Test void createFile() throws IOException {
        Path newFilePath = Paths.get(newFileName());
        var newFile = Files.createFile(newFilePath).toFile();
        assert(newFile.isFile());
    }

    @Test void fileOutputStreamTest() throws IOException {
        try(var fileOutputStream = new FileOutputStream(newFileName())) {
            fileOutputStream.write("file output stream test".getBytes(StandardCharsets.UTF_8));
        }
    }

    @Test void bufferredWriterTest() throws IOException {
        var writer = new BufferedWriter(new FileWriter(newFileName(), true));
        writer.append("bufferred writer test");
        writer.close();
    }
}