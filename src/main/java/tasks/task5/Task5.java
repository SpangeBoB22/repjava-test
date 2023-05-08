package tasks.task5;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import tasks.Main;
import tasks.Person;
import tasks.Utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Task5 {
    public void json() throws IOException {
        ClassLoader classLoader = Main.class.getClassLoader();
        URL input = classLoader.getResource("input.json");
        Person p2 = new ObjectMapper().readValue(input, Person.class);

        System.out.println(p2);
        p2.setAge(43);
        p2.setName("Rey");

        new ObjectMapper().writeValue(new File("src/main/resources/output.json" ), p2);
    }

    public void xml() throws IOException {
        ClassLoader classLoader = Main.class.getClassLoader();
        URL input = classLoader.getResource("input.xml");
        Person p2 = new XmlMapper().readValue(input, Person.class);

        System.out.println(p2);
        p2.setAge(33);
        p2.setName("Carmelo");

        new XmlMapper().writeValue(new File("src/main/resources/output.xml" ), p2);
    }
    public void stream() {
        Predicate<Person> lengthName = p -> p.getName().length() > 4;

        System.out.println(Utils.persons().size());
        List<Person> list = Utils.persons().stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .sorted(Comparator.comparing(Person::getName))
                .filter(i -> i.getAge() > 23)
                .filter(lengthName)
                .toList();
        System.out.println(list.size());
        System.out.println(list);
    }
}
