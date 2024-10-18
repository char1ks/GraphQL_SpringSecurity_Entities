package com.example.Graphql_withAuth_And_Entyties.Security;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.example.Graphql_withAuth_And_Entyties.Model.actor;
import java.util.Collection;
import java.util.List;

public class actorDetails implements UserDetails {
    private actor actor;

    public actorDetails(actor actor) {
        this.actor = actor;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return actor.getPassword();
    }

    @Override
    public String getUsername() {
        return actor.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public com.example.Graphql_withAuth_And_Entyties.Model.actor getActor() {
        return actor;
    }
}

