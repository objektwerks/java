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
        assert(newFile.createNewFile());
    }

    @Test void createFile() throws IOException {
        Path newFilePath = Paths.get(newFileName());
        var newFile = Files.createFile(newFilePath).toFile();
        assert(newFile.isFile());
    }

    @Test void fileOutputStreamTest() throws IOException {
        var fileName = newFileName();
        try(var stream = new FileOutputStream(fileName)) {
            stream.write("file output stream test".getBytes(StandardCharsets.UTF_8));
        }
        try(var stream = new FileInputStream(fileName)) {
            assert(stream.readAllBytes().length > 0);
        }
    }

    @Test void bufferredWriterTest() throws IOException {
        var fileName = newFileName();
        try(var writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.append("bufferred writer test");
        }
        try(var reader = new BufferedReader(new FileReader(fileName))) {
            assert(!reader.readLine().isEmpty());
        }
        try (var reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            assert(!reader.readLine().isEmpty());
        }
    }

    @Test void printWriterTest() throws IOException {
        var fileName = newFileName();
        try(var writer = new PrintWriter(new FileWriter(fileName))) {
            writer.print("print writer test");
        }
        try(var reader = new BufferedReader(new FileReader(fileName))) {
            assert(!reader.readLine().isEmpty());
        }
    }

    @Test void getResourceAsStreamTest() throws IOException {
        try(var stream = getClass().getClassLoader().getResourceAsStream("logback-test.xml")) {
            assert(stream.readAllBytes().length > 0);
        }
    }

    @Test void readAllLinesTest() throws IOException {
        var path = Paths.get("build.gradle.kts");
        assert(!Files.readAllLines(path).isEmpty());
    }
}