package py.com.progweb.prueba.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import py.com.progweb.prueba.ejb.UsoPuntosCabeceraBean;
import py.com.progweb.prueba.model.UsoPuntosCabecera;

@Path("usos/cabeceras")
@Consumes("application/json")
@Produces("application/json")
public class UsoPuntosCabeceraRest {

    @Inject
    private UsoPuntosCabeceraBean usoPuntosCabeceraBean;

    @GET
    @Path("/")
    public Response listar() {
        return Response.ok(usoPuntosCabeceraBean.listar()).build();
    }

    @POST
    @Path("/")
    public Response agregar(UsoPuntosCabecera entity) {
        this.usoPuntosCabeceraBean.agregar(entity);
        return Response.ok().build();
    }
}
