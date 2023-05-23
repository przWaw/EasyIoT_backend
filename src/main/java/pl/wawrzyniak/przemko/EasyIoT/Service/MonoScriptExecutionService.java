package pl.wawrzyniak.przemko.EasyIoT.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.wawrzyniak.przemko.EasyIoT.Model.ExecutableScript;
import pl.wawrzyniak.przemko.EasyIoT.Model.ScriptOutput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MonoScriptExecutionService {
    @Value("${file.scriptPath}")
    private String scriptPath;

    @Value("${script.pythonInterpreter}")
    private String interpreter;

    private MonoScriptOutputReader monoReader;

    @Autowired
    MonoScriptExecutionService(MonoScriptOutputReader monoScriptOutputReader){
        monoReader = monoScriptOutputReader;
    }

    public ScriptOutput executeScript(ExecutableScript script) throws IOException {
        List<String> processCli = new ArrayList<>();
        processCli.add(interpreter);
        processCli.add("-u");
        processCli.add(scriptPath + script.getScriptName());
        if(script.getArguments() != null) {
            processCli.addAll(script.getArguments());
        }
        ProcessBuilder processBuilder = new ProcessBuilder(processCli);
        Process process = processBuilder.start();
        List<String> output = monoReader.readOutput(process);
        List<String> error = monoReader.readError(process);
        ScriptOutput scriptOutput = new ScriptOutput();
        scriptOutput.setOutputMessage(output);
        scriptOutput.setErrorMessage(error);
        return scriptOutput;
    }


}
