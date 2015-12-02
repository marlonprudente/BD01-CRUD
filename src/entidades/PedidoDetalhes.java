package entidades;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pedidos_detalhes")
public class PedidoDetalhes implements Serializable {
    @Id
    Integer detalhe_id;
    Integer qtd;

    @ManyToOne
    @JoinColumn(name="PEDIDO_ID")
    Pedidos pedido_detalhe_pedido;
    
    @ManyToOne
    @JoinColumn(name="LIVRO_ID")
    Livros pedido_detalhe_livro;
    
    public PedidoDetalhes(){
        detalhe_id = 0;
        qtd = 0;
    }
    
    public Integer getDetalhe_id()                                  {return detalhe_id;}
    public void setDetalhe_id(Integer detalhe_id)                   {this.detalhe_id = detalhe_id;}
    
    public Integer getQtd()                                         {return qtd;}
    public void setQtd(Integer qtd)                                 {this.qtd = qtd;}
    
    public Pedidos getPedido()                                      {return pedido_detalhe_pedido;}
    public void setPedido(Pedidos pedido_detalhes_pedido)           {this.pedido_detalhe_pedido = pedido_detalhes_pedido;}
   
    public Livros getLivro()                                        {return pedido_detalhe_livro;}
    public void setLivro(Livros pedido_detalhe_livro)               {this.pedido_detalhe_livro = pedido_detalhe_livro;}
    
    @Override
    public String toString(){return "["+detalhe_id+"] "+pedido_detalhe_livro.getLivro_id()+"# \""+pedido_detalhe_livro.getTitulo()+"\" x"+qtd;}
}
