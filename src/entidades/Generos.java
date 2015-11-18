/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author a1562339
 */
@Entity
@Table(name="generos")
public class Generos implements Serializable {    
    @Id
    int GENERO_ID;
    String DESCRICAO;
    
   public Generos(){
    
}

    public int getGENERO_ID() {
        return GENERO_ID;
    }

    public void setGENERO_ID(int GENERO_ID) {
        this.GENERO_ID = GENERO_ID;
    }
   public String getDEESCRICAO(){
       return DESCRICAO;
   }
   public void setDESCRICAO(String DESCRICAO){
       this.DESCRICAO = DESCRICAO;
   }
    
}
