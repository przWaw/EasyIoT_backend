package pl.wawrzyniak.przemko.EasyIoT.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import pl.wawrzyniak.przemko.EasyIoT.Model.FileDescription;
import pl.wawrzyniak.przemko.EasyIoT.Repository.FileManagerRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileManagerService {
    private FileManagerRepository fileRepository;
    private ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    FileManagerService(FileManagerRepository fileManagerRepository){
        this.fileRepository = fileManagerRepository;
    }

    public List<FileDescription> getAvailableScripts() throws IOException {
        List<FileDescription> availableScripts = null;
        List<File> scripts = fileRepository.getScripts();
        List<File> descriptions = fileRepository.getDescriptions();
        for (File script : scripts) {
            for (File description : descriptions) {
                if (getBaseName(script.getName()) == getBaseName(description.getName())) {
                    FileDescription fileDescription = objectMapper.readValue(description, FileDescription.class);
                    availableScripts.add(fileDescription);
                }
            }
        }
        return availableScripts;
    }

    private String getBaseName(String fileName){
        int index = fileName.lastIndexOf('.');
        if (index == -1) {
            return fileName;
        } else {
            return fileName.substring(0, index);
        }
    }
}
