package pl.sda;

import pl.sda.enums.Diagnosis;
import pl.sda.enums.PatientFeeling;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DemoLauncher {
    public static List<Patient> generatePatients(int i){
        List<Patient> patientList = new ArrayList<>();

        for(int j = 0; j < i ; j++){

            String name = RandomStringGenerator.generate();
            String surname = RandomStringGenerator.generate();

            Random randomizer = new Random();

            Diagnosis diagnosis = Diagnosis.valueOf(randomizer.nextInt(4));
            PatientFeeling feeling = PatientFeeling.valueOf(randomizer.nextInt(5));
            Patient patient = new Patient(name, surname, feeling, diagnosis);
            patientList.add(patient);
        }

        return patientList;
    }
}
