package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="generos")
public class Generos implements Serializable {    
    @Id
    private int genero_id;
    private String descricao;
    
    @OneToMany(mappedBy="livro_genero")
    private List<Livros> genero_livros;
    
    public Generos(){}

    public int getGenero_id()                   {return genero_id;}
    public void setDescricao(int genero_id)     {this.genero_id = genero_id;}

    public String getDescricao()                {return descricao;}
    public void setDescricao(String descricao)  {this.descricao = descricao;}
    
    public List<Livros> getLivros()             {return new ArrayList<>(genero_livros);}
    
    @Override
    public String toString(){return genero_id+"-"+descricao;}   
}
