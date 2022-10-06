package com.marco.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marco.bookstore.domain.Categoria;
import com.marco.bookstore.domain.Livro;
import com.marco.bookstore.repositories.CategoriaRepository;
import com.marco.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired 
	private CategoriaRepository categoriaRepository;
	@Autowired 
	private LivroRepository livroRepository;
	
	public void instanciaBaseDeDados() {
		
		Categoria cat1   = new Categoria(null, "Informática", "Livro de TI");
		Categoria cat2   = new Categoria(null, "Ficção Cientifica", "Ficção Cientifica");
		Categoria cat3   = new Categoria(null, "Biografias", "Livros de Biografias");
		
		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem Ipslum", cat1);
		Livro l2 = new Livro(null, "Engenharia de Software", "Louis V. Gerstner", "Lorem Ipslum", cat1);
		Livro l3 = new Livro(null, "The Time Machine", "H.G. Wells", "Lorem Ipslum", cat2);
		Livro l4 = new Livro(null, "The War of The Worlds", "H.G. Wells", "Lorem Ipslum", cat2);
		Livro l5 = new Livro(null, "I, Robot", "Isaac Asimov", "Lorem Ipslum", cat2);
		
		cat1.getLivros().addAll(Arrays.asList(l1,l2));
		cat2.getLivros().addAll(Arrays.asList(l3,l4,l5));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
		
		System.out.println("TESTEEEEEEEEE2"); 
	}

}
