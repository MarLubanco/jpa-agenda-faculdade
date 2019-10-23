package entities;

import javax.persistence.*;

@Entity
public class Phone {

    @Id
    @GeneratedValue
    private Integer id;

    private String numero;

    @ManyToOne
    private Contact contact;

    public Phone(Integer id, String numero, Contact contact) {
        this.id = id;
        this.numero = numero;
        this.contact = contact;
    }

    public Phone() {
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
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
}
