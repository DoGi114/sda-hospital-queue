package pl.sda;

import pl.sda.enums.DoctorsSpecialization;

import java.math.BigDecimal;

public class Doctor extends Person{

    private DoctorsSpecialization specialization;
    private BigDecimal salary;

    public Doctor(String name, String surname, DoctorsSpecialization specialization, BigDecimal salary) {
        super(name, surname);
        this.specialization = specialization;
        this.salary = salary;
    }

    public DoctorsSpecialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(DoctorsSpecialization specialization) {
        this.specialization = specialization;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

}
