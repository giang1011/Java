package Entity;

public class Technician extends Staff {
    double overtimePay;

    public Technician(String name, double salary, double overtimePay) {
        super(name, salary);
        this.overtimePay = overtimePay;
    }

    @Override
    public double getPaid() {
        return salary + overtimePay;
    }

    @Override
    public String toString() {
        return "Technician: Name: " + name + ", Salary: " + salary + ", Overtime Pay: " + overtimePay + ", Paid: " + getPaid();
    }
}
