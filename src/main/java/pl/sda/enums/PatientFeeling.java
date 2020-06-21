package pl.sda.enums;

import java.util.HashMap;
import java.util.Map;

public enum PatientFeeling {
    fine(0),
    ok(1),
    average(2),
    bad(3),
    terrible(4),
    dying(5);

    private int id;
    private static Map<Integer, PatientFeeling> map = new HashMap<>();

    PatientFeeling(int id) {
        this.id = id;
    }

    static {
        for (PatientFeeling feeling : PatientFeeling.values()) {
            map.put(feeling.id, feeling);
        }
    }

    public static PatientFeeling valueOf(int feelingId) {
        return (PatientFeeling) map.get(feelingId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
