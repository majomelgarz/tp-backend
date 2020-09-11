package py.com.progweb.prueba.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.progweb.prueba.model.UsoPuntosCabecera;

@Stateless
public class UsoPuntosCabeceraBean {

    @PersistenceContext(unitName = "puntosPU")
    private EntityManager em;

    public void agregar(UsoPuntosCabecera entity) {
        this.em.persist(entity);
    }

    public List<UsoPuntosCabecera> listar() {
        Query q = this.em.createQuery("select p from UsoPuntosCabecera p");
        return (List<UsoPuntosCabecera>) q.getResultList();
    }
    public void eliminar(Long uso_puntos_cabeceraId) {
        this.em.getTransaction().begin();
        UsoPuntosCabecera uso = em.find(UsoPuntosCabecera.class, uso_puntos_cabeceraId);
        this.em.remove(uso);
        this.em.getTransaction().commit();
    }
        public void actualizar(UsoPuntosCabecera uso) {
        this.em.getTransaction().begin();
        this.em.merge(uso);
        this.em.getTransaction().commit();
    }
}
