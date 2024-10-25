package Exceptions.Model;

import Exceptions.Control.DataValidation;
import Exceptions.View.DataInterface;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class SaveToFile implements SaveInterface {
    public void save(DataInterface input){
        DataValidation dataValidation = new DataValidation();
        String[] data =  dataValidation.validation(input);
        String lastName = data[0];
        String firstName = data[1];
        String patronymic = data[2];
        String dateOfBirth = data[3];
        String phoneNumber = data[4];
        String gender = data[5];
        String fileName = lastName + ".txt";
        try (FileWriter writer = new FileWriter(new File(fileName), true)) {
            writer.write(lastName + " " + firstName + " " + patronymic + " " + dateOfBirth + " " + phoneNumber + " " + gender + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}