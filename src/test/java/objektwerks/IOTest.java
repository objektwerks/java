package objektwerks;

import java.io.File;
import java.io.IOException;
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
}