package Entity;

import java.time.LocalDate;

public class Student extends Person {
    private String id;
    private LocalDate DoB;
    private Gender gender;


    public Student() {
        super();
    }


    public Student(String id, String name, LocalDate DoB, Gender gender, String address) {
        super(name, address);
        this.id = id;
        this.DoB = DoB;
        this.gender = gender;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }


    public LocalDate getDoB() {
        return DoB;
    }

    public void setDoB(LocalDate doB) {
        DoB = doB;
    }


    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge(){
        return Math.abs(LocalDate.now().getYear() - this.getDoB().getYear());
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + this.getName() + '\'' +
                ", DoB=" + DoB +
                ", Age=" + this.getAge() +
                ", gender=" + gender +
                ", address=" + this.getAddress() +
                ", " + super.toString() +
                '}';
    }
}
