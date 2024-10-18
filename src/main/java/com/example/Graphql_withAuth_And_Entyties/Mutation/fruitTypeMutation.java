package com.example.Graphql_withAuth_And_Entyties.Mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.Graphql_withAuth_And_Entyties.Model.Fruits.fruitType;
import com.example.Graphql_withAuth_And_Entyties.Service.fruitTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class fruitTypeMutation implements GraphQLMutationResolver {

    @Autowired
    private fruitTypeService operations;

    public fruitType createFruitType(String fruit_type_name,String short_description){
        return operations.saveType(fruit_type_name,short_description);
    }
}
