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
@Table(name="pedidos")
public class Pedidos implements Serializable {
    @Id
    Integer PEDIDO_ID;
    Integer USUARIO_ID;
    String DATA_PEDIDO;
    String TIPO_PAG;

    public Integer getPEDIDO_ID() {
        return PEDIDO_ID;
    }
    /*Retorna String do ID*/
    public String getPEDIDO_ID_STRING(){
        return PEDIDO_ID.toString();
    }
    
    public Integer getUSUARIO_ID() {
        return USUARIO_ID;
    }
    /*Retorna String do ID de Pedidos*/
    public String getUSUARIO_ID_STRING(){
        return USUARIO_ID.toString();
    }
    public void setPEDIDO_ID(Integer PEDIDO_ID) {
        this.PEDIDO_ID = PEDIDO_ID;
    }
    
    @Override
    public String toString(){return PEDIDO_ID+"-"+USUARIO_ID+"-"+TIPO_PAG;}
}
