package org.pingpong.restjson;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;


//Quiarkus  instancia un objeto  de la clase ServiceFruit
//cuando es necesario que persiste hasta el final de la ejecución.

@ApplicationScoped
public class ServiceFruit {
 

    public ServiceFruit() { 
        // CDI
    }

    
    @Transactional
    public Set<Fruit> list() {
        
        Stream<Fruit> memoryFruits = Fruit.streamAll();
        return memoryFruits.collect(Collectors.toSet());
    }

    @Transactional
    public void add(Fruit fruit) {
        fruit.persist();
    }

    public void remove(String name) {

        Fruit frutaDelete = Fruit.find("name", name).firstResult();
        frutaDelete.delete();
    }

    public Optional<Fruit> getFruit(String name) {
        return name.isBlank()? Optional.ofNullable(null) : Fruit.find("name", name).firstResultOptional();
    }
}
