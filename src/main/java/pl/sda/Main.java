package pl.sda;

import java.util.Scanner;

public class Main {
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
            6. Zamiast przyjmować pacjentów w kolejności naturalnej przyjmuj ich według priorytetu:
                a Metoda next powinna zwracać najpierw osoby o nazwisku “Kowalski” (to nazwisko ordynatora),
                   ** pomyśl w przyszłości o ładowaniu jej z pliku properties za pomocą klasy Properties
                b w następnej kolejności powinna zwracać osoby z czymś poważnym (nazwa choroby "cos powaznego")
                c dalej osoby, których iloczyn jakBardzoZly i zaraźliwość będzie wyższy


         */

        String option = "";
        String name = "";
        String surname = "";
        String diagnosis = "";
        PatientFeeling patientFeeling ;
        Scanner scanner = new Scanner(System.in);
        HospitalQueue hospitalQueue = new HospitalQueue();

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
                }catch (Exception e){
                    System.err.println(e.getMessage());
                }

            } else if("2".equals(option)) {
                try {
                    System.out.println("Next patient is:");
                    Patient patient = hospitalQueue.peek();
                    if(patient == null)
                        throw new Exception("No patients in the queue.");
                    System.out.println(String.format("%s %s", patient.getName(), patient.getSurname()));
                }catch(Exception e){
                    System.err.println(e.getMessage());
                }
                option = "";
            }else if("3".equals(option)){
                System.out.println("Enter new patient data.");
                System.out.println("Name:");
                name = scanner.nextLine();
                System.out.println("Surname");
                surname = scanner.nextLine();
                System.out.println("Diagnosis");
                diagnosis = scanner.nextLine();
                System.out.println("Feeling");

                int i = 1;
                for(PatientFeeling feeling : PatientFeeling.values()){
                    System.out.println(i + ". " + feeling.name());
                    i++;
                }
                patientFeeling = PatientFeeling.valueOf(scanner.nextInt());

                Patient newPatient = new Patient(name, surname, patientFeeling, diagnosis);
                hospitalQueue.add(newPatient);
                System.out.println("New patient added to queue");

                option = "";
            }

        } while (!"q".equals(option));
    }
}
