package com.example.Graphql_withAuth_And_Entyties.Model.Fruits;
import com.example.Graphql_withAuth_And_Entyties.Model.actor;
import javax.persistence.*;

@Entity
@Table(name = "fruit_type")
public class fruitType {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fruit_type_name")
    private String fruit_type_name;

    @Column(name = "short_description")
    private String short_description;

    @ManyToOne
    @JoinColumn(name = "actor_id", referencedColumnName = "id")
    private actor actor;

    public fruitType() {}


    public fruitType(String fruit_type_name, String short_description) {
        this.fruit_type_name = fruit_type_name;
        this.short_description = short_description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFruit_type_name() {
        return fruit_type_name;
    }

    public void setFruit_type_name(String fruit_type_name) {
        this.fruit_type_name = fruit_type_name;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public com.example.Graphql_withAuth_And_Entyties.Model.actor getActor() {
        return actor;
    }

    public void setActor(com.example.Graphql_withAuth_And_Entyties.Model.actor actor) {
        this.actor = actor;
    }
}
