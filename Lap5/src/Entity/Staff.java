package Entity;

import java.time.LocalDate;

public class Staff extends Person {
    private String id;
    private String school;
    private double pay;
    private Gender gender;


    public Staff() {super();}
    public Staff(String id, String name,String school, Gender gender, double pay, String address) {
        super(name, address);
        this.id = id;
        this.school = school;
        this.gender = gender;
        this.pay = pay;
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


    public Gender getGender() {
        return gender;
    }



    public double getSalary() {
        return pay;
    }



    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Staff{" + "id=" + id + ", school: " + school + ", name='" + this.getName() + '\'' + ", gender=" + gender + ", Age=" +  ", salary=" + pay + '}';
    }

}

