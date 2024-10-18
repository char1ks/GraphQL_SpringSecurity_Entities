package com.example.Graphql_withAuth_And_Entyties.Query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.Graphql_withAuth_And_Entyties.Model.actor;
import com.example.Graphql_withAuth_And_Entyties.Security.actorDetails;
import com.example.Graphql_withAuth_And_Entyties.Service.actorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class actorQuery implements GraphQLQueryResolver {
    @Autowired
    private actorService operations;
    @Autowired
    private AuthenticationManager authenticate;


    public List<actor>allActors(Integer count){
        return operations.getAllActors(count);
    }

    @PreAuthorize("isAuthenticated()")
    public actor currentActor(){
        actorDetails userDetails = (actorDetails)  SecurityContextHolder.getContext().getAuthentication().getPrincipal();// ю
        return userDetails.getActor();
    }

    public actor concreteActor(int id){
        return operations.getConcreteActor(id);
    }
    public actor loginActor(String username,String password){
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, password);
        try {
            Authentication authentication = authenticate.authenticate(auth);
            SecurityContextHolder.getContext().setAuthentication(authentication); // Сохраняем аутентификаци
            actorDetails userDetails = (actorDetails) authentication.getPrincipal();// ю
            return userDetails.getActor();
        } catch (Exception exc) {
            System.out.println("Authentication failed: " + exc.getMessage());
            return null;
        }
    }
}
