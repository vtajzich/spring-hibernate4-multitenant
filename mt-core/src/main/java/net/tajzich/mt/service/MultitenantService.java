package net.tajzich.mt.service;

import net.tajzich.mt.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vtajzich
 * Date: 8/21/13
 */
@Service
public class MultitenantService {

    private SessionFactory sessionFactory;


    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public User getUser(Long id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    public List<User> getUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
