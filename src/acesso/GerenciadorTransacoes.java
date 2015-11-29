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
}
