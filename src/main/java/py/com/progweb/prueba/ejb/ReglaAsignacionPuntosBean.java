package py.com.progweb.prueba.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.progweb.prueba.model.ReglaAsignacionPuntos;

@Stateless
public class ReglaAsignacionPuntosBean {

    @PersistenceContext(unitName = "puntosPU")
    private EntityManager em;

    public void agregar(ReglaAsignacionPuntos entity) {
        this.em.persist(entity);
    }

    public List<ReglaAsignacionPuntos> listar() {
        Query q = this.em.createQuery("select p from ReglaAsignacionPuntos p");
        return (List<ReglaAsignacionPuntos>) q.getResultList();
    }
    public void eliminar(Long regla_asignacion_puntosId) {
        this.em.getTransaction().begin();
        ReglaAsignacionPuntos regla = em.find(ReglaAsignacionPuntos.class, regla_asignacion_puntosId);
        this.em.remove(regla);
        this.em.getTransaction().commit();
    }
    
    public void actualizar(ReglaAsignacionPuntos regla) {
        this.em.getTransaction().begin();
        this.em.merge(regla);
        this.em.getTransaction().commit();
    }
}
