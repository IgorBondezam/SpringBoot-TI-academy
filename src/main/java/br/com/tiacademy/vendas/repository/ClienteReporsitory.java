package br.com.tiacademy.vendas.repository;

import br.com.tiacademy.vendas.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteReporsitory extends JpaRepository<Cliente, Long> {
}
