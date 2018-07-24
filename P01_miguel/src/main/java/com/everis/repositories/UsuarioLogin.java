package com.everis.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings("rawtypes")
public interface UsuarioLogin<K> extends JpaRepository<UsuarioLogin, Integer> {

	
}
