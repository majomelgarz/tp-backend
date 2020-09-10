package py.com.progweb.prueba.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import py.com.progweb.prueba.ejb.ClienteBean;
import py.com.progweb.prueba.model.Cliente;

@Path("/clientes")
public class ClienteRest {

    @EJB
    private ClienteBean clienteBean;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar() {
        return Response.ok(clienteBean.listar()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregar(Cliente entity) {
        this.clienteBean.agregar(entity);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(Cliente cliente) {
        clienteBean.actualizar(cliente);
        return Response.ok().build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response borrar(@QueryParam("id") Long idCliente) {
        clienteBean.eliminar(idCliente);
        return Response.ok().build();
    }

}
