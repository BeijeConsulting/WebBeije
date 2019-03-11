package it.beije.gestionale.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "storico_clienti")
public class StoricoClienti {

	@Id @GeneratedValue
	@Column (name = "id")
	private int id;
	
	@Column (name = "id_dipendente")
	private int idDipendente;
	
	@Column (name = "id_cliente")
	private int idCliente;
	
	@Column(name = "data_inizio")
	private LocalDate dataInizio;
	
	@Column(name = "data_fine")
	private LocalDate dataFine;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getIdDipendente() {
		return idDipendente;
	}
	public void setIdDipendente(int idDipendente) {
		this.idDipendente = idDipendente;
	}

	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public LocalDate getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}

	public LocalDate getDataFine() {
		return dataFine;
	}
	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}
	
	
	//private Cliente cliente;
}
