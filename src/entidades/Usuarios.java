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
    

    public Integer getUSUARIO_ID() {
        return USUARIO_ID;
    }
    /*Retorna String do ID*/
    public String getUSUARIO_ID_STRING(){
        return USUARIO_ID.toString();
    }
    
    public void setUSUARIO_ID(Integer ID) {
        this.USUARIO_ID = ID;
    }
    
    public String getNOME_STRING(){
        return NOME.toString();
    }
    public String getENDERECO_STRING(){
        return ENDERECO.toString();
    }
    public String getBAIRRO_STRING(){
        return BAIRRO.toString();
    }
    public String getCIDADE_STRING(){
        return CIDADE.toString();
    }
}
