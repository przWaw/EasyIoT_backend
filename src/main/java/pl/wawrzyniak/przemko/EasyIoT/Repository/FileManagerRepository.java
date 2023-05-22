package pl.wawrzyniak.przemko.EasyIoT.Repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class FileManagerRepository {
    @Value("${file.scriptPath}")
    private String scriptPath;
    @Value("${file.descriptionPath}")
    private String descriptionPath;
    public List<File> getScripts(){
        File dir = new File(scriptPath);
        File[] files = dir.listFiles((dir1, name) -> name.endsWith(".py"));
        return List.of(files);
    }

    public List<File> getDescriptions(){
        File dir = new File(descriptionPath);
        File[] files = dir.listFiles((dir1, name) -> name.endsWith(".txt"));
        return List.of(files);
    }
}
