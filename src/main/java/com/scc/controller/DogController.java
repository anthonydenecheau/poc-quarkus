package com.scc.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.acme.config.Book;

import com.scc.model.Dog;

import io.quarkus.panache.common.Sort;

@Path("/dogs")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DogController {

    @GET
    public List<Dog> getAll() {
        return Dog.listAll(Sort.by("name"));
    }
    
    @POST
    @Transactional
    public Response create(@Valid Dog sujet){
    	sujet.persist();
        return Response.status(Response.Status.CREATED).entity(sujet).build();
    }
    
    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") long id) {
    	Dog entity = Dog.findById(id);
        entity.delete();
        return Response.status(Response.Status.OK).build();
    }    
}
