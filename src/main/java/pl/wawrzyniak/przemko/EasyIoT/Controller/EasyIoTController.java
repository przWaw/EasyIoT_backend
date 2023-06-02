package pl.wawrzyniak.przemko.EasyIoT.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.wawrzyniak.przemko.EasyIoT.Model.ExecutableScript;
import pl.wawrzyniak.przemko.EasyIoT.Model.FileDescription;
import pl.wawrzyniak.przemko.EasyIoT.Model.ScriptOutput;
import pl.wawrzyniak.przemko.EasyIoT.Service.BashCommandService;
import pl.wawrzyniak.przemko.EasyIoT.Service.FileManagerService;
import pl.wawrzyniak.przemko.EasyIoT.Service.MonoScriptExecutionService;
import pl.wawrzyniak.przemko.EasyIoT.Service.ScriptExecution;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/easyIoT/")
public class EasyIoTController {
    private FileManagerService fileService;
    private ScriptExecution monoScriptExecutor;
    private BashCommandService bashService;

    @Autowired
    EasyIoTController(FileManagerService fileService, MonoScriptExecutionService monoScriptExecutor, BashCommandService bash){
        this.fileService = fileService;
        this.monoScriptExecutor = monoScriptExecutor;
        this.bashService = bash;
    }
    @GetMapping("hostname")
    public String hostName() throws IOException {
        return bashService.introduction();
    }

    @GetMapping("scripts")
    public List<FileDescription> getAvailableScripts() throws IOException {
        return fileService.getAvailableScripts();
    }


    @PostMapping("exec/simple")
    public ScriptOutput executeSimpleScript(@RequestBody ExecutableScript script) throws IOException {
        return monoScriptExecutor.execute(script);
    }
}
