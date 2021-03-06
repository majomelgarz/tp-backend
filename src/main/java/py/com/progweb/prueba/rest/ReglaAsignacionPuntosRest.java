package py.com.progweb.prueba.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import py.com.progweb.prueba.ejb.ReglaAsignacionPuntosBean;
import py.com.progweb.prueba.model.ReglaAsignacionPuntos;

@Path("reglas-asignaciones")
@Consumes("application/json")
@Produces("application/json")
public class ReglaAsignacionPuntosRest {

    @Inject
    private ReglaAsignacionPuntosBean reglaAsignacionPuntosBean;

    @GET
    @Path("/")
    public Response listar() {
        return Response.ok(reglaAsignacionPuntosBean.listar()).build();
    }

    @POST
    @Path("/")
    public Response agregar(ReglaAsignacionPuntos entity) {
        this.reglaAsignacionPuntosBean.agregar(entity);
        return Response.ok().build();
    }

}
