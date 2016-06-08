package it.uniroma3.siw_progetto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;



@Entity
@NamedQuery(name="findAllAdmin",query="SELECT a FROM Administrator a")
public class Administrator {

	@Id
	private String id;
	
	@Column(nullable=false)
	private String nome;
	private String password;




	public Administrator (String nome, String id,String password){
		this.nome=nome;
		this.id=id;
		this.password= password;
	}

	public Administrator(){}


	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean CheckPassword(String s){
		return this.password.equals(s);
	}

	@Override
	public boolean equals(Object obj) {
		Administrator product = (Administrator)obj;
		return this.getId().equals(product.getId());
	}

	@Override
	public int hashCode() {
		return this.id.hashCode();
	}

	@Override
	public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Administrator"); 
                sb.append("{id=").append(id); 
                sb.append(", name='").append(nome);
                sb.append("}\n");
        return sb.toString();
	}

}
