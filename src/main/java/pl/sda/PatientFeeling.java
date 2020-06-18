package pl.sda;

import java.util.HashMap;
import java.util.Map;

public enum PatientFeeling {
    fine(1),
    ok(2),
    average(3),
    bad(4),
    terrible(5),
    dying(6);

    private int value;
    private static Map map = new HashMap<>();

    PatientFeeling(int value) {
        this.value = value;
    }

    static {
        for (PatientFeeling feeling : PatientFeeling.values()) {
            map.put(feeling.value, feeling);
        }
    }

    public static PatientFeeling valueOf(int feelingNumber) {
        return (PatientFeeling) map.get(feelingNumber);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
