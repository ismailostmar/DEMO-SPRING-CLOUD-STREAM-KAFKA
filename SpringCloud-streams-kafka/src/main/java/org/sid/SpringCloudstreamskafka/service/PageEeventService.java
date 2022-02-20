package org.sid.SpringCloudstreamskafka.service;

import org.sid.SpringCloudstreamskafka.Entities.PageEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

// Déploiment d'un consomateur
@Service
public class PageEeventService {

    @Bean
    public Consumer<PageEvent> pageEventConsumer(){
        // input est un objet jaava PageEvent dont il utilise
        // une configuration par défaut
        return (input)->{
            System.out.println("************");
            System.out.println(input.toString());
            System.out.println("************");
        };
    }

    // Spring Cloud Stream Quand il recupere un objet de type Supplier il va le traiter avec un comportement par defaut
    // Chaque seconde il produit un evenement
    // Une fonction de tyoe Supplier produit un message dans un topic dont le nom est :
    public Supplier<PageEvent> pageEventSupplier(){
        return ()-> new PageEvent(
                Math.random()>0.5?"P1":"P2", // Page
                Math.random()>0.5?"U1":"U2", // User
                new Date(), // Date
                new Random().nextInt(9000)); // Duration
    }
}
