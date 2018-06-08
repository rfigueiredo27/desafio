/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package b2w.desafio.ws;

import com.google.gson.Gson;

import b2w.desafio.dao.PlanetaDao;
import b2w.desafio.model.Planeta;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Path("planeta")
public class PlanetaWS {

    @Context
    private UriInfo context;

    
    
    public PlanetaWS() {
    }

    @GET
    @Produces("application/text")
    public String getJson() {
        return "meu primeiro WS RESTFULL";
    }
    
    @GET
    @Produces("application/json")
    @Path("Planeta/get/{id_planeta}")
    public String getPlanetaId(@PathParam("id_planeta") Long id_planeta)
    {
        Planeta p = new Planeta();
        p.setId_planeta(id_planeta);
        
        PlanetaDao dao = new PlanetaDao();
        p = dao.getPlanetaId(id_planeta);
       
        Gson g = new Gson();
        return g.toJson(p);
    }
    
    @GET
    @Produces("application/json")
    @Path("Planeta/get/{nome}")
    public String getPlanetaNome(@PathParam("nome") String nome)
    {
        Planeta p = new Planeta();
        p.setNome(nome);
        
        PlanetaDao dao = new PlanetaDao();
        p = dao.getPlanetaNome(nome);
       
        Gson g = new Gson();
        return g.toJson(p);
    }
    
    @GET
    @Produces("application/json")
    @Path("Planeta/list")
    public String listPlanetas()
    {
        List<Planeta> lista;
        
        PlanetaDao dao = new PlanetaDao();
        lista = dao.getPlanetas();
        
        //Converter para Gson
        Gson g = new Gson();
        return g.toJson(lista);
    }
    
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
