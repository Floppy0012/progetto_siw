package it.uniroma3.siw_progetto.model;

import javax.persistence.*;

@Entity
public class TipoEsame {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String nome;
	@Column
	private String descrizione;
	@Column
	private float costo;
	

}
