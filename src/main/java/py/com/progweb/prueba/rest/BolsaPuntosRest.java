package py.com.progweb.prueba.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import py.com.progweb.prueba.ejb.BolsaPuntosBean;
import py.com.progweb.prueba.model.BolsaPuntos;

@Path("/bolsas")
public class BolsaPuntosRest {

    @Inject
    private BolsaPuntosBean bolsaPuntosBean;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar() {
        return Response.ok(bolsaPuntosBean.listar()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregar(BolsaPuntos entity) throws Exception {
        this.bolsaPuntosBean.agregar(entity);
        return Response.ok().build();
    }
}
