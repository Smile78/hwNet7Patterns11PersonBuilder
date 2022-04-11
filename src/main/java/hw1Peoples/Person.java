package hw1Peoples;

import java.util.OptionalInt;

public class Person {


    private final String name;        //son??
    private final String surname;
    private int age;
    private String address;

    //
    public Person(PersonBuilder persB) {
        this.name = persB.getName();
        this.surname = persB.getSurname();
        this.age = persB.getAge();
        this.address = persB.getAddress();
    }


    public boolean hasAge() {
//        return getAge().isEmpty();
        return getAge().getAsInt() != 0;                         // kakбы на null
    }

    public boolean hasAddress() {
        return this.address != null;
    }


    public OptionalInt getAge() {
        return OptionalInt.of(this.age);
    }    // как вообще OPtionalint может быть null ?

    public String getAdress() {
        return this.address;
    }


    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (this.age < 0) System.out.println("da ladno! no kak!");
        else if (this.age == 0) System.out.println("maybe unknown age"); //  null?
        else if (this.age < 150) this.age++;
        else System.out.println("da ladno! Tolstoy v shoke!");
    }


    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.surname)
                .setAddress(this.address);

    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + (this.hasAge() ? this.age : "unknown") +
                ", address='" + (this.hasAddress() ? this.getAdress() : "no registration") + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (surname != null ? !surname.equals(person.surname) : person.surname != null) return false;
        return address != null ? address.equals(person.address) : person.address == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }


}
