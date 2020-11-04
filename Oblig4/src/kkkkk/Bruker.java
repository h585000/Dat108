package kkkkk;


import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig4")
public class Bruker {

	@Id
	private String mobil;
  //  private int mobil;
    
   
    private String fornavn;
    
 
    private String etternavn;
    
    
    private String kjonn;
   
    
    @Embedded
    private Passord passord;
    
	public Bruker(String fornavn,String etternavn, Passord passord,String mobil,String kjonn) {
		this.fornavn = fornavn;
		this.etternavn=etternavn;
		this.passord = passord;
		this.mobil = mobil;
		this.kjonn=kjonn;
	}
	
	public Bruker() {}

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public Passord getPassord() {
		return passord;
	}

	public void setPassord(Passord passord) {
		this.passord = passord;
	}

	@Override
	public String toString() {
		return "Bruker [mobil=" + mobil + ", fornavn=" + fornavn + ", passord=" + passord + "]";
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}
	

	
	
	

	
}
