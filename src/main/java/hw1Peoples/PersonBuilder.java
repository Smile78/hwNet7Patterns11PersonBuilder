package hw1Peoples;

public class PersonBuilder implements IntrfcPersonBuilder {


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    private String name;
    private String surname;
    private String address;
    private int age;


    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 || age > 150) throw new IllegalArgumentException("No valid age");
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public Person build() {
        if (this.name == null && this.surname == null) throw new IllegalStateException("Name nd Surname are empty");
        if (this.name == null) throw new IllegalStateException("Name is empty");
        if (this.surname == null) throw new IllegalStateException("SurName is empty");
        return new Person(this);
    }


    //    public PersonBuilder newChildBuilder(String named) {


}
