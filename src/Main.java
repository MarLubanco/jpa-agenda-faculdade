import entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("jpa-lab3-aula");

        EntityManager em = emf.createEntityManager();

        Product p = new Product();
        p.setName("Tenis");
        p.setDescription("Tenis de corrida");

        em.persist(p);

        em.close();
        emf.close();
    }

}
