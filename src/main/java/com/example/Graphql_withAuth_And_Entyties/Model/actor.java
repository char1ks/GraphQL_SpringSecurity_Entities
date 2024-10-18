package com.example.Graphql_withAuth_And_Entyties.Model;

import com.example.Graphql_withAuth_And_Entyties.Model.Fruits.fruitType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "actors")
public class actor {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "age")
    private int age;

    @Column(name = "actor_role")
    @Enumerated(EnumType.STRING)
    private actor_role actor_role;

    @OneToMany(mappedBy = "actor",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<fruitType> fruitTypes;

    public actor() {}

    public actor(String username, String password, int age, com.example.Graphql_withAuth_And_Entyties.Model.actor_role actor_role) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.actor_role = actor_role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public com.example.Graphql_withAuth_And_Entyties.Model.actor_role getActor_role() {
        return actor_role;
    }

    public void setActor_role(com.example.Graphql_withAuth_And_Entyties.Model.actor_role actor_role) {
        this.actor_role = actor_role;
    }

    public List<fruitType> getFruitTypes() {
        return fruitTypes;
    }

    public void setFruitTypes(List<fruitType> fruitTypes) {
        this.fruitTypes = fruitTypes;
    }
}

