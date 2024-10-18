package com.example.Graphql_withAuth_And_Entyties.Service;

import com.example.Graphql_withAuth_And_Entyties.Model.Fruits.fruitType;
import com.example.Graphql_withAuth_And_Entyties.Repository.fruitTypeRepository;
import com.example.Graphql_withAuth_And_Entyties.Security.actorDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class fruitTypeService {
    @Autowired
    private fruitTypeRepository operations;

    public List<fruitType> getAllTypes(Integer count){
        if (count != null && count > 0) {
            return operations.findAll().stream()
                    .limit(count)
                    .collect(Collectors.toList());
        }
        return operations.findAll();
    }
    public List<fruitType> findAllByActorId() {
        actorDetails userDetails = (actorDetails)  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getActor().getFruitTypes();
    }
    public fruitType getConcreteType(int id){
        return operations.findById(id).orElse(null);
    }
    public fruitType saveType(String fruit_type_name,String short_description){
        fruitType fruitType=new fruitType(fruit_type_name,short_description);
        actorDetails userDetails = (actorDetails)  SecurityContextHolder.getContext().getAuthentication().getPrincipal();// ю
        userDetails.getActor().getFruitTypes().add(fruitType);
        fruitType.setActor(userDetails.getActor());
        return operations.save(fruitType);
    }
}
