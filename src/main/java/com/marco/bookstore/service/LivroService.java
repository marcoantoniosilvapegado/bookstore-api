package com.marco.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marco.bookstore.domain.Categoria;
import com.marco.bookstore.domain.Livro;
import com.marco.bookstore.repositories.LivroRepository;
import com.marco.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repository;
	@Autowired
	private CategoriaService categoriaService;
	
	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> 
			new ObjectNotFoundException("Objeto não encontrado: " + id + ", Tipo : " + Livro.class.getName())
			);
	}

	public List<Livro> findAll(Integer id_cat) {
		this.categoriaService.findById(id_cat);
		return repository.findAllByCategoria(id_cat);
	}

	public Livro update(Integer id, Livro obj) {
		Livro newObj = this.findById(id);
		updateData(newObj, obj);
		return repository.save(newObj);
		
	}

	private void updateData(Livro newObj, Livro obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setNome_autor(obj.getNome_autor());
		newObj.setTexto(obj.getTexto());			
	}

	public Livro create(Integer id_cat, Livro obj) {
		obj.setId(null);
		Categoria cat = categoriaService.findById(id_cat);
		obj.setCategoria(cat);
		return this.repository.save(obj);		
	}

	public void delete(Integer id) {
		Livro obj = this.findById(id);
		repository.delete(obj);
	}
	
	
}
