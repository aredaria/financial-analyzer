package app.financial.analyzer;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {
    Path filePath;

    public FileManager(Path filePath) throws IOException {
        if (filePath != null) {
            this.filePath = filePath;
        }
        else throw new NullPointerException("FilePath can not be null");
        createFile(this.filePath);
    }

    public boolean createFile (Path filePath) throws IOException {
        if (!Files.exists(filePath)) {
            createDirectories(filePath);
            try {
                Files.createFile(filePath);
            } catch (IOException exception) {
                return false;
            }
        }
        return true;
    }

    private void createDirectories(Path filePath) throws IOException {
        String path = filePath.toString();
        String[] arrayOfDirectories = path.split("/");
        if (arrayOfDirectories.length == 0) return;
        String finalPath = "";
        for (int i = 0, exceptLast = arrayOfDirectories.length - 1; i < exceptLast; i++) {
            finalPath = finalPath + arrayOfDirectories[i];
            Path currDir = Paths.get(finalPath);
            Files.createDirectory(currDir);
            if (i != exceptLast - 1) finalPath = finalPath + "/";
        }
    }
}
