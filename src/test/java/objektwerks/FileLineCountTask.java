package objektwerks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

class FileLineCountTask implements Callable<Integer> {
    String file;

    Integer fileLineCount(String file) {
        try {
            var path = Paths.get(file);
            return Files.readAllLines(path).size();
        } catch(IOException ioe) {
            return -1;
        }
    }

    public FileLineCountTask(String file) {
        this.file = file;
    }

    @Override
    public Integer call() {
        return fileLineCount(file);
    }
}