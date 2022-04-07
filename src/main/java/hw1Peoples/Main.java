package hw1Peoples;

public class Main {


    public static void main(String[] args) {


        // Не хватает обяхательных полей
        try {
            System.out.println(new PersonBuilder().build());    //java.lang.IllegalStateException : Name is empty
        } catch (IllegalStateException x) {
            System.out.println(x);
            x.printStackTrace();
        }

        // Возраст недопустимый
        try {
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }


        Person person = new PersonBuilder()
                .setName("Антошка")
                .setSurname("Лопатов")
                .build();
        person.happyBirthday();                   //maybe unknown age
//        System.out.println(person.getAge());    //OptionalInt[0]
        System.out.println(person);


        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        mom.happyBirthday();
        System.out.println(mom);

        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);

    }

}
