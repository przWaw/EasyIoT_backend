package pl.wawrzyniak.przemko.EasyIoT.Model;

import lombok.Data;

import java.util.List;

@Data
public class ScriptOutput {
    private List<String> outputMessage;
    private List<String> errorMessage;
}
