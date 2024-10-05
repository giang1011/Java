package Entity;

public class BasicStaff extends Staff {

    public BasicStaff(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double getPaid() {
        return salary;
    }

    @Override
    public String toString() {
        return "Staff: Name: " + name + ", Salary: " + salary + ", Paid: " + getPaid();
    }
}

