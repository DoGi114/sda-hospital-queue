package pl.sda;

import pl.sda.enums.Diagnosis;
import pl.sda.enums.DoctorsSpecialization;
import pl.sda.enums.PatientFeeling;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    private static final HospitalQueue hospitalQueue = new HospitalQueue();
    public static void main(String[] args) {
        String option = "";
        String name;
        String surname;
        Diagnosis patientDiagnosis;
        PatientFeeling patientFeeling ;
        Timer addRandomPerson = new Timer();
        Timer getPatient = new Timer();
        Scanner scanner = new Scanner(System.in);

        generateDoctors();

        try {
            do {

                if (option.isEmpty()) {
                    System.out.println("Menu:");
                    System.out.println("1. Next patient");
                    System.out.println("2. Check whos next");
                    System.out.println("3. New patient");
                    System.out.println("4. Launch demo");
                    System.out.println("q. quit");

                    option = scanner.nextLine();
                }


                if ("1".equals(option)) {
                    try {
                        System.out.println("Next patient is, let him in:");
                        Visit visit = hospitalQueue.next();
                        if (visit == null) {
                            throw new Exception("No patients in the queue.");
                        }
                        System.out.println(String.format("Patient %s %s with %s, go to %s %s", visit.getPatient().getName(),
                                visit.getPatient().getSurname(),
                                visit.getPatient().getDiagnosis().name(),
                                visit.getDoctor().getName(),
                                visit.getDoctor().getSurname()));
                        option = "";
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                        option = "";
                    }

                } else if ("2".equals(option)) {
                    try {
                        System.out.println("Next patient is:");
                        Patient patient = hospitalQueue.peek();
                        if (patient == null)
                            throw new Exception("No patients in the queue.");
                        System.out.println(String.format("%s %s", patient.getName(), patient.getSurname()));
                        option = "";
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                        option = "";
                    }
                    option = "";
                } else if ("3".equals(option)) {
                    System.out.println("Enter new patient data.");
                    System.out.println("Name:");
                    name = scanner.nextLine();
                    System.out.println("Surname");
                    surname = scanner.nextLine();
                    System.out.println("Diagnosis");

                    for (Diagnosis diagnosis : Diagnosis.values()) {
                        System.out.println(String.format("%s. %s", diagnosis.getId(), diagnosis.getValue()));
                    }
                    patientDiagnosis = Diagnosis.valueOf(scanner.nextInt());

                    System.out.println("Feeling");

                    for (PatientFeeling feeling : PatientFeeling.values()) {
                        System.out.println(String.format("%s. %s", feeling.getId(), feeling.name()));
                    }
                    patientFeeling = PatientFeeling.valueOf(scanner.nextInt());

                    Patient newPatient = new Patient(name, surname, patientFeeling, patientDiagnosis);
                    hospitalQueue.add(newPatient);
                    System.out.println("New patient added to queue");

                    option = "";
                } else if ("4".equals(option)) {
                    addRandomPerson.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            generatePatients(1);
                        }
                    }, 0, 2000);

                    getPatient.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            Visit visit = hospitalQueue.next();
                            if(visit != null) {
                                System.out.println(String.format("Patient %s %s with %s, go to %s %s", visit.getPatient().getName(),
                                        visit.getPatient().getSurname(),
                                        visit.getPatient().getDiagnosis().name(),
                                        visit.getDoctor().getName(),
                                        visit.getDoctor().getSurname()));
                            }
                        }
                    }, 1000, 3000);
                    option = "";
                }

            } while (!"q".equals(option));
        }finally {
            System.out.println("Goodbye!");
            getPatient.cancel();
            addRandomPerson.cancel();
        }
    }

    private static void generateDoctors(){
        hospitalQueue.add(new Doctor("Andrzej", "Kowalski", DoctorsSpecialization.surgeon, BigDecimal.valueOf(10_000)));
        hospitalQueue.add(new Doctor("Adam", "Kot", DoctorsSpecialization.common, BigDecimal.valueOf(5_000)));

    }

    private static void generatePatients(int number){
        List<Patient> patientList = DemoLauncher.generatePatients(number);
        for(Patient patient : patientList){
            hospitalQueue.add(patient);
        }
    }
}
