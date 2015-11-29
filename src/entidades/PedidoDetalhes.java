package entidades;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pedidos_detalhes")
public class PedidoDetalhes implements Serializable {
    @Id
    int detalhe_id;
    int qtd;

    @ManyToOne
    @JoinColumn(name="PEDIDO_ID")
    Pedidos pedido_detalhe_pedido;
    
    @ManyToOne
    @JoinColumn(name="LIVRO_ID")
    Livros pedido_detalhe_livro;
    
    public PedidoDetalhes(){}
    
    public int getDetalhe_id()                                  {return detalhe_id;}
    public void setDetalhe_id(int detalhe_id)                   {this.detalhe_id = detalhe_id;}
    
    public int getQtd()                                         {return qtd;}
    public void setQtd(int qtd)                                 {this.qtd = qtd;}
    
    public Pedidos getPedido()                                  {return pedido_detalhe_pedido;}
    public void setPedido(Pedidos pedido_detalhes_pedido)       {this.pedido_detalhe_pedido = pedido_detalhes_pedido;}
   
    public Livros getLivro()                                    {return pedido_detalhe_livro;}
    public void setLivro(Livros pedido_detalhe_livro)          {this.pedido_detalhe_livro = pedido_detalhe_livro;}
    
    @Override
    public String toString(){return detalhe_id+"-"+pedido_detalhe_livro.getTitulo()+"-"+qtd;}
}
