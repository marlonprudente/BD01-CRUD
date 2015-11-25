/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acesso;

import entidades.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author a1562339
 */
public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BD01CRUDPU");
//2
        EntityManager em = emf.createEntityManager();
        Generos g = em.find(Generos.class, 2);
        Livros l = em.find(Livros.class, 1);
//3
        if (g != null) {
            System.out.println(g.getGENERO_ID() + ", " + g.getDEESCRICAO());
            System.out.println(l.getTITULO_STRING() + " " + l.getDESCRICAO_STRING());
        } else {
            System.out.println("Não encontrado!");
        }
        
    }
}
