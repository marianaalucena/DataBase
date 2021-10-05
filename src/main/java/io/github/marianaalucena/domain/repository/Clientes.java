package io.github.marianaalucena.domain.repository;

import io.github.marianaalucena.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface Clientes extends JpaRepository<Cliente, Integer> {

        //select c from Cliente c where c.nome like :nome
        List<Cliente> findByNomeLike(String nome);

        //hql
        @Query(value = " select c from Cliente c where c.nome like :nome")
        List<Cliente> encontrarPorNome(@Param("nome") String nome);

        //sql nativo
        @Query(value = " select * from Cliente c where c.nome like '%:nome%' ", nativeQuery = true)
        List<Cliente> encontrarPorNomeSql(@Param("nome") String nome);

        void deleteByNome(String nome);

        @Query( " delete from Cliente c where c.nome =:nome ")
        @Modifying
        void deleteByNomeQuery(String nome);

        List<Cliente> findByNomeOrIdOrderById(String nome, Integer id);

        Cliente findOneByNome(String nome);

        boolean existsByNome(String nome);

        @Query(value = " select c from Cliente c left join fetch c.pedidos where c.id =:id ")
        Cliente findClienteFetchPedidos(@Param("id") Integer id);

}
