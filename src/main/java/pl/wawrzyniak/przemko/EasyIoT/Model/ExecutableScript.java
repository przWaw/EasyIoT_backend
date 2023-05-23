package pl.wawrzyniak.przemko.EasyIoT.Model;

import lombok.Data;

import java.util.List;

@Data
public class ExecutableScript {
    private String scriptName;
    private List<String> arguments;
}
