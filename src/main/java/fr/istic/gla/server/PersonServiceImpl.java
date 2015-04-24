package fr.istic.gla.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import fr.istic.gla.client.PersonService;
import fr.istic.gla.shared.Home;
import fr.istic.gla.shared.Person;

import javax.persistence.*;
import javax.servlet.ServletException;
import java.util.List;

/**
 * Created by yoannlt on 24/04/15.
 */
public class PersonServiceImpl extends RemoteServiceServlet implements
        PersonService {

    private EntityManagerFactory factory;
    private EntityManager manager;
    private EntityTransaction tx;

    public void setManager(EntityManager manager){
        this.manager=manager;
    }

    @Override
    public void init() throws ServletException {
        factory = Persistence.createEntityManagerFactory("mysql");
        manager = factory.createEntityManager();
        tx = manager.getTransaction();
    }

    public PersonServiceImpl(){
    }

    public List<Person> getPersons() {
        tx.begin();
        Query query = manager.createQuery("select p from Person p");
        return query.getResultList();
    }

    public Person getPersonById(int id) {
        return null;
    }

    public Person addPerson(Person p) {
        if (!tx.isActive())
            tx.begin();
        manager.persist(p);
        tx.commit();
        return p;
    }

    public List<Home> getHomes() {
        tx.begin();
        Query query = manager.createQuery("select h from Person h");
        return query.getResultList();
    }

    public Home getHomeById(int id) {
        return null;
    }

    public Home addHome(Home h) {
        if (!tx.isActive())
            tx.begin();
        manager.persist(h);
        tx.commit();
        return h;
    }

    @Override
    public void destroy(){
        manager.close();
    }
}
