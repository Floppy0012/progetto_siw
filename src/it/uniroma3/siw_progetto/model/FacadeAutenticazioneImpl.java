package it.uniroma3.siw_progetto.model;

public class FacadeAutenticazioneImpl implements FacadeAutenticazione {

	@Override
	public Utente login(String username, String password) {
		ClinicaAccessPoint accesspoint = new ClinicaAccessPoint();
		Utente u = null;

		//controllo se sia un paziente
		if((accesspoint.getPaziente(username))!= null){
			Paziente p = accesspoint.getPaziente(username);
			if(p.CheckPassword(password)){
				u = new Utente(username,"paz");
			}
		}else{
			//oppure un amministratore
			if((accesspoint.getAmministratore(username))!= null){
				Administrator a = accesspoint.getAmministratore(username);
				if(a.CheckPassword(password))
					u = new Utente (username,"admin");
			}
		}
		//se non fosse nessuno dei due, restituisco null
		return u;
	}

}
