package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Venda;
import com.example.demo.repository.VendaRepository;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository vendaRepository;
	
	public Venda salvar(Venda venda) {
		return vendaRepository.save(venda);
	}
	
	public List<Object[]> getVendaByDate(String data)
	{
		return vendaRepository.findByCreatedAt(data);
	}
}
