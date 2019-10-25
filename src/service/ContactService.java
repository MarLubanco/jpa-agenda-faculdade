package service;

import entities.Contact;

import javax.persistence.EntityManager;

public class ContactService {

    public void salvarNovoContato(Contact contact, EntityManager entityManager) {
       try {
           entityManager.getTransaction().begin();
           entityManager.persist(contact);
           entityManager.getTransaction().commit();
           System.out.println("Novo contato persistido com sucesso");
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    public void deletarContato(Integer id, EntityManager entityManager) {
        try {
            entityManager.getTransaction().begin();
            Contact contactRecuperado = entityManager.find(Contact.class, id);
            entityManager.remove(contactRecuperado);
            entityManager.getTransaction().commit();
            System.out.println("Contact removido com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Contact recuperarContato(Integer id, EntityManager entityManager) throws Exception {
        Contact contact = entityManager.find(Contact.class, id);
        if(contact != null) {
            return contact;
        } else {
            throw new Exception("Contato não existe");
        }
    }

    public void atualizarContato(Contact contatoExistente, EntityManager entityManager) {
       try {
           entityManager.getTransaction().begin();
           entityManager.persist(contatoExistente);
           entityManager.getTransaction().commit();
           System.out.println("Contato atualizado com sucesso.");
       } catch (Exception e) {
           e.printStackTrace();
       }
    }
}
