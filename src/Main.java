import com.sun.xml.bind.v2.runtime.output.SAXOutput;
import entities.Contact;
import entities.Product;
import service.ContactService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Main {


    public static void menu() {
        System.out.println("AGENDA ELETRONICA" +
                "1 - Salvar novo contato" +
                "2 - Listar contatos"
        );
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactService contactService = new ContactService();
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("jpa-lab3-aula");

        EntityManager em = emf.createEntityManager();

        while (true) {
            menu();
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Deseja salvar um novo contato");
                    System.out.print("Digite o nome: ");
                    String nome = scanner.next();
                    System.out.println("Digite o sobrenome: ");
                    String sobrenome = scanner.next();
                    System.out.println("Digite  email: ");
                    String email = scanner.next();
                    Contact contact = new Contact(1,nome, sobrenome, email);
                    contactService.salvarNovoContato(contact, em);
                    break;
                case 2:
                    System.out.println("CONTATOS EXISTESTE");
                    System.out.println("-".repeat(50));
                    contactService.findAllContatos(em)
                            .forEach(contato -> System.out.println(contato.toString()));
                    break;
                case 3:
                    System.out.println("Deletar contato: ");
                    System.out.println("Digite o id do contato: ");
                    int id = scanner.nextInt();
                    contactService.deletarContato(id, em);
                    break;
                default:
                    System.out.println("FIM");
            }
        }
    }

}
