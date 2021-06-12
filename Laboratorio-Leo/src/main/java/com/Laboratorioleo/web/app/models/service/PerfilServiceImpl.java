package com.Laboratorioleo.web.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Laboratorioleo.web.app.models.dao.IRolePerfil;
import com.Laboratorioleo.web.app.models.entity.Usuario;


@Service
public class PerfilServiceImpl implements IPerfilservice {
	
	@Autowired
	private IRolePerfil perfilDao;	
	
	
	@Override
	@Transactional(readOnly = true)
	public Page<Usuario> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return perfilDao.findAll(pageable);
	}


	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAllUsuarios() {
		// TODO Auto-generated method stub
		return (List<Usuario>) perfilDao.findAll();
	}


	@Override
	@Transactional
	public void save(Usuario usuario) {
		perfilDao.save(usuario);
		
	}


	@Override
	@Transactional(readOnly = true)
	public Usuario findOne(Long id) {
		// TODO Auto-generated method stub
		return perfilDao.findById(id).orElse(null);
	}


	@Override
	@Transactional
	public void delete(Long id) {
		
		perfilDao.deleteById(id);
		
	
		
	}

	@Transactional
	@Override
	public int activar(long idUsuario) {
		int rows = perfilDao.unlock(idUsuario);
		return rows;
	}

	@Transactional
	@Override
	public int bloquear(long idUsuario) {
		int rows = perfilDao.lock(idUsuario);
			return rows;
	}


	
	
}
