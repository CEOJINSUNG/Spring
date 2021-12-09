package com.example.springjpatutorial.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.springjpatutorial.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLastNameAndFirstName(String firstName, String lastName);
    Optional<User> findByLastNameOrFirstName(String firstName, String lastName);
    List<User> findByStartDateBetween(Date date1, Date date2);
    List<User> findByAgeLessThan(int age);
    List<User> findByAgeLessThanEqual(int age);
    List<User> findByAgeGreaterThan(int age);
    List<User> findByAgeGreaterThanEqual(int age);
    List<User> findByStartDateAfter(Date date);
    List<User> findByStartDateBefore(Date date);
    List<User> findByAgeIsNull();
    List<User> findByFirstnameLike(String firstname);
    List<User> findByFirstnameNotLike(String firstname);
    Optional<User> findByFirstnameStartingWith(String firstname);
    List<User> findByFirstnameEndingWith(String firstname);
    List<User> findByFirstnameContaining(String firstname);
    Optional<User> findByAgeOrderByLastnameDesc(int age);
    List<User> findByLastnameNot(String lastname);
    List<User> findByAgeIn(Collection<Integer> ages);
    List<User> findByAgeNotIn(Collection<Integer> ages);
    List<User> findByActiveTrue();
    List<User> findByActiveFalse();
    List<User> findByFirstnameIgnoreCase(String firstname);

    //주석으로 되어 있는 것은 SQL 언어로 바로 적용하고 싶을 때 사용하는 것이다. 
    //@Query(value = "select * from users where first_name like %?1", nativeQuery = true)
    @Query("select u from User u where u.emailAddress = ?1")
    User findByEmailAddress(String emailAddress);

    //@Query(value = "SELECT * FROM USERS WHERE EMAIL_ADDRESS = ?1", nativeQuery = true)
    @Query("select u from User u where u.firstname like %?1")
    List < User > findByFirstnameEndsWith(String firstname);
}
