/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.resource;

import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import restful.Model.DueniaModel;
import restful.service.DueniaService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
/**
 * REST Web Service
 *
 * @author Mario Andres
 */
@Path("duenia")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DueniaResource {
    
    public DueniaResource() {
    }

   DueniaService servicio = new DueniaService();

    @GET
    public ArrayList<DueniaModel> getDuenia() {

        return servicio.getDuenia();
    }

    
    @Path("/{DueniaCod}")
    @GET
    public DueniaModel getDuenia(@PathParam("DueniaCod") int codigo_due) {

        return servicio.getDuenia(codigo_due);
    }
    
    
    @POST
    public DueniaModel addDuenia(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        DueniaModel duenia = gson.fromJson(JSON, DueniaModel.class);
        return servicio.addDuenia(duenia);
    }
    
    @DELETE
    @Path("/{DueniaCod}")
    public String delCliente(@PathParam("DueniaCod") int codigo_due) {

        return servicio.delDuenia(codigo_due);

    }
    
    
    @PUT
    public DueniaModel updateDuenia(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        DueniaModel duenia = gson.fromJson(JSON, DueniaModel.class);
        return servicio.updateDuenia(duenia);
    }
    
    
    
    
    
}
