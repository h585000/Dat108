package kkkkk;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BrukerDao {
	
	@PersistenceContext(name = "brukerPU")
    private EntityManager em;
	
	public List<Bruker> hentAlleBrukere() {
		return em.createQuery("SELECT b FROM Bruker b ORDER BY b.fornavn ASC, b.etternavn ASC", Bruker.class).getResultList();
	}
	
	public Bruker hentBruker(String mobilnummer) {
		return em.find(Bruker.class, mobilnummer);
	}
	

	public void lagreNyBruker(Bruker nyBruker) {
		em.persist(nyBruker);
	}
}