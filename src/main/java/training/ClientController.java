/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package training;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author LAutodidacte
 */
@Named(value = "clientController")
@RequestScoped
public class ClientController {

    private List<Client> listeClients;

    /**
     * Creates a new instance of ClientController
     */
    public ClientController() {

    }

    @PostConstruct
    public void go() {
        populateList();
    }

    private void populateList() {

        listeClients = new ArrayList();

        listeClients.add(new Client(1000, "David"));
        listeClients.add(new Client(1500, "Paul"));
        listeClients.add(new Client(1850, "Monica"));
        listeClients.add(new Client(1450, "Lucie"));

    }

    public List<Client> getListeClients() {
        return listeClients;
    }

}
