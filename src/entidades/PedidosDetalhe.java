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
@Table(name="pedidos_detalhe")
public class PedidosDetalhe implements Serializable {
    @Id
    Integer DETALHE_ID;
    Integer PEDIDO_ID;
    Integer LIVRO_ID;
    Integer QTD;
    
    public Integer getDETALHE_ID() {
        return DETALHE_ID;
    }
    public String getDETALHE_ID_STRING(){
        return DETALHE_ID.toString();
    }
    public Integer getPEDIDO_ID(){
        return PEDIDO_ID;
    }
    public String getPEDIDO_ID_STRING(){
        return PEDIDO_ID.toString();
    }
    public Integer getLIVRO_ID(){
        return LIVRO_ID;
    }
    public String getLIVRO_ID_STRING(){
        return LIVRO_ID.toString();
    }
    public Integer getQTD(){
        return QTD;
    }
    public String getQTD_STRING(){
        return QTD.toString();
    }
    public void setDETALHE_ID(Integer DETALHE_ID) {
        this.DETALHE_ID = DETALHE_ID;
    }
    
}
