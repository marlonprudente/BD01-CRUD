package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="usuarios")
public class Usuarios implements Serializable{
    @Id
    private int usuario_id;
    private String nome;
    private String endereco;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private String fone;
    private String login;
    private String senha;

    @OneToMany(mappedBy="pedido_usuario")
    private List<Pedidos> usuario_pedidos;

    public Usuarios(){}
    
    public int getUsuario_id()                  {return usuario_id;}
    public void setUsuario_id(int usuario_id)   {this.usuario_id = usuario_id;}
    
    public String getNome()                     {return nome;}
    public void setNome(String nome)            {this.nome = nome;}
    
    public String getEndereco()                 {return endereco;}
    public void setEndereco(String endereco)    {this.endereco = endereco;}
    
    public String getBairro()                   {return bairro;}
    public void setBairro(String bairro)        {this.bairro = bairro;}
    
    public String getCidade()                   {return cidade;}
    public void setCidade(String cidade)        {this.cidade = cidade;}
    
    public String getUf()                       {return uf;}
    public void setUf(String uf)                {this.uf = uf;}
    
    public String getCep()                      {return cep;}
    public void setCep(String cep)              {this.cep = cep;}
        
    public String getFone()                     {return fone;}
    public void setFone(String fone)            {this.fone = fone;}
    
    public String getLogin()                    {return login;}
    public void setLogin(String login)          {this.login = login;}
    
    public String getSenha()                    {return senha;}
    public void setSenha(String senha)          {this.senha = senha;}
    
    public List<Pedidos> getPedidos()           {return usuario_pedidos;}

    @Override
    public String toString()                    {return usuario_id+"-"+nome;}
}
