package pl.sda.enums;

import java.util.HashMap;
import java.util.Map;

public enum Diagnosis {
    cancer(0, "Cancer"),
    fever(1, "Fever"),
    serious(2, "Something serious"),
    heartAttack(3, "Heart attack"),
    cold(4, "Cold");


    private int id;
    private String value;
    private static final Map<Integer, Diagnosis> map = new HashMap<>();

    Diagnosis(int id, String diagnosis) {
        this.value = diagnosis;
        this.id = id;
    }

    static {
        for (Diagnosis feeling : Diagnosis.values()) {
            map.put(feeling.id, feeling);
        }
    }

    public static Diagnosis valueOf(int diagnosisId) {
        return (Diagnosis) map.get(diagnosisId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}