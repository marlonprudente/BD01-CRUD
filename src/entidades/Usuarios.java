package entidades;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="usuarios")
public class Usuarios implements Serializable{
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer usuario_id;
    private String nome;
    private String endereco;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private String fone;
    private String login;
    private String senha;

    @OneToMany(mappedBy="pedido_usuario", cascade = CascadeType.REMOVE)
    private List<Pedidos> usuario_pedidos;

    public Usuarios(){
        usuario_id = 0;
        nome = "";
        endereco = "";
        bairro = "";
        cidade = "";
        uf = "";
        cep = "";
        fone = "";
        login = "";
        senha = "";
    }
    
    public Integer getUsuario_id()                  {return usuario_id;}
    public void setUsuario_id(Integer usuario_id)   {Integer oldUsuario_id = this.usuario_id;
this.usuario_id = usuario_id;changeSupport.firePropertyChange("usuario_id", oldUsuario_id, usuario_id);
}
    
    public String getNome()                     {return nome;}
    public void setNome(String nome)            {String oldNome = this.nome;
this.nome = nome;changeSupport.firePropertyChange("nome", oldNome, nome);
}
    
    public String getEndereco()                 {return endereco;}
    public void setEndereco(String endereco)    {String oldEndereco = this.endereco;
this.endereco = endereco;changeSupport.firePropertyChange("endereco", oldEndereco, endereco);
}
    
    public String getBairro()                   {return bairro;}
    public void setBairro(String bairro)        {String oldBairro = this.bairro;
this.bairro = bairro;changeSupport.firePropertyChange("bairro", oldBairro, bairro);
}
    
    public String getCidade()                   {return cidade;}
    public void setCidade(String cidade)        {String oldCidade = this.cidade;
this.cidade = cidade;changeSupport.firePropertyChange("cidade", oldCidade, cidade);
}
    
    public String getUf()                       {return uf;}
    public void setUf(String uf)                {String oldUf = this.uf;
this.uf = uf;changeSupport.firePropertyChange("uf", oldUf, uf);
}
    
    public String getCep()                      {return cep;}
    public void setCep(String cep)              {String oldCep = this.cep;
this.cep = cep;changeSupport.firePropertyChange("cep", oldCep, cep);
}
        
    public String getFone()                     {return fone;}
    public void setFone(String fone)            {String oldFone = this.fone;
this.fone = fone;changeSupport.firePropertyChange("fone", oldFone, fone);
}
    
    public String getLogin()                    {return login;}
    public void setLogin(String login)          {String oldLogin = this.login;
this.login = login;changeSupport.firePropertyChange("login", oldLogin, login);
}
    
    public String getSenha()                    {return senha;}
    public void setSenha(String senha)          {String oldSenha = this.senha;
this.senha = senha;changeSupport.firePropertyChange("senha", oldSenha, senha);
}
    
    public List<Pedidos> getPedidos()           {return usuario_pedidos;}

    @Override
    public String toString()                    {return usuario_id+"-"+nome;}

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
}
