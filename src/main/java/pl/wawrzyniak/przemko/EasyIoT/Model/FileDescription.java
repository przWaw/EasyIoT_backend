package pl.wawrzyniak.przemko.EasyIoT.Model;

import lombok.Data;

import java.util.List;

@Data
public class FileDescription {
    private String scriptName;
    private InputType inputType;
    private RequestType requestType;
    private List<String> arguments;
    private String description;
}
