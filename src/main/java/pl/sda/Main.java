package pl.sda;

import pl.sda.classes.DemoLauncher;
import pl.sda.classes.HospitalQueue;
import pl.sda.classes.Patient;
import pl.sda.enums.Diagnosis;
import pl.sda.enums.PatientFeeling;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final HospitalQueue hospitalQueue = new HospitalQueue();
    public static void main(String[] args) {
        /*
            Twoim zadaniem jest napisanie aplikacji służącej do decydowania o kolejności przyjęć w szpitalu.
            Aplikacja powinna pozwalać na:
                a Rejestrację nowego pacjenta, chyba ze dlugosc kolejki jest wieksza niz 20
                b Pobieranie następnej osoby z kolejki
                c Podglądanie kto jest następny w kolejce
                d Posiadać tryb demo w którym:
                e zamiast ręcznie dodawać osoby aplikacja będzie startowała z 10 osobami w kolejce
            3. W main stwórz menu:
                a Następny - wywołujące next i wypisujące co zostało z tego next zwrócone
                b Kto następny - wywołujące peek() i wypisujące kto jest następny
                c Nowy pacjent - umożliwiające podanie imienia, nazwiska, złości i rozpoznanej choroby, a następnie wrzucające to na kolejkę (te dane pobierz za pomocą Scannera)
            4.* Zamiast przechowywac rozpoznana chorobe w Stringu trzymaj ja jako klase - razem
            5. Tryb demo:
                a Co 2 sekundy aplikacja dodaje losową osobę (losujemy imię, nazwisko, chorobę z tablicy, jak bardzo zły - losujemy liczbę)
                b Co 2 sekundy + random max 1s aplikacja przyjmuje pacjenta



         */

        String option = "";
        String name = "";
        String surname = "";
        Diagnosis patientDiagnosis;
        PatientFeeling patientFeeling ;
        Scanner scanner = new Scanner(System.in);

        launchDemo();

        do {

            if(option.isEmpty()) {
                System.out.println("Menu:");
                System.out.println("1. Next patient");
                System.out.println("2. Check whos next");
                System.out.println("3. New patient");
                System.out.println("q. quit");

                option = scanner.nextLine();
            }


            if ("1".equals(option)) {
                try {
                    System.out.println("Next patient is, let him in:");
                    Patient patient = hospitalQueue.next();
                    if(patient == null)
                        throw new Exception("No patients in the queue.");
                    System.out.println(String.format("%s %s", patient.getName(), patient.getSurname()));
                    option = "";
                }catch (Exception e){
                    System.err.println(e.getMessage());
                    option = "";
                }

            } else if("2".equals(option)) {
                try {
                    System.out.println("Next patient is:");
                    Patient patient = hospitalQueue.peek();
                    if(patient == null)
                        throw new Exception("No patients in the queue.");
                    System.out.println(String.format("%s %s", patient.getName(), patient.getSurname()));
                    option = "";
                }catch(Exception e){
                    System.err.println(e.getMessage());
                    option = "";
                }
                option = "";
            }else if("3".equals(option)){
                System.out.println("Enter new patient data.");
                System.out.println("Name:");
                name = scanner.nextLine();
                System.out.println("Surname");
                surname = scanner.nextLine();
                System.out.println("Diagnosis");

                for(Diagnosis diagnosis : Diagnosis.values()){
                    System.out.println(diagnosis.getId() + ". " + diagnosis.getValue());
                }
                patientDiagnosis = Diagnosis.valueOf(scanner.nextInt());

                System.out.println("Feeling");

                for(PatientFeeling feeling : PatientFeeling.values()){
                    System.out.println(feeling.getId() + ". " + feeling.name());
                }
                patientFeeling = PatientFeeling.valueOf(scanner.nextInt());

                Patient newPatient = new Patient(name, surname, patientFeeling, patientDiagnosis);
                hospitalQueue.add(newPatient);
                System.out.println("New patient added to queue");

                option = "";
            }

        } while (!"q".equals(option));
    }

    public static void launchDemo(){
        List<Patient> patientList = DemoLauncher.generatePatients(10);
        for(Patient patient : patientList){
            hospitalQueue.add(patient);
        }
    }
}
