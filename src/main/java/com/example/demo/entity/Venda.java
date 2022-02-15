package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Data

@SpringBootApplication
@EnableJpaAuditing

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Venda")
public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@CreatedDate
	@Column(name = "created_at")
//	@JsonFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@Column(name = "valor")
	private Double valor;
	
	@Column(name = "vendedor_id")
	private Integer vendedorId;
	
	@Column(name = "vendedor_nome")
	private String vendedorNome;
	
}
