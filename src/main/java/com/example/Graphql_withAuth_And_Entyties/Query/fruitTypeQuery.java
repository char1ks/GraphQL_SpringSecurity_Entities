package com.example.Graphql_withAuth_And_Entyties.Query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.Graphql_withAuth_And_Entyties.Model.Fruits.fruitType;
import com.example.Graphql_withAuth_And_Entyties.Service.fruitTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class fruitTypeQuery implements GraphQLQueryResolver {
    @Autowired
    private fruitTypeService operations;

    public List<fruitType> allFruitTypes(Integer count){
        return operations.getAllTypes(count);
    }
    public fruitType concreteFruitType(int id){
        return operations.getConcreteType(id);
    }
    public List<fruitType> allByActorCreate() {
        return operations.findAllByActorId();
    }
}

