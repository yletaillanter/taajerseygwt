package fr.istic.gla.client;

/**
 * Created by yoannlt on 24/04/15.
 */

import com.google.gwt.user.client.rpc.AsyncCallback;
import fr.istic.gla.shared.Home;
import fr.istic.gla.shared.Person;

import java.util.List;

/**
 * The async counterpart of <code>PersonService</code>.
 */
public interface PersonServiceAsync {
    void getPersons(AsyncCallback<List<Person>> callback);
    void getHomes(AsyncCallback<List<Home>> callback);
    void getPersonById(int id, AsyncCallback<Person> callback);
    void getHomeById(int id, AsyncCallback<Home> callback);
    void addPerson(Person p, AsyncCallback<Person> callback);
    void addHome(Home h, AsyncCallback<Home> callback);
}
