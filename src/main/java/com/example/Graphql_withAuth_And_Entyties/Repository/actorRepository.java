package com.example.Graphql_withAuth_And_Entyties.Repository;

import com.example.Graphql_withAuth_And_Entyties.Model.actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface actorRepository extends JpaRepository<actor,Integer> {
    actor findByUsername(String username);
}
