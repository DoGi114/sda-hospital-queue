package pl.sda;

import pl.sda.enums.Diagnosis;
import pl.sda.enums.PatientFeeling;

public class Patient extends Person {
    private PatientFeeling patientFeeling;
    private Diagnosis diagnosis;

    public Patient(String name, String surname, PatientFeeling patientFeeling, Diagnosis diagnosis) {
        super(name, surname);
        this.patientFeeling = patientFeeling;
        this.diagnosis = diagnosis;
    }

    public PatientFeeling getPatientFeeling() {
        return patientFeeling;
    }

    public void setPatientFeeling(PatientFeeling patientFeeling) {
        this.patientFeeling = patientFeeling;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

}
