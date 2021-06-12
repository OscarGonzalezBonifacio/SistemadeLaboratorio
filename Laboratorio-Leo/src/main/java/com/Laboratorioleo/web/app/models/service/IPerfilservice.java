package com.Laboratorioleo.web.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.Laboratorioleo.web.app.models.entity.Usuario;



public interface IPerfilservice {

	
public List<Usuario> findAllUsuarios();	

public Page<Usuario> findAll(Pageable pageable);


public void save(Usuario usuario);

public Usuario findOne(Long id);


public void delete(Long id);

int activar(long idUsuario);

int bloquear(long idUsuario);

}
