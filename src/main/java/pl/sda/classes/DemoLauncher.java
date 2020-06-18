package pl.sda.classes;

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
            byte[] array = new byte[7]; // length is bounded by 7
            new Random().nextBytes(array);
            String name = new String(array, Charset.forName("UTF-8"));
            String surname = name;

            Random randomizer = new Random();

            Diagnosis diagnosis = Diagnosis.valueOf(randomizer.nextInt(3));
            PatientFeeling feeling = PatientFeeling.valueOf(randomizer.nextInt(5));
            Patient patient = new Patient(name, surname, feeling, diagnosis);
            patientList.add(patient);
        }

        patientList.add(new Patient("Adam", "Kowalski", PatientFeeling.fine, Diagnosis.fever));
        patientList.add(new Patient("Adam", "Kret", PatientFeeling.fine, Diagnosis.serious));

        return patientList;
    }
}
