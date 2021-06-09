package org.pingpong.restjson;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@Transactional
@QuarkusTest
public class ServiceTest {

    @Inject
    ServiceFruit service;



    @Test
    public void list(){
        Assertions.assertThat(service.list()).hasSize(2);
    }

    @Test
    public void addlist(){

        Assertions.assertThat(service.list()).hasSize(2);
        service.add(new Fruit("Pomelo","bonito color"));
        Assertions.assertThat(service.list()).hasSize(3);
    
        Assertions.assertThat(service.list().stream().anyMatch(e->e.getName().equals("POMELO"))).isTrue();

    }

    @Test
    public void removeList(){

        Assertions.assertThat(service.list()).hasSize(2);
        service.add(new Fruit("Pomelo","bonito color"));
        Assertions.assertThat(service.list()).hasSize(3);
        service.remove("POMELO");
        Assertions.assertThat(service.list().stream().anyMatch(e->e.getName().equals("POMELO"))).isFalse();

    }



    
}
