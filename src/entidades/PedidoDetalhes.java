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
public class PedidoDetalhes implements Serializable {
    @Id
    Integer DETALHE_ID;
    Integer PEDIDO_ID;
    Integer LIVRO_ID;
    Integer QTD;
    
    public Integer getDETALHE_ID() {
        return DETALHE_ID;
    }

    public Integer getPEDIDO_ID(){
        return PEDIDO_ID;
    }

    public Integer getLIVRO_ID(){
        return LIVRO_ID;
    }

    public Integer getQTD(){
        return QTD;
    }
    public void setDETALHE_ID(Integer DETALHE_ID) {
        this.DETALHE_ID = DETALHE_ID;
    }
    
    @Override
    public String toString(){return DETALHE_ID+"-"+LIVRO_ID+"-"+QTD;}
}
