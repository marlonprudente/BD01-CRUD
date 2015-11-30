package acesso;

import javax.persistence.EntityManager;
import entidades.*;
import java.util.List;
import javax.persistence.EntityTransaction;

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
    
    public boolean isIdUtilizado(Class entidade, int id) throws Exception{
        if(     !(entidade.equals(Usuarios.class)||
                  entidade.equals(Livros.class)||
                  entidade.equals(Generos.class)||
                  entidade.equals(Pedidos.class)||
                  entidade.equals(PedidoDetalhes.class)))
        throw new Exception("Entidade não suportada");
        return em.find(entidade, id) != null;
    }
    
    public void adicionarUsuario(Usuarios usuario){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(usuario);
        et.commit();
    }

    public void removerUsuario(Usuarios usuario) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(usuario);
        et.commit();
    }
}
