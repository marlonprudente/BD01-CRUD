package acesso;

import javax.persistence.EntityManager;
import entidades.*;
import java.util.List;

public class GerenciadorTransacoes {
    final private EntityManager em;
    
    public GerenciadorTransacoes(EntityManager em){this.em = em;}
    
    public List<Usuarios> getListaUsuarios(){
        return em.createQuery("SELECT u FROM Usuarios u", Usuarios.class).getResultList();
    }
    
    public List<Livros> getListaLivros(){
        return em.createQuery("SELECT u FROM Livros u", Livros.class).getResultList();
    }
    
    public List<Generos> getListaGeneros(){
        return em.createQuery("SELECT u FROM Generos u", Generos.class).getResultList();
    }
    
    public List<Pedidos> getListaPedidos(){
        return em.createQuery("SELECT u FROM Pedidos u", Pedidos.class).getResultList();
    }
    public List<PedidoDetalhes> getListaDetalhes(){
        return em.createQuery("SELECT u FROM PedidoDetalhes u", PedidoDetalhes.class).getResultList();
    }    
}
