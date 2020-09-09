package py.com.progweb.prueba.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.progweb.prueba.model.BolsaPuntos;

@Stateless
public class BolsaPuntosBean {

    @PersistenceContext(unitName = "puntosPU")
    private EntityManager em;

    public void agregar(BolsaPuntos entity) throws Exception {
        if (entity== null){
            throw new Exception();
        }
        
        this.em.persist(entity);
    }

    public List<BolsaPuntos> listar() {
        Query q = this.em.createQuery("select p from BolsaPuntos p");
        return (List<BolsaPuntos>) q.getResultList();
    }
}
