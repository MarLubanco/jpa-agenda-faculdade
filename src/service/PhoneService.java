package service;

import entities.Groups;
import entities.Phone;

import javax.persistence.EntityManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PhoneService {

    public void insertPhones(EntityManager entityManager, Phone phone) throws SQLException {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(phone);
            entityManager.getTransaction().commit();
            System.out.println("Novo telefone persistido com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Phone> findAllPhone(EntityManager entityManager) throws SQLException {
        return entityManager.createQuery("select p from Phone p", Phone.class).getResultList();
    }
}
