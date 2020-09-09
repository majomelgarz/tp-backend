package py.com.progweb.prueba.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import py.com.progweb.prueba.ejb.ConceptoPuntosBean;
import py.com.progweb.prueba.model.ConceptoPuntos;

@Path("conceptos")
@Consumes("application/json")
@Produces("application/json")
public class ConceptoPuntosRest {

    @Inject
    private ConceptoPuntosBean ConceptoPuntosBean;

    @GET
    @Path("/")
    public Response listar() {
        return Response.ok(ConceptoPuntosBean.listar()).build();
    }

    @POST
    @Path("/")
    public Response agregar(ConceptoPuntos entity) {
        this.ConceptoPuntosBean.agregar(entity);
        return Response.ok().build();
    }

}
