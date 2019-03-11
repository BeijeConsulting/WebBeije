package it.beije.gestionale.entities;

import javax.persistence.*;

import org.hibernate.annotations.CollectionOfElements;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="dipendenti")
//@SecondaryTable(name = "storico_clienti", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id"))
public class Dipendente {
	
	@Id @GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cognome")
	private String cognome;
	
	@Column(name = "data_nascita")
	private LocalDate dataNascita;
	
	@Column(name = "luogo_nascita")
	private String luogoNascita;
	
	@Column(name = "sesso")
	private char sesso;
	
	@Column(name = "codice_fiscale")
	private String codiceFiscale;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "mail")
	private String mail;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "dipendente_tecnologie",
            joinColumns = @JoinColumn(name = "id_dipendente"),
            inverseJoinColumns = @JoinColumn(name = "id_tecnologia")
    )
	private Set<Tecnologia> tecnologie;
	
//	@JoinTable(
//			name = "storico_clienti",
//			joinColumns = @JoinColumn(name = "id_dipendente")
//	)
//	@OneToMany(fetch=FetchType.LAZY)//or EAGER

	@Transient
	private List<StoricoClienti> storicoClienti;
	
	public List<StoricoClienti> getStoricoClienti() {
		return storicoClienti;
	}

	public void setStoricoClienti(List<StoricoClienti> storicoClienti) {
		this.storicoClienti = storicoClienti;
	}


	@Transient
	private String livelloEsperienza;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getLuogoNascita() {
		return luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public char getSesso() {
		return sesso;
	}

	public void setSesso(char sesso) {
		this.sesso = sesso;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public Set<Tecnologia> getTecnologie() {
		return tecnologie;
	}

	public void setTecnologie(Set<Tecnologia> tecnologie) {
		this.tecnologie = tecnologie;
	}

	
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("id : ").append(id).append(" | ");
		b.append("nome : ").append(nome).append(" | ");
		b.append("cognome : ").append(cognome).append(" | ");
		b.append("data di nascita : ").append(dataNascita).append(" | ");
		b.append("luogo di nascita : ").append(luogoNascita).append(" | ");
		b.append("sesso : ").append(sesso).append(" | ");
		b.append("codice fiscale : ").append(codiceFiscale).append(" | ");
		b.append("telefono : ").append(telefono).append(" | ");
		b.append("email : ").append(mail).append(" | ");
		b.append("storicoClienti : ").append(storicoClienti).append(" | ");
		
		return b.toString();
	}

}

/*
CREATE TABLE dipendenti (
  id int NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100),
  cognome VARCHAR(100),
  data_nascita date,
  luogo_nascita VARCHAR(100),
  sesso char(1),
  codice_fiscale VARCHAR(20),
  telefono VARCHAR(20),
  mail VARCHAR(100),
  PRIMARY KEY (id)
)
*/