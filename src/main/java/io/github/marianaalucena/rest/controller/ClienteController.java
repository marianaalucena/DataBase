package io.github.marianaalucena.rest.controller;

import io.github.marianaalucena.domain.entity.Cliente;
import io.github.marianaalucena.domain.repository.Clientes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
//@RequestMapping("/api/clientes")
public class ClienteController {

    private Clientes clientes;

    public ClienteController(Clientes clientes) {
        this.clientes = clientes;
    }

    @GetMapping("/api/clientes/{id}")
    @ResponseBody
    public ResponseEntity getClienteById(@PathVariable Integer id){
        Optional<Cliente> cliente = clientes.findById(id);
        if(cliente.isPresent()){
            return ResponseEntity.ok(cliente.get());
        }

        return ResponseEntity.notFound().build();
    }



//    @RequestMapping(
//            value = {"/api/clientes/hello/{nome}", "/api/hello"},
//            method = RequestMethod.GET,
//            consumes = {"application/json", "application/xml"}
//    )
//    @ResponseBody
//    public String helloCliente(@PathVariable("nome") String nomeCliente){
//        return String.format("Hello %s ", nomeCliente);
//    }
//
//    @RequestMapping(
//            value = {"/api/clientes/hello/{nome}", "/api/hello"},
//            method = RequestMethod.POST,
//            consumes = {"application/json", "application/xml"},
//            produces = {"application/json", "application/xml"}
//    )
//    @ResponseBody
//    public String helloClientePost(@PathVariable("nome") String nomeCliente, @RequestBody Cliente cliente){
//        return String.format("Hello %s ", nomeCliente);
//    }



}
