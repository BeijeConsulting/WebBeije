package it.beije.servlet;

public class User {
	
	private String nome;
	private String cognome;
	private String sesso;
	private String email;
	private String telefono;
	private String iscrizione;
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public String getSesso() {
		return sesso;
	}
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getIscrizione() {
		return iscrizione;
	}
	public void setIscrizione (String iscrizione) {
		this.iscrizione = iscrizione;
	}
	
}
