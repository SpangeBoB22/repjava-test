package tasks.task7;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import tasks.Interest;
import tasks.Person;
import tasks.Project;
import tasks.Utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
-- task6.interest definition

CREATE TABLE `interest` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- task6.project definition

CREATE TABLE `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- task6.person_interest definition

CREATE TABLE `person_interest` (
  `person_id` int(11) DEFAULT NULL,
  `interest_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- task6.person_project definition

CREATE TABLE `person_project` (
  `person_id` int(11) DEFAULT NULL,
  `project_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

 */
public class Task7 {

    public void run() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Person person1 = Utils.persons().get(3);
        Person person2 = Utils.persons().get(4);


        Project project =  new Project();
        project.setName("BUILD");

        Set<Interest> interests = new HashSet<>();

        interests.add(Interest.builder().name("SPORT").build());
        interests.add(Interest.builder().name("READ").build());



        project.getPersons().add(person1);

        System.out.println("Projects");
        System.out.println(project);


        person1.setInterest(interests);

        person1.getProjects().add(project);


        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        System.out.println(person1);
        entityManager.persist(person1);
        entityManager.getTransaction().commit();


        entityManager.getTransaction().begin();
        List<Person> personList = entityManager.createQuery("SELECT p FROM Person p").getResultList();
        System.out.println(personList.size());
        System.out.println(personList);

        System.out.println(personList);
        System.out.println(personList.get(0).getProjects());
        System.out.println(personList.get(0).getProjects().stream().toList().get(0).getPersons());

        entityManager.getTransaction().commit();

        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(person2);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        List<Project> projects = entityManager.createQuery("SELECT p FROM Project p").getResultList();
        personList = entityManager.createQuery("SELECT p FROM Person p where name = 'Ruben'").getResultList();
        System.out.println(personList.size());
        System.out.println(personList);
        personList.get(0).getProjects().add(projects.get(0));
        entityManager.persist(personList.get(0));
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();

        personList = entityManager.createQuery("SELECT p FROM Person p").getResultList();
        personList.stream().forEach(i -> {
            System.out.println(i);
            System.out.println(i.getProjects());
            System.out.println(i.getProjects().stream().toList().get(0).getPersons());
        });
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM Project p where p.name = :name")
                        .setParameter("name", "BUILD")
                                .executeUpdate();

        entityManager.getTransaction().commit();


        entityManager.getTransaction().begin();

        projects = entityManager.createQuery("SELECT p FROM Project p").getResultList();
        System.out.println(projects.size());
        entityManager.getTransaction().commit();


        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM Interest").executeUpdate();
        entityManager.createQuery("DELETE FROM Project").executeUpdate();
        entityManager.createQuery("DELETE FROM Address").executeUpdate();
        entityManager.createQuery("DELETE FROM Person").executeUpdate();
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
