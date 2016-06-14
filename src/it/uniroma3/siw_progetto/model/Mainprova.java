package it.uniroma3.siw_progetto.model;


public class Mainprova {

	public static void main(String[] args) {
		ClinicaAccessPoint accessPoint= new ClinicaAccessPoint();
		Prerequisito prerequisito = new Prerequisito("NO IN CINTA","le donne gravide non devono fare questo test");
		accessPoint.creaPrerequisito(prerequisito);
		Prerequisito prerequisito1 = new Prerequisito("DIGIUNO","chi si presenta deve stare a digiuno per 12 ore");
		accessPoint.creaPrerequisito(prerequisito1);
		
		Administrator administrator = new Administrator("Daniele","codice","password");
		accessPoint.salvaAmministratore(administrator);
		
		
		accessPoint.closeEntityManagerFactory();

	}

}