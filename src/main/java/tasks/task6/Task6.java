package tasks.task6;

import jakarta.persistence.*;
import tasks.Person;
import tasks.Utils;
import java.util.List;

/*
-- user = root
-- password = empty
-- db name = task6

CREATE DATABASE task6;
-- task6.address definition

CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `street` varchar(100) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `state` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
-- task6.person definition

-- task6.person definition

CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `address_id` (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
*/
public class Task6 {
    public void run() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
;

        entityManager.getTransaction().begin();
        Person person = Utils.persons().get(0);
        entityManager.persist(person);
        entityManager.getTransaction().commit();

        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        person = Utils.persons().get(1);
        entityManager.persist(person);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        List<Person> personList = entityManager.createQuery("SELECT p FROM Person p").getResultList();
        System.out.println(personList.size());
        System.out.println(personList);
        personList.get(0).setAge(99);
        entityManager.persist(personList.get(0));
        entityManager.getTransaction().commit();


        entityManager.getTransaction().begin();
        personList = entityManager.createQuery("SELECT p FROM Person p").getResultList();
        System.out.println(personList);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM Address").executeUpdate();
        entityManager.createQuery("DELETE FROM Person").executeUpdate();
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        personList = entityManager.createQuery("SELECT p FROM Person p").getResultList();
        System.out.println(personList.size());
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
