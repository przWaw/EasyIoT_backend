package pl.wawrzyniak.przemko.EasyIoT.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.wawrzyniak.przemko.EasyIoT.Model.ExecutableScript;
import pl.wawrzyniak.przemko.EasyIoT.Model.FileDescription;
import pl.wawrzyniak.przemko.EasyIoT.Model.ScriptOutput;
import pl.wawrzyniak.przemko.EasyIoT.Service.FileManagerService;
import pl.wawrzyniak.przemko.EasyIoT.Service.MonoScriptExecutionService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/easyIoT/")
public class EasyIoTController {
    private FileManagerService fileService;
    private MonoScriptExecutionService monoScriptExecutor;

    @Autowired
    EasyIoTController(FileManagerService fileService, MonoScriptExecutionService monoScriptExecutor){
        this.fileService = fileService;
        this.monoScriptExecutor = monoScriptExecutor;
    }

    @GetMapping("scripts")
    public List<FileDescription> getAvailableScripts() throws IOException {
        return fileService.getAvailableScripts();
    }

    @PostMapping("exec/simple")
    public ScriptOutput executeSimpleScript(@RequestBody ExecutableScript script) throws IOException {
        return monoScriptExecutor.executeScript(script);
    }
}
