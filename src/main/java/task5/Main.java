package task5;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.json();
        main.xml();
        main.stream();


    }
    private void json() throws IOException {
        ClassLoader classLoader = Main.class.getClassLoader();
        URL input = classLoader.getResource("input.json");
        Person p2 = new ObjectMapper().readValue(input, Person.class);

        System.out.println(p2);
        p2.setAge(43);
        p2.setName("Rey");

        new ObjectMapper().writeValue(new File("src/main/resources/output.json" ), p2);
    }

    private void xml() throws IOException {
        ClassLoader classLoader = Main.class.getClassLoader();
        URL input = classLoader.getResource("input.xml");
        Person p2 = new XmlMapper().readValue(input, Person.class);

        System.out.println(p2);
        p2.setAge(33);
        p2.setName("Carmelo");

        new XmlMapper().writeValue(new File("src/main/resources/output.xml" ), p2);
    }
    private void stream() {
        Predicate<Person> lengthName = p -> p.getName().length() > 4;

        System.out.println(list().size());
        List<Person> list = list().stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .sorted(Comparator.comparing(Person::getName))
                .filter(i -> i.getAge() > 23)
                .filter(lengthName)
                .toList();
        System.out.println(list.size());
        System.out.println(list);
    }
    private List<Person> list() {
        List<Person> personList = new ArrayList<>();
        personList.add(
                Person.builder()
                        .name("Sophie")
                        .age(73)
                        .address(
                                Address
                                        .builder()
                                        .state("Utah")
                                        .city("Metropolis")
                                        .street("Main")
                                        .build())
                        .build()
        );
        personList.add(
                Person.builder()
                        .name("Chase")
                        .age(32)
                        .address(
                                Address
                                        .builder()
                                        .state("Alabama")
                                        .city("Braavos")
                                        .street("Pearl")
                                        .build())
                        .build()
        );
        personList.add(
                Person.builder()
                        .name("Koda")
                        .age(47)
                        .address(
                                Address
                                        .builder()
                                        .state("Oregon")
                                        .city("Blackwater")
                                        .street("Hill")
                                        .build())
                        .build()
        );
        personList.add(
                Person.builder()
                        .name("Roland")
                        .age(27)
                        .address(
                                Address
                                        .builder()
                                        .state("Colorado")
                                        .city("Dawnstar")
                                        .street("Hill")
                                        .build())
                        .build()
        );
        personList.add(
                Person.builder()
                        .name("Ruben")
                        .age(76)
                        .address(
                                Address
                                        .builder()
                                        .state("South Carolina")
                                        .city("Westworld")
                                        .street("Washington")
                                        .build())
                        .build()
        );
        personList.add(
                Person.builder()
                        .name("Wendy")
                        .age(48)
                        .address(
                                Address
                                        .builder()
                                        .state("Alabama")
                                        .city("Balmora")
                                        .street("High")
                                        .build())
                        .build()
        );
        personList.add(
                Person.builder()
                        .name("Rey")
                        .age(34)
                        .address(
                                Address
                                        .builder()
                                        .state("Utah")
                                        .city("King's Landing")
                                        .street("Hill")
                                        .build())
                        .build()
        );
        personList.add(
                Person.builder()
                        .name("Clyde")
                        .age(39)
                        .address(
                                Address
                                        .builder()
                                        .state("Palau")
                                        .city("Gotham")
                                        .street("Maple")
                                        .build())
                        .build()
        );
        personList.add(
                Person.builder()
                        .name("Avery")
                        .age(63)
                        .address(
                                Address
                                        .builder()
                                        .state("Mississippi")
                                        .city("Winterfell")
                                        .street("Main")
                                        .build())
                        .build()
        );
        personList.add(
                Person.builder()
                        .name("Carmelo")
                        .age(62)
                        .address(
                                Address
                                        .builder()
                                        .state("Palau")
                                        .city("Eerie")
                                        .street("Lake")
                                        .build())
                        .build()
        );
        return personList;
    }
}