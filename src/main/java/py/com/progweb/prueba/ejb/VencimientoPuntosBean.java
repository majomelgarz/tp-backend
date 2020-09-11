package py.com.progweb.prueba.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.progweb.prueba.model.VencimientoPuntos;

@Stateless
public class VencimientoPuntosBean {

    @PersistenceContext(unitName = "puntosPU")
    private EntityManager em;

    public void agregar(VencimientoPuntos entity) {
        this.em.persist(entity);
    }

    public List<VencimientoPuntos> listar() {
        Query q = this.em.createQuery("select p from VencimientoPuntos p");
        return (List<VencimientoPuntos>) q.getResultList();
    }
    public void eliminar(Long vencimiento_puntosId) {
        this.em.getTransaction().begin();
        VencimientoPuntos venc = em.find(VencimientoPuntos.class, vencimiento_puntosId);
        this.em.remove(venc);
        this.em.getTransaction().commit();
    }
    public void actualizar(VencimientoPuntos venc) {
        this.em.getTransaction().begin();
        this.em.merge(venc);
        this.em.getTransaction().commit();
    }
}
