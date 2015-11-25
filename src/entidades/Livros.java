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
@Table(name="livros")
public class Livros implements Serializable {
    @Id
    Integer LIVRO_ID;
    String TITULO;
    String AUTOR;
    String EDITORA;
    Integer ANO;
    Integer GENERO_ID;
    String DESCRICAO;
    Double PRECO;
    Integer ESTOQUE;
    Integer RESERVA;
    /*Como representar um BLOB? Array de bytes*/
    
    
    public Integer getLIVRO_ID() {
        return LIVRO_ID;
    }

    public void setLIVRO_ID(Integer LIVRO_ID) {
        this.LIVRO_ID = LIVRO_ID;
    }
    
    public Integer getANO(){
        return ANO;
    }

    public Integer getGENERO_ID(){
        return GENERO_ID;
    }

    public Double getPRECO(){
        return PRECO;
    }
    public Integer getESTOQUE(){
        return ESTOQUE;
    }
    public String getESTOQUE_STRING(){
        return ESTOQUE.toString();
    }
    public Integer getRESERVA(){
        return RESERVA;
    }
    public String getRESERVA_STRING(){
        return RESERVA.toString();
    }
    
    @Override
    public String toString(){return LIVRO_ID+"-"+TITULO;}
}
