package com.knf.dev.repository;





import javax.enterprise.context.ApplicationScoped;

import com.knf.dev.model.User;

import io.quarkus.hibernate.orm.panache.PanacheRepository;





@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
   
    
    public User findById(String id) {
        return find("id", id).firstResult();
    }
    
    

}