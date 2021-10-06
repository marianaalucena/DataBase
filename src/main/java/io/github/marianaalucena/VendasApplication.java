package io.github.marianaalucena;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class VendasApplication {

    public CommandLineRunner commandLineRunner(@Autowired Clientes clientes){
        return args -> {
          Cliente c = new Cliente(id: null, nome: "Mariana");
          clientes.save(c);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
