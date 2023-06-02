package pl.wawrzyniak.przemko.EasyIoT.Service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class BashCommandService {
    public String introduction() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("hostname");
        Process process = processBuilder.start();
        BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
        return in.readLine();
    }
}
