package pl.sda;

public class Patient {
//     1. Utwórz klasę Patient mającą pola:
//            * imie (String)
//            * nazwisko (String)
//            * jakBardzoZly (int) - opisuje poziom zlosci
//            * rozpoznanaChoroba (String)
//            * pamietaj o angielskich nazwach, konstruktorze, getterach i setterach jesli potrzebujesz
    private String name;
    private String surname;
    private PatientFeeling patientFeeling;
    private String diagnosis;

    public Patient(String name, String surname, PatientFeeling patientFeeling, String diagnosis) {
        this.name = name;
        this.surname = surname;
        this.patientFeeling = patientFeeling;
        this.diagnosis = diagnosis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public PatientFeeling getPatientFeeling() {
        return patientFeeling;
    }

    public void setPatientFeeling(PatientFeeling patientFeeling) {
        this.patientFeeling = patientFeeling;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}