package org.pingpong.restjson;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.quarkus.hibernate.orm.panache.PanacheEntity;//Importado con el comando de mvnw add-extension 

@Entity
@JsonPropertyOrder({"name", "decription"})
public class Fruit extends PanacheEntity{

    @NotBlank
    @Column(unique=true)
    public String name;

    @NotEmpty
    @Column
    public String description;

    public Fruit() {
    }

    public Fruit(String name, String description) {
        this.name = name;
        this.description = description;
    }

    //devuelve los nombres con uppercase
    public String getName() {
        return name.toUpperCase();
    }

    //guarda los nombres en la base de datos en minúscula
    public void setName(String name) {
        this.name = name.toLowerCase();
    }

    /*
    // substituit getName por este metodo en
    // la serializacion a JSON
    @JsonGetter("name")
    public String nombre() {
        return "UMAMI";
    }*/

}
