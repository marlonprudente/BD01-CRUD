
package entidades;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="livros")
public class Livros implements Serializable {
    @Id
    private Integer livro_id;
    private String titulo;
    private String autor;
    private String editora;
    private Integer ano;
    private String descricao;
    private Double preco;
    private Integer estoque;
    private Integer reserva;
      /*Como representar um BLOB? Array de bytes*/
    @Lob
    private Byte[] capa;
    
    @ManyToOne
    @JoinColumn(name ="GENERO_ID")
    private Generos livro_genero;
    
    @OneToMany(mappedBy = "pedido_detalhe_livro")
    List<PedidoDetalhes> livro_pedido_detalhes;
    
    @ManyToMany
    @JoinTable( name = "pedidos_detalhes",
                joinColumns = @JoinColumn(name="LIVRO_ID"),
                inverseJoinColumns = @JoinColumn(name = "PEDIDO_ID"))
    List<Pedidos> livro_pedidos;
    
    public Livros(){
        livro_id = 0;
        titulo = "";
        autor = "";
        editora = "";
        ano = 0;
        descricao = "";
        preco = 0.0;
        estoque = 0;
        reserva = 0;
    }
    
    public Integer getLivro_id()                    {return livro_id;}
    public void setLivro_id(Integer livro_id)       {this.livro_id = livro_id;}
    
    public String getTitulo()                   {return titulo;}
    public void setTitulo(String titulo)        {this.titulo = titulo;}

    public String getAutor()                    {return autor;}
    public void setAutor(String autor)          {this.autor = autor;}
    
    public String getEditora()                  {return editora;}
    public void setEditora(String editora)      {this.editora = editora;}
    
    public Integer getAno()                         {return ano;}
    public void setAno(Integer ano)                 {this.ano = ano;}
    
    public String getDescricao()                {return descricao;}
    public void setDescricao(String descricao)  {this.descricao = descricao;}
    
    public Double getPreco()                    {return preco;}
    public void setPreco(Double preco)          {this.preco = preco;}
    
    public Integer getEstoque()                     {return estoque;}
    public void setEstoque(Integer estoque)         {this.estoque = estoque;}
    
    public Integer getReserva()                     {return reserva;}
    public void setReserva(Integer reserva)         {this.reserva = reserva;}
    
//    public Image getCapa()                      {return ImageIO.;}   
    public Byte[] getCapaByte()                 {return capa;}
    public void setCapa(Byte[] capa)            {this.capa = capa;}
    
    public Generos getGenero()                  {return livro_genero;}
    public void setGenero(Generos genero)       {this.livro_genero = livro_genero;}
    
    public List<PedidoDetalhes> getDetalhes()   {return new ArrayList<>(livro_pedido_detalhes);}
    
    public List<Pedidos> getPedidos()           {return new ArrayList<>(livro_pedidos);}
    
    @Override
    public String toString(){return livro_id+"-"+titulo;}
}
