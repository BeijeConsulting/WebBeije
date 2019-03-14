package it.beije.bean;

public class Domanda {

	private int id;
	private String book;
	private int chapter;
	private int question;
	private String testo;
	private Risposta risposta;
	
	
	public Domanda(int id, String book, int chapter, int question, String testo, Risposta risposta) {
		this.id = id;
		this.book = book;
		this.chapter = chapter;
		this.question = question;
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

	public String getBook() {
		return book;
	}

	public int getQuestion() {
		return question;
	}
	
	
}
