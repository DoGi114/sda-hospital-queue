package pl.sda;

import java.util.LinkedList;
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

    public HospitalQueue(){
        patientQueue = new PriorityQueue<>();
    }

    public void add(Patient patien){
        try {
            if (patientQueue.size() >= 20)
                throw new Exception("Patient queue is too long to add next patient, try again later.");
            patientQueue.add(patien);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public Patient next(){
        return patientQueue.poll();
    }

    public Patient peek(){
        return patientQueue.peek();
    }
}
