package it.uniroma3.siw_progetto.model;


import javax.persistence.*;

@Entity
public class Administrator {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable=false)
	private String nome;
	@Column(unique=true)
	private String codiceid;
	//vedere come rendere pesistente
	private String password;

public Administrator (String nome, String codiceid,String password){
	this.nome=nome;
	this.codiceid=codiceid;
	this.password= password;
}
public Administrator(){
	
}

	public boolean CheckPassword(String s){
		return this.password.equals(s);
	}

}
