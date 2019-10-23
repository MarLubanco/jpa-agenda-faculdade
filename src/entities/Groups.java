package entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Groups {

    @Id
    @GeneratedValue
    private Integer id;

    private String descricao;

    @ManyToMany
    @JoinTable(name="groups_contacts", joinColumns=
            {@JoinColumn(name="groups_id")}, inverseJoinColumns=
            {@JoinColumn(name="contact_id")})
    private List<Contact> contacts;

    @OneToMany
    private List<Phone> phones;

    public Groups(Integer id, String descricao, List<Contact> contacts, List<Phone> phones) {
        this.id = id;
        this.descricao = descricao;
        this.contacts = contacts;
        this.phones = phones;
    }

    public Groups() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}
