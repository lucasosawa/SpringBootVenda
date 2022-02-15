package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long>{
	
	@Query(value = "SELECT * FROM (select v.vendedor_nome, AVG(v.valor), count(v.vendedor_id) as contador from Venda AS v WHERE v.created_at like %:createdAt% group by v.vendedor_nome)", nativeQuery = true)
	List<Object[]> findByCreatedAt(@Param("createdAt") String createdAt);
	
}
