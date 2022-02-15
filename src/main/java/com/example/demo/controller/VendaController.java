package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Venda;
import com.example.demo.service.VendaService;

@RestController
@RequestMapping("/vendas")
public class VendaController {
	
	@Autowired
	private VendaService vendaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Venda salvar(@RequestBody Venda venda) {
		return vendaService.salvar(venda);
	}
	
	@GetMapping("/getData/{data}")
	public List<Object[]> getVendaByDate(@PathVariable("data") @RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String data){
		return vendaService.getVendaByDate(data);
	}
}
