package py.com.progweb.prueba.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.progweb.prueba.model.Cliente;

@Stateless
public class ClienteBean {

    @PersistenceContext(unitName = "puntosPU")
    private EntityManager em;

    public void agregar(Cliente entity) {
        this.em.persist(entity);
    }

    public List<Cliente> listar() {
        Query q = this.em.createNativeQuery("select p.* from cliente p");
        return (List<Cliente>) q.getResultList();
    }

    public void eliminar(Long clienteId) {
        this.em.getTransaction().begin();
        Cliente c = em.find(Cliente.class, clienteId);
        this.em.remove(c);
        this.em.getTransaction().commit();
    }

    public void actualizar(Cliente cliente) {
        this.em.getTransaction().begin();
        this.em.merge(cliente);
        this.em.getTransaction().commit();
    }
}
