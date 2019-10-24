package entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Phone {

    @Id
    @GeneratedValue
    private Integer id;

    private String numero;

    @ManyToMany
    @JoinTable(name="phones_contacts", joinColumns=
            {@JoinColumn(name="phone_id")}, inverseJoinColumns=
            {@JoinColumn(name="contact_id")})
    private List<Contact> contacts;

    public Phone(Integer id, String numero, List<Contact> contacts) {
        this.id = id;
        this.numero = numero;
        this.contacts = contacts;
    }

    public Phone() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
