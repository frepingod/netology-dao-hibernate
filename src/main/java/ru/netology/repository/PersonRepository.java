package ru.netology.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.netology.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@AllArgsConstructor
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        return entityManager.createQuery("select p from Person p where p.cityOfLiving = :city order by p.cityOfLiving", Person.class)
                .setParameter("city", city)
                .getResultList();
    }
}