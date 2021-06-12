package com.Laboratorioleo.web.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Laboratorioleo.web.app.models.dao.IRoleDao;
import com.Laboratorioleo.web.app.models.dao.IRolePerfil;
import com.Laboratorioleo.web.app.models.entity.Role;
import com.Laboratorioleo.web.app.models.entity.Usuario;


@Service
public class RoleServiceImpl implements IRoleService{
	
	
	@Autowired
	private IRoleDao roleDao;
	
	@Autowired
	private IRolePerfil rolePerfil;
	
	

	@Override
	@Transactional(readOnly = true)
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return (List<Role>) roleDao.findAll();
	}

	
	@Override
	@Transactional(readOnly = true)
	public Page<Role> findAll(Pageable pageable) {
		return roleDao.findAll(pageable);
	}



	

	




}
