package Picnic.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoadFruitsFromFile {
    List<String> rawFruits;

    public LoadFruitsFromFile(String fileName) {
        try (FileReader file=new FileReader(fileName)){
            rawFruits = new ArrayList<>();
            BufferedReader reader = new BufferedReader(file);
            String line;
            while ((line = reader.readLine()) != null){
                rawFruits.addAll(Arrays.asList(line.split(" ")));
            }
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    public List<String> getRawFruits(){
        return rawFruits;
    }
}