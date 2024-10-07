package Entity;

import java.time.LocalDate;

public class Staff {
    private int id;
    private String code;
    private String name;
    private LocalDate DoB;

    public Staff(){;}

    public Staff(int id, String code, String name, LocalDate doB) {
        this.id = id;
        this.code = code;
        this.name = name;
        DoB = doB;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDoB() {
        return DoB;
    }

    public void setDoB(LocalDate doB) {
        DoB = doB;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", DoB=" + DoB +
                '}';
    }
}
