package com.knf.dev.controller;



import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.knf.dev.model.User;
import com.knf.dev.repository.UserRepository;


@Path("/api/users")
public class UserController {

    private final UserRepository userRepository;

    @Inject
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GET
    public List<User> getUsers() {
        return userRepository.listAll();
    }

    

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser
            (@PathParam("id") String id) {
        return userRepository.findById(id);
    }
    
    /*
    @GET
    @Path("/{id}")
    public Response find(@PathParam("id") String id) {
 
    	Optional<User> findByIsbn = userRepository.findByIsbn(id);
    	
        return Response.ok(findByIsbn).build();
    }
    
    */
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateUser
            (@PathParam("id") String id, User user) {
    	
    	User entity = userRepository.findById(id);
          if(entity == null) {
              throw new NotFoundException();
          }
          // map all fields from the person parameter to the existing entity
     
    	
    }

    @POST
    @Transactional
    public Response addUser(User user) {
        userRepository.persist(user);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void deleteUser(@PathParam("id") String id) {
        User user = userRepository.findById(id);
        userRepository.delete(user);
    }
}