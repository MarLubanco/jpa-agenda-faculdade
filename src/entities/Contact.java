package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity(name = "contato")
public class Contact {

    @Id
    @GeneratedValue
    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    @ManyToMany(mappedBy = "contacts")
    private List<Groups> groups;

    @ManyToMany(mappedBy = "contacts")
    private List<Phone> phones;

    public Contact(Integer id, String firstName, String lastName, String email, List<Groups> groups, List<Phone> phones) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.groups = groups;
        this.phones = phones;
    }

    public Contact() {
    }

    public Contact(Integer id, String nome, String sobrenome, String email) {
        this.id = id;
        this.firstName = nome;
        this.lastName = sobrenome;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Groups> getGroups() {
        return groups;
    }

    public void setGroups(List<Groups> groups) {
        this.groups = groups;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "Contact - " +
                " id : " + id +
                " firstName: '" + firstName + '\'' +
                " lastName: '" + lastName + '\'' +
                " email:'" + email + '\'' +
                " groups:" + groups +
                " phones:" + phones;
    }
}
