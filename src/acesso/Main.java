package acesso;

import entidades.*;
import interfaceusuario.JanelaCRUD;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BD01CRUDPU");
        EntityManager em = emf.createEntityManager();
        
        GerenciadorTransacoes gerenciador = new GerenciadorTransacoes(em);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaCRUD(gerenciador).setVisible(true);
            }
        });
    }
}