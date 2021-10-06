package io.github.marianaalucena;

import io.github.marianaalucena.domain.entity.Cliente;
import io.github.marianaalucena.domain.entity.Pedido;
import io.github.marianaalucena.domain.repository.Clientes;
import io.github.marianaalucena.domain.repository.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;


@SpringBootApplication
public class VendasApplicationOld {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes, @Autowired Pedidos pedidos){
        return args -> {
            System.out.println("SALVANDO CLIENTES");
            Cliente mariana = new Cliente ("Mariana");
            clientes.save(mariana);

            Pedido p = new Pedido();
            p.setCliente(mariana);
            p.setDataPedido(LocalDate.now());
            p.setTotal(BigDecimal.valueOf(100));

            pedidos.save(p);

            pedidos.findByCliente(mariana).forEach(System.out::println);

//            Cliente cliente = clientes.findClienteFetchPedidos(mariana.getId());
//            System.out.println(cliente);
//            System.out.println(cliente.getPedidos());
//
//            List<Cliente> todos = clientes.findAll();
//            todos.forEach(System.out::println);
//
//            boolean existe = clientes.existsByNome("Mariana");
//            System.out.println("Existe uma cliente chamada Mariana? " + existe);
//
//            System.out.println("ATUALIZANDO CLIENTES");
//            todos.forEach(c -> {
//              c.setNome(c.getNome() + " atualizado");
//              clientes.save(c);
//            });
//
//            todos = clientes.findAll();
//            todos.forEach(System.out::println);
//
//            System.out.println("BUSCANDO CLIENTES POR NOME");
//            clientes.findByNomeLike("ana").forEach(System.out::println);
//
//            List<Cliente> result = clientes.encontrarPorNomeSql("Pedro");
//            result.forEach(System.out::println);



//            System.out.println("EXCLUINDO CLIENTES");
//            clientes.findAll().forEach(c-> {
//                clientes.delete(c);
//            });
//            todos = clientes.findAll();
//            if(todos.isEmpty()){
//                System.out.println("Nenhum cliente encontrado");
//            } else {
//                todos.forEach(System.out::println);
//            }

//            clientes.salvar(new Cliente("Mariana"));
//            clientes.salvar(new Cliente("Pedro"));

//            List<Cliente> todos = clientes.obterTodos();
//            todos.forEach(System.out::println);
//
//            System.out.println("ATUALIZANDO CLIENTES");
//            todos.forEach(c -> {
//              c.setNome(c.getNome() + " atualizado");
//              clientes.atualizar(c);
//            });

//            System.out.println("BUSCANDO CLIENTES POR NOME");
//            clientes.buscarPorNome("ana").forEach(System.out::println);

//            System.out.println("EXCLUINDO CLIENTES");
//            clientes.obterTodos().forEach(c-> {
//                clientes.deletar(c);
//            });
//            todos = clientes.obterTodos();
//            if(todos.isEmpty()){
//                System.out.println("Nenhum cliente encontrado");
//            } else {
//                todos.forEach(System.out::println);
//            }

        };

    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplicationOld.class, args);
    }
}
