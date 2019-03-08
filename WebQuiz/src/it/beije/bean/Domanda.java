package it.beije.bean;

public class Domanda {

	private int id;
	private int chapter;
	private String testo;
	private Risposta risposta;
	
	
	public Domanda(int id, int chapter, String testo, Risposta risposta) {
		this.id = id;
		this.chapter = chapter;
		this.testo = testo;
		this.risposta = risposta;
	}
	
	public int getId() {
		return id;
	}
	
	public int getChapter() {
		return chapter;
	}
	
	public String getTesto() {
		return testo;
	}
	
	public Risposta getRisposta() {
		return risposta;
	}
	
}
