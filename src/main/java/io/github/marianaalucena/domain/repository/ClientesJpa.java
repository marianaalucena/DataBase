package io.github.marianaalucena.domain.repository;

import io.github.marianaalucena.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
public class ClientesJpa {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Cliente salvar(Cliente cliente){
        entityManager.persist(cliente);
        return  cliente;
    }

    @Transactional
    public Cliente atualizar(Cliente cliente){
        entityManager.merge(cliente);
        return cliente;
    }

    @Transactional
    public void deletar(Cliente cliente){
        if(!entityManager.contains(cliente)){
            cliente = entityManager.merge(cliente);
        }
        entityManager.remove(cliente);
    }

    @Transactional
    public void deletar(Integer id){
        Cliente cliente = entityManager.find(Cliente.class, id);
        entityManager.remove(cliente);
    }

//    @Transactional(readOnly = true)
//    public List<Cliente> buscarPorNome(String nome){
//        String jpql = "select c from Cliente c where c.nome like :nome";
//        TypedQuery<Cliente> query = entityManager.createQuery(jpql, Cliente.class);
//        query.setParameter(name: "nome", value: "%" + nome + "%");
//        return query.getResultList();
//    }
//
//    @Transactional
//    public List<Cliente> obterTodos(){
//        return entityManager.createQuery( qlString: "from Cliente", Cliente.class)
//            .getResultList();
//    }


}
