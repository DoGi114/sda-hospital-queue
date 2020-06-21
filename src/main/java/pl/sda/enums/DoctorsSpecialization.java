package pl.sda.enums;

import java.util.HashMap;
import java.util.Map;

public enum DoctorsSpecialization {
    surgeon(0, "Surgeon", new Diagnosis[]{Diagnosis.heartAttack}),
    common(1, "Common doctor", new Diagnosis[]{Diagnosis.fever, Diagnosis.cold});


    private int id;
    private String value;
    private Diagnosis[] handles;
    private static final Map<Integer, DoctorsSpecialization> map = new HashMap<>();

    DoctorsSpecialization(int id, String DoctorsSpecialization, Diagnosis[] handles) {
        this.value = DoctorsSpecialization;
        this.id = id;
        this.handles = handles;
    }

    static {
        for (DoctorsSpecialization feeling : DoctorsSpecialization.values()) {
            map.put(feeling.id, feeling);
        }
    }

    public static DoctorsSpecialization valueOf(int DoctorsSpecializationId) {
        return (DoctorsSpecialization) map.get(DoctorsSpecializationId);
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

    public Diagnosis[] getHandles() {
        return handles;
    }

    public void setHandles(Diagnosis[] handles) {
        this.handles = handles;
    }

    public static Map<Integer, DoctorsSpecialization> getMap() {
        return map;
    }
}
