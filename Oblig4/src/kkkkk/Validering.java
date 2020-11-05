package kkkkk;

import javax.servlet.http.HttpServletRequest;

public class Validering {
	

	private String fornavn;
	private String etternavn;
	private String mobil;
	private String passord;
	private String passord2;
	private String kjonn;

	public Validering(HttpServletRequest request) {
		this.fornavn = request.getParameter("fornavn");
		this.etternavn = request.getParameter("etternavn");
		this.mobil = request.getParameter("mobil");
		this.passord = request.getParameter("passord");
		this.passord2 = request.getParameter("passord2");
		this.kjonn = request.getParameter("kjonn");
	}
	
	public Validering(String fornavn, String etternavn, String mobil, String passord, String passord2, String kjonn) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.mobil = mobil;
		this.passord = passord;
		this.passord2 = passord2;
		this.kjonn = kjonn;
	}
	public boolean erFornavnGyldig() {
		return fornavn != null && fornavn.length()>=2 && fornavn.length()<=20 && Character.isUpperCase(fornavn.charAt(0));
				
				
		
	}
	public boolean erEtternavnGyldig() {
		return etternavn != null && fornavn.length()>=2 && fornavn.length()<=20 && Character.isUpperCase(etternavn.charAt(0));
		
	}
	public boolean erMobilGyldig() {
		return mobil != null && mobil.matches("^\\d{8}$");
	}
	
	public boolean erKjonnGyldig() {
		return kjonn != null;
	}
	
	public boolean erPassordGyldig() {
		return passord != null && passord.length() <= 8 && passord.equals(passord2);
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	public String getPassord2() {
		return passord2;
	}

	public void setPassord2(String passord2) {
		this.passord2 = passord2;
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}
	
	

}
