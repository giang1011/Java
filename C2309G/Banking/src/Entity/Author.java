package Entity;

public class Author {

    private String name;
    private Gender gender;
    private String email;

    public Author(String name, Gender gender, String email) {
        this.name = name;
        this.gender = gender;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", gender=" + gender.getGenderLabel() +
                ", email='" + email + '\'' +
                '}';
    }
}
