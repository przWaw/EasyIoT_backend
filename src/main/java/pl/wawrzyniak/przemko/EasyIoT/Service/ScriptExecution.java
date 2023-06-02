package pl.wawrzyniak.przemko.EasyIoT.Service;

import pl.wawrzyniak.przemko.EasyIoT.Model.ExecutableScript;
import pl.wawrzyniak.przemko.EasyIoT.Model.ScriptOutput;

import java.io.IOException;

public interface ScriptExecution {
    public ScriptOutput execute(ExecutableScript script) throws IOException;
}
