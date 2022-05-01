package objektwerks;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.junit.jupiter.api.Test;

class IOTest {
    String newFileName() {
        return "./target/" + UUID.randomUUID().toString() + ".txt";
    }

    @Test void createNewFileTest() throws IOException {
        var newFile = new File(newFileName());
        boolean success = newFile.createNewFile();
        assert(success);
    }
}