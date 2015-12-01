package acesso;

import javax.persistence.EntityManager;
import entidades.*;
import java.util.List;
import javax.persistence.EntityTransaction;

//Esta classe realiza as transações e consultas no BD
public class GerenciadorTransacoes {
    final private EntityManager em;
    
    public GerenciadorTransacoes(EntityManager em){this.em = em;}
    
    public List<Usuarios> getListaUsuarios(){
        return em.createQuery("SELECT u FROM Usuarios u ORDER BY u", Usuarios.class).getResultList();
    }
    
    public List<Livros> getListaLivros(){
        return em.createQuery("SELECT l FROM Livros l ORDER BY l", Livros.class).getResultList();
    }
    
    public List<Generos> getListaGeneros(){
        return em.createQuery("SELECT g FROM Generos g ORDER BY g", Generos.class).getResultList();
    }
    
    public List<Pedidos> getListaPedidos(){
        return em.createQuery("SELECT p FROM Pedidos p ORDER BY p", Pedidos.class).getResultList();
    }
    
    public List<PedidoDetalhes> getListaDetalhes(){
        return em.createQuery("SELECT pd FROM PedidoDetalhes pd ORDER BY pd", PedidoDetalhes.class).getResultList();
    }
    
    //Verifica se o ID passado por parametro ja foi utilizado por alguma entidade da classe passada
    public boolean isIdUtilizado(Class entidade, int id) throws Exception{
        if(     !(entidade.equals(Usuarios.class)||
                  entidade.equals(Livros.class)||
                  entidade.equals(Generos.class)||
                  entidade.equals(Pedidos.class)||
                  entidade.equals(PedidoDetalhes.class)))
        throw new Exception("Entidade não suportada");
        return em.find(entidade, id) != null;
    }
    
    public void persistirUsuario(Usuarios usuario){
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
    
    public void atualizar(){
        em.getTransaction().commit();
    }
}
