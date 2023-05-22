package pl.wawrzyniak.przemko.EasyIoT.Model;

import lombok.Data;

@Data
public class FileDescription {
    private String scriptName;
    private InputType inputType;
    private Integer numberOfArguments;
}
