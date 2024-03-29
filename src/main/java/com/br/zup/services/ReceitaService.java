package com.br.zup.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.zup.exception.ReceitaNaoEncontradaException;
import com.br.zup.modells.Receita;
import com.br.zup.repositories.ReceitaRepository;

@Service
public class ReceitaService {
	@Autowired
	private ReceitaRepository receitaRepository;

	public Receita criarReceita(Receita receita) {
		return receitaRepository.save(receita);
	}

	public Iterable<Receita> verReceita() {
		return receitaRepository.findAll();
	}

	public Receita verReceitaPorId(int id) {
		return receitaRepository.findById(id).get();
	}

	public void atualizarReceita(int id, Receita receita) {
		try {
			receita.setId(id);
			receitaRepository.save(receita);
		} 
		catch (Exception e) {
			throw new ReceitaNaoEncontradaException("Receita não encontrada");
		}

	}
	public void deletarReceita(int id) {
		try {
			receitaRepository.deleteById(id);
		}
		catch (Exception e) {
			throw new ReceitaNaoEncontradaException("Receita não encontrada");
		}
		
	}
}





