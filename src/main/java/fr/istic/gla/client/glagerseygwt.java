package fr.istic.gla.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.ui.ValueBoxBase.TextAlignment;

import fr.istic.gla.shared.*;

import java.util.Date;
import java.util.List;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class glagerseygwt implements EntryPoint {

	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final PersonServiceAsync persService = GWT
			.create(PersonService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		// Form Person
		final TextBox namePerson = new TextBox();
		final TextBox firstNamePerson = new	TextBox();
		Label namePersonLabel = new Label("Last Name");
		Label firstNamePersonLabel = new	Label("First Name");
		Button addPerson = new Button("Ajouter la Personne");

		Button showPersons = new Button("Voir les Personnes");


		// Form Home
		final TextBox numero = new TextBox();
		final TextBox rue = new	TextBox();
		final TextBox cp = new TextBox();
		final TextBox ville = new TextBox();
		final TextBox area = new TextBox();
		final TextBox ipAddress = new TextBox();
		final TextBox idProp = new TextBox();
		final Label numLabel = new Label("n°");
		final Label rueLabel = new	Label("Rue");
		final Label cpLabel = new	Label("Code Postal");
		final Label villeLabel = new	Label("Ville");
		final Label areaLabel = new	Label("Surface");
		final Label ipAddressLabel = new	Label("Surface");
		Label idPropLabel = new	Label("Id du proprio");
		Button addHome = new Button("Ajouter la Maison");

		Button bHome = new Button("Voir maisons");

		// addPerson
		addPerson.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				Person p = new Person(namePerson.getText(), firstNamePerson.getText(), Gender.male, new Date());

				persService.addPerson(p, new AsyncCallback<Person>() {

					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
					}

					public void onSuccess(Person result) {
						// TODO Auto-generated method stub
						RootPanel.get("Personne").setVisible(false);
						RootPanel.get("Home").setVisible(true);
						Window.alert("personne cree !");
					}

				});


			}
		});

		// ShowPersons
		showPersons.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				persService.getPersons(new AsyncCallback<List<Person>>() {
					public void onFailure(Throwable caught) {
						RootPanel.get().add(new HTMLPanel(SERVER_ERROR));
					}

					public void onSuccess(List<Person> result) {
						StringBuffer sb = new StringBuffer();
						for (Person p : result) {
							sb.append(p.toString());
							System.out.println(p.toString());
						}
						RootPanel.get().add(new HTMLPanel(sb.toString()));
					}
				});

			}
		});


		addHome.addClickHandler(new ClickHandler() {

			Person proprio;

			public void onClick(ClickEvent event) {
				Address address = new Address(Integer.parseInt(numero.getText()),rue.getText(),Integer.parseInt(cp.getText()),ville.getText());



				// On recupere la personne qui sera proprio de la maison via son id
				persService.getPersonById(Integer.parseInt(idProp.getText()), new AsyncCallback<Person>() {
					public void onFailure(Throwable throwable) {
						proprio = null;
					}

					public void onSuccess(Person person) {
						proprio = person;
					}
				});

				Home h = new Home(address,Float.parseFloat(area.getText()),ipAddress.getText(),new Person("test","test",Gender.female,new Date()));

				persService.addHome(h, new AsyncCallback<Home>() {
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}

					public void onSuccess(Home result) {
						// TODO Auto-generated method stub
						RootPanel.get("Home").setVisible(true);
						Window.alert("personne cree !");
					}
				});
			}
		});

		bHome.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent clickEvent) {
				persService.getHomes(new AsyncCallback<List<Home>>() {
					public void onFailure(Throwable throwable) {

					}

					public void onSuccess(List<Home> homes) {
						StringBuffer sb = new StringBuffer();
						for (Home h : homes) {
							sb.append(h.toString());
							System.out.println(h.toString());
						}
						RootPanel.get().add(new HTMLPanel(sb.toString()));
					}
				});
			}
		});




		//Personne layout
		RootPanel.get("Personne").add(namePersonLabel);
		RootPanel.get("Personne").add(namePerson);
		RootPanel.get("Personne").add(firstNamePersonLabel);
		RootPanel.get("Personne").add(firstNamePerson);
		RootPanel.get("Personne").add(addPerson);
		RootPanel.get("Personne").add(showPersons);

		RootPanel.get("Personne").setVisible(true);


		//Home layout
		RootPanel.get("Home").add(numLabel);
		RootPanel.get("Home").add(numero);
		RootPanel.get("Home").add(rueLabel);
		RootPanel.get("Home").add(rue);
		RootPanel.get("Home").add(cpLabel);
		RootPanel.get("Home").add(cp);
		RootPanel.get("Home").add(villeLabel);
		RootPanel.get("Home").add(ville);
		RootPanel.get("Home").add(areaLabel);
		RootPanel.get("Home").add(area);
		RootPanel.get("Home").add(ipAddressLabel);
		RootPanel.get("Home").add(ipAddress);
		RootPanel.get("Home").add(idPropLabel);
		RootPanel.get("Home").add(idProp);
		RootPanel.get("Home").add(addHome);

		RootPanel.get("Home").setVisible(true);

	}
}