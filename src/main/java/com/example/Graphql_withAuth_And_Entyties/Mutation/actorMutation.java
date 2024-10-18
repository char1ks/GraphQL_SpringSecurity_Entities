package com.example.Graphql_withAuth_And_Entyties.Mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.Graphql_withAuth_And_Entyties.Model.actor;
import com.example.Graphql_withAuth_And_Entyties.Service.actorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class actorMutation implements GraphQLMutationResolver {
    @Autowired
    private actorService operations;

    public actor createChief(String username,String password,int age,String actor_role){
        return operations.saveActor(username,password,age,actor_role);
    }
}
