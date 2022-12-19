package io.zipcoder.crudapp;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person,Integer> {
    <S extends Person> S save(S s);
    <S extends Person> Iterable<S> save(Iterable<S> iterable);
    Person findOne(Integer s);
    boolean exists(Integer s);
    Iterable<Person> findAll();
    Iterable<Person> findAll(Iterable<Integer> iterable);
    long count();
    void delete(Integer s);
    void delete(Person person);
    void delete(Iterable<? extends Person> iterable);
    void deleteAll();

  // Person findById(Long givenId);

  Person findBy(int id);

    Person findById(int id);
}
