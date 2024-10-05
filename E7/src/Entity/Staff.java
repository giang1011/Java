package Entity;

// Abstract class Staff
public abstract class Staff {
    public String name;
    double salary;

    public Staff(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Abstract methods to be implemented in subclasses
    public abstract double getPaid();
    public abstract String toString();
}

