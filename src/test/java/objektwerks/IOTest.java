package objektwerks;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class IOTest {
    @BeforeAll static void setup() throws IOException {
        var targetDirectory = Paths.get("./target");
        if (!Files.exists(targetDirectory)) {
            var directoryPath = Files.createDirectory(targetDirectory);
            assert(Files.isDirectory(directoryPath));
        }
    }

    String newFileName() {
        return "./target/" + UUID.randomUUID().toString().substring(0, 7) + ".txt";
    }

    String newDirectoryName() {
        return "./target/" + UUID.randomUUID().toString().substring(0, 7);
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

    @Test void existsTest() {
        var filePath = Paths.get("pom.xml");
        assert (Files.exists(filePath));
    }

    @Test void isDirectoryTest() throws IOException {
        var newDirectoryPath = Path.of(newDirectoryName());
        var directoryPath = Files.createDirectory(newDirectoryPath);
        assert(Files.isDirectory(directoryPath));
    }

    @Test void fileOutputInputStreamTest() throws IOException {
        var fileName = newFileName();
        try(var stream = new FileOutputStream(fileName)) {
            stream.write("file output stream test".getBytes(StandardCharsets.UTF_8));
        }
        try(var stream = new FileInputStream(fileName)) {
            assert(stream.readAllBytes().length > 0);
        }
    }

    @Test void bufferredWriterReaderTest() throws IOException {
        var fileName = newFileName();
        try(var writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.append("bufferred writer test");
        }
        try (var reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            assert(!reader.readLine().isEmpty());
        }
    }

    @Test void printWriterReaderTest() throws IOException {
        var fileName = newFileName();
        try(var writer = new PrintWriter(new FileWriter(fileName))) {
            writer.print("print writer test");
        }
        try(var reader = new BufferedReader(new FileReader(fileName))) {
            assert(!reader.readLine().isEmpty());
        }
    }

    @Test void linesTest() throws URISyntaxException, IOException {
        var path = Paths
            .get(
                Objects
                    .requireNonNull(getClass()
                    .getClassLoader()
                    .getResource("logback-test.xml"))
                    .toURI()
            );
        try(var stream = Files.lines(path)) {
            assert(!stream.toList().isEmpty());
        }
    }

    @Test void readAllLinesTest() throws IOException {
        var path = Paths.get("LICENSE");
        assert(!Files.readAllLines(path).isEmpty());
    }

    @Test void getResourceAsStreamTest() throws IOException {
        try(var stream = getClass().getClassLoader().getResourceAsStream("logback-test.xml")) {
            assert(Objects.requireNonNull(stream).readAllBytes().length > 0);
        }
    }
}