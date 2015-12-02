package entidades;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name="pedidos")
public class Pedidos implements Serializable {
    @Id
    private Integer pedido_id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_pedido;
    private Integer tipo_pag;

    @ManyToOne
    @JoinColumn(name = "USUARIO_ID")
    Usuarios pedido_usuario;
    
    @OneToMany(mappedBy = "pedido_detalhe_pedido", cascade = CascadeType.PERSIST)
    List<PedidoDetalhes> pedido_pedido_detalhes;
    
    @ManyToMany
    @JoinTable( name = "pedidos_detalhes",
                joinColumns = @JoinColumn(name="PEDIDO_ID"),
                inverseJoinColumns = @JoinColumn(name = "LIVRO_ID"))
    List<Livros> pedido_livros;
    
    public Pedidos(){
        pedido_id = 0;
        data_pedido = new Date(0L);
        tipo_pag = 0;
    }
    
    public Integer getPedido_id()                       {return pedido_id;}
    public void setPedido_id(Integer pedido_id)         {this.pedido_id = pedido_id;}
    
    public Date getData_pedido()                        {return data_pedido;}
    public void setData_pedido(Date data_pedido)        {this.data_pedido = data_pedido;}
    
    public Integer getTipo_pag()                        {return tipo_pag;}
    public void setTipo_pag(Integer tipo_pag)           {this.tipo_pag = tipo_pag;}
    
    public Usuarios getUsuario()                        {return pedido_usuario;}
    public void setUsuario(Usuarios pedido_usuario)     {this.pedido_usuario = pedido_usuario;}
    
    public List<PedidoDetalhes> getDetalhes()           {return new ArrayList<>(pedido_pedido_detalhes);}
    public void setDetalhes(List<PedidoDetalhes> detalhes){this.pedido_pedido_detalhes = detalhes;}
    
    public ArrayList<Livros> getLivros()                {return new ArrayList<>(pedido_livros);}
    
    @Override
    public String toString(){return "["+pedido_id+"] "+String.format("%02d/%02d/%04d", data_pedido.getDay(), data_pedido.getMonth(), data_pedido.getYear())+"-"+pedido_usuario.getNome()+"-"+tipo_pag;}
}
