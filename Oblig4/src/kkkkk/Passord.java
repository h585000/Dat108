package kkkkk;

import javax.persistence.Embeddable;





@Embeddable
public class Passord {

	private String pwd_hash;
    private String pwd_salt;
    
	private Passord(String hash, String salt) {
		pwd_hash = hash;
		pwd_salt = salt;
	}
	
	
	public String getPwd_hash() {
		return pwd_hash;
	}


	public void setPwd_hash(String pwd_hash) {
		this.pwd_hash = pwd_hash;
	}


	public String getPwd_salt() {
		return pwd_salt;
	}


	public void setPwd_salt(String pwd_salt) {
		this.pwd_salt = pwd_salt;
	}


	public Passord() {}

	@Override
	public String toString() {
		return "Passord [pwd_hash=" + pwd_hash + ", pwd_salt=" + pwd_salt + "]";
	}

	public static Passord lagPassord(String passordKlartekst) {
		String salt = PassordHjelper.genererTilfeldigSalt();
		String hash = PassordHjelper.hashMedSalt2(passordKlartekst, salt);
		
		System.out.println(salt);
		System.out.println(hash);
		
		return new Passord(salt,hash);
	}
	
}
