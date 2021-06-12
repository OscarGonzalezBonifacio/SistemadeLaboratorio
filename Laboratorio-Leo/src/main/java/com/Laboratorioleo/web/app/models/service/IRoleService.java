package com.Laboratorioleo.web.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.Laboratorioleo.web.app.models.entity.Producto;
import com.Laboratorioleo.web.app.models.entity.Role;
import com.Laboratorioleo.web.app.models.entity.Usuario;



public interface IRoleService {
	

	public List<Role> findAll();
	
	public Page<Role> findAll(Pageable pageable);
	
//	public List<Usuario> findByNombre(Pageable pageRequest);
	
	//public List<Usuario> findByNombre(String term);
	
	//public Page<Usuario> findAll2(Pageable pageable);


	

}
