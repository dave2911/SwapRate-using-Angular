package com.sim.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="RATES")
@XmlRootElement(name="rates")
public class Rates implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@XmlElement(name="swaprateid")
	private int swap_rate_id;
	
	@Column
	@XmlElement(name="date")
	private java.sql.Date date;
	
	@Column
	@XmlElement(name="inr")
	private float inr;

	@Column
	@XmlElement(name="cad")
	private float cad;
	
	@Column
	@XmlElement(name="aus")
	private float aus;
	
	@Column
	@XmlElement(name="eur")
	private float eur;
	
	@Column
	@XmlElement(name="lastupdated")
	private java.sql.Date last_updated;
	
	public float getInr() {
		return inr;
	}

	public void setInr(float inr) {
		this.inr = inr;
	}

	public float getCad() {
		return cad;
	}

	public void setCad(float cad) {
		this.cad = cad;
	}

	public float getAus() {
		return aus;
	}

	public void setAus(float aus) {
		this.aus = aus;
	}

	public float getEur() {
		return eur;
	}

	public void setEur(float eur) {
		this.eur = eur;
	}


	public int getSwap_rate_id() {
		return swap_rate_id;
	}

	public void setSwap_rate_id(int swap_rate_id) {
		this.swap_rate_id = swap_rate_id;
	}

	public java.sql.Date getDate() {
		return date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	public java.sql.Date getLast_updated() {
		return last_updated;
	}

	public void setLast_updated(java.sql.Date last_updated) {
		this.last_updated = last_updated;
	}	
}
