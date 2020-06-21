package pl.sda;

import pl.sda.enums.Diagnosis;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class HospitalQueue {
//    2. Utwórz klasę HospitalQueue, która
//        a ma pole typu Queue (patientQueue)
//        b utwórz metodę add(Patient) -> dodaje pacjenta
//        c utwórz metodę Patient next() -> zwracającą kolejną osobę z kolejki i usuwającą ją z niej
//        d Patient peek() -> podglądającą kto jest (zwraca kolejną osobę bez usuwania jej z kolejki)

//    6. Zamiast przyjmować pacjentów w kolejności naturalnej przyjmuj ich według priorytetu:
//        a Metoda next powinna zwracać najpierw osoby o nazwisku “Kowalski” (to nazwisko ordynatora),
//                ** pomyśl w przyszłości o ładowaniu jej z pliku properties za pomocą klasy Properties
//        b w następnej kolejności powinna zwracać osoby z czymś poważnym (nazwa choroby "cos powaznego")
//        c dalej osoby, których iloczyn jakBardzoZly i zaraźliwość będzie wyższy
    private final Queue<Patient> patientQueue;
    private final List<Doctor> doctorList;

    public HospitalQueue(){
        doctorList = new ArrayList<>();
        patientQueue = new PriorityQueue<>(new HospitalQueueComparator());
    }

    public void add(Patient patient){
        try {
            if (patientQueue.size() >= 20)
                throw new Exception("Patient queue is too long to add next patient, try again later.");
            patientQueue.add(patient);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public void add(Doctor doctor){
        doctorList.add(doctor);
    }

    public Visit next(){
        Patient patient = patientQueue.peek();
        try{
            if(patient == null){
                throw new NullPointerException("No more patients");
            }
            for(Doctor doctor : doctorList){
                for(Diagnosis diagnosis : doctor.getSpecialization().getHandles()){
                    if(patient.getDiagnosis().equals(diagnosis)) {
                        return new Visit(doctor,patientQueue.poll());
                    }
                }
            }
            patientQueue.poll();
            throw new Exception(String.format("No doctor with a knowledge to help you, %s %s go to another place!", patient.getName(), patient.getSurname()));
        }catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public Patient peek(){
        return patientQueue.peek();
    }
}
