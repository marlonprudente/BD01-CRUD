package acesso;

import entidades.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BD01CRUDPU");
        EntityManager em = emf.createEntityManager();
//2
        Livros l = em.find(Livros.class, 1);
        Usuarios u = em.find(Usuarios.class,1);
        Generos g = em.find(Generos.class,1);
        Pedidos p = em.find(Pedidos.class,1);
        PedidoDetalhes pd = em.find(PedidoDetalhes.class, 1);
//3
        if (l != null) {
            System.out.println();
            System.out.println("Livro: "+l+"> Genero: "+l.getGenero());
        } else {
            System.out.println("Livro não encontrado!");
        }
        if (u != null) {
            System.out.println();
            System.out.println("Usuário: "+u);
            List<Pedidos> pedidos = u.getPedidos();
            System.out.println("Pedidos deste usuário:");
            if(!pedidos.isEmpty())
                for(int i = 0; i < pedidos.size(); i++)
                    System.out.println("    >"+pedidos.get(i));
            else
                System.out.println("    Não existem pedidos deste usuário.");
        } else {
            System.out.println("Usuário não encontrado!");
        }        
    }
}
