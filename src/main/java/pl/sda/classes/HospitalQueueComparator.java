package pl.sda.classes;

import pl.sda.enums.Diagnosis;

import java.util.Comparator;

public class HospitalQueueComparator implements Comparator<Patient> {

//    6. Zamiast przyjmować pacjentów w kolejności naturalnej przyjmuj ich według priorytetu:
//        a Metoda next powinna zwracać najpierw osoby o nazwisku “Kowalski” (to nazwisko ordynatora),
//                ** pomyśl w przyszłości o ładowaniu jej z pliku properties za pomocą klasy Properties
//        b w następnej kolejności powinna zwracać osoby z czymś poważnym (nazwa choroby "cos powaznego")
//        c dalej osoby, których iloczyn jakBardzoZly i zaraźliwość będzie wyższy
// nie bylo nic o zarazliwosc w klasie pacjent wiec pominalem to

    @Override
    public int compare(Patient patient1, Patient patient2) {
        String NAME = "Kowalski";

        if(patient1.getSurname().equals(NAME) && !patient2.getSurname().equals(NAME)){
            return 1;
        }else if(patient2.getSurname().equals(NAME) && !patient1.getSurname().equals(NAME)){
            return -1;
        }else{
            if(patient1.getDiagnosis().equals(Diagnosis.serious) && !patient2.getDiagnosis().equals(Diagnosis.serious)){
                return 1;
            }else if(patient2.getDiagnosis().equals(Diagnosis.serious) && !patient1.getDiagnosis().equals(Diagnosis.serious)){
                return -1;
            }else{
                return Integer.compare(patient1.getPatientFeeling().getId(), patient2.getPatientFeeling().getId());
            }

        }
//        if(patient1.getName().equals("Kowalski"))
//            return 1;
//        if(patient1.getDiagnosis().equals(Diagnosis.serious))
//            return 1;
//        if(patient1.getPatientFeeling().getId() > patient2.getPatientFeeling().getId())
//            return 1;
//        else
//            return 0;
    }
}
