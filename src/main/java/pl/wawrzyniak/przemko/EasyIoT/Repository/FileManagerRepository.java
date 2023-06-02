package pl.wawrzyniak.przemko.EasyIoT.Repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FileManagerRepository {
    @Value("${file.scriptPath}")
    private String scriptPath;
    @Value("${file.descriptionPath}")
    private String descriptionPath;

    public List<File> getScripts() {
        File dir = new File(scriptPath);
        File[] files = dir.listFiles((dir1, name) -> name.endsWith("hello.py"));
        if (files == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(List.of(files));
    }

    public List<File> getDescriptions() {
        File dir = new File(descriptionPath);
        File[] files = dir.listFiles((dir1, name) -> name.endsWith(".json"));
        if (files == null) {
            return new ArrayList<>();
        }
        return new ArrayList(List.of(files));
    }
}
