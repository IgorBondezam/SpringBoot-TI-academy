package br.com.tiacademy.vendas.repository;

import br.com.tiacademy.vendas.core.crud.CrudRepository;
import br.com.tiacademy.vendas.domain.Item;
import liquibase.pro.packaged.L;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

    @Query("select i from Item i where i.id in (:ids)")
    List<Item> recuperarPorIds(@Param("ids") List<Long> ids);

    @Query(value = "select * from Item where id in (:ids)", nativeQuery = true)
    List<Item> recuperarPorIdsNativo(@Param("ids") List<Long> ids);

    List<Item> findByIdIn(List<Long> ids);

}
