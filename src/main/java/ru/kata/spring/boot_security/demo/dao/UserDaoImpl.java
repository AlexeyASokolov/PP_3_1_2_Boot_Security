package ru.kata.spring.boot_security.demo.dao;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    public User findByUserName(String name) {
        String query = "Select u from User u left join fetch u.roles where u.name=:name";
        User user = entityManager.createQuery(query, User.class).setParameter("name", name).getSingleResult();
        if (user == null) {
            throw new UsernameNotFoundException("User " + name + " not found");
        }
        return user;
    }

    @Transactional
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class)
                .getResultList();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void removeUser(Long id) {
        entityManager.remove(getUser(id));
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        entityManager.merge(user);
    }

}
