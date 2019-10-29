package service;

import entities.Groups;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;

public class GroupService {

    public void insertGroups(EntityManager entityManager, Groups groups) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(groups);
            entityManager.getTransaction().commit();
            System.out.println("Novo grupo persistido com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Groups> findAllGroups(EntityManager entityManager) throws SQLException {
        return entityManager.createQuery("select g from Groups g", Groups.class).getResultList();
    }

    public void deletarGroup(EntityManager entityManager, String grupoRemove) throws SQLException {
        try {
            Groups grupo = entityManager.createQuery("select g from Groups g where g.description = :grupo", Groups.class)
                    .setParameter("grupo", grupoRemove).getResultList().get(0);
            entityManager.remove(grupo);
            System.out.println("Grupo removido");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
