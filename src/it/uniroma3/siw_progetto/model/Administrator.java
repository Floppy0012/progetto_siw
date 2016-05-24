package it.uniroma3.siw_progetto.model;

public class Administrator {
	private String nome;
	private String codiceid;
	private String password;


	public boolean CheckPassword(String s){
		return this.password.equals(s);
	}

}
