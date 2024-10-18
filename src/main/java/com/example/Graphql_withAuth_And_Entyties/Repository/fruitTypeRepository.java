package com.example.Graphql_withAuth_And_Entyties.Repository;

import com.example.Graphql_withAuth_And_Entyties.Model.Fruits.fruitType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface fruitTypeRepository extends JpaRepository<fruitType,Integer> {
}
