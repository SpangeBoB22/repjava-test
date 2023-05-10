package tasks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Utils {
    public static List<Person> persons() {
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
                        .interest(new HashSet<>())
                        .projects(new HashSet<>())
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
                        .interest(new HashSet<>())
                        .projects(new HashSet<>())
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
                        .interest(new HashSet<>())
                        .projects(new HashSet<>())
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
                        .interest(new HashSet<>())
                        .projects(new HashSet<>())
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
                        .interest(new HashSet<>())
                        .projects(new HashSet<>())
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
                        .interest(new HashSet<>())
                        .projects(new HashSet<>())
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
                        .interest(new HashSet<>())
                        .projects(new HashSet<>())
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
                        .interest(new HashSet<>())
                        .projects(new HashSet<>())
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
                        .interest(new HashSet<>())
                        .projects(new HashSet<>())
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
                        .interest(new HashSet<>())
                        .projects(new HashSet<>())
                        .build()
        );
        return personList;
    }
}
