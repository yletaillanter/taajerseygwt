package fr.istic.gla.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import fr.istic.gla.shared.Home;
import fr.istic.gla.shared.Person;

import java.util.List;

/**
 * Created by yoannlt on 24/04/15.
 */
@RemoteServiceRelativePath("persons")
public interface PersonService extends RemoteService {
    List<Person> getPersons();
    List<Home> getHomes();
    Person getPersonById(int id);
    Home getHomeById(int id);
    Person addPerson(Person p);
    Home addHome(Home h);

}
