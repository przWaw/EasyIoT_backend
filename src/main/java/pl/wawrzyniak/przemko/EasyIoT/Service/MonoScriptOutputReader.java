package pl.wawrzyniak.przemko.EasyIoT.Service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class MonoScriptOutputReader {
    public List<String> readOutput(Process process) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
        List<String> output = new ArrayList<>();
        String line;
        while ((line = in.readLine()) != null) {
            output.add(line);
        }
        return output;
    }

    public List<String> readError(Process process) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        List<String> output = new ArrayList<>();
        String line;
        while ((line = in.readLine()) != null) {
            output.add(line);
        }
        return output;
    }
}
