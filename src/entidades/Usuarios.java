/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 *
 * @author a1562339
 */
@Entity
@Table(name="usuarios")
public class Usuarios implements Serializable{
    @Id
    Integer USUARIO_ID;
    String NOME;
    String ENDERECO;
    String BAIRRO;
    String CIDADE;
    

    public Integer getID() {
        return USUARIO_ID;
    }

    public void setID(Integer ID) {
        this.USUARIO_ID = ID;
    }
    
}
