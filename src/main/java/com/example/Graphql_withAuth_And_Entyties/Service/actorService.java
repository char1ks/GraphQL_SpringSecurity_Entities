package com.example.Graphql_withAuth_And_Entyties.Service;

import com.example.Graphql_withAuth_And_Entyties.Model.actor;
import com.example.Graphql_withAuth_And_Entyties.Model.actor_role;
import com.example.Graphql_withAuth_And_Entyties.Repository.actorRepository;
import com.example.Graphql_withAuth_And_Entyties.Security.actorDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class actorService implements UserDetailsService {
    @Autowired
    private actorRepository operations;

    public List<actor> getAllActors(Integer count){
        if (count != null && count > 0) {
            return operations.findAll().stream()
                    .limit(count)
                    .collect(Collectors.toList());
        }
        return operations.findAll();
    }
    public actor getConcreteActor(int id){
        return operations.findById(id).orElse(null);
    }
    public actor saveActor(String username,String password,int age,String actor_role){
        return operations.save(new actor(username,password,age, com.example.Graphql_withAuth_And_Entyties.Model.actor_role.valueOf(actor_role)));
    }
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<actor> actorFind= Optional.ofNullable(operations.findByUsername(s));
        if (actorFind.isEmpty()) {
            throw new UsernameNotFoundException("Actor не найден");
        }
        return new actorDetails(actorFind.get());
    }
}
