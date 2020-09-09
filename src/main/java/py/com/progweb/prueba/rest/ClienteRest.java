package py.com.progweb.prueba.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import py.com.progweb.prueba.ejb.ClienteBean;
import py.com.progweb.prueba.model.Cliente;

@Path("clientes")
@Consumes("application/json")
@Produces("application/json")
public class ClienteRest {

    @Inject
    private ClienteBean clienteBean;

    @GET
    @Path("/")
    public Response listar() {
        return Response.ok(clienteBean.listar()).build();
    }

    @POST
    @Path("/")
    public Response agregar(Cliente entity) {
        this.clienteBean.agregar(entity);
        return Response.ok().build();
    }
}
