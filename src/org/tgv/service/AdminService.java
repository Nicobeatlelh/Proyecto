package org.tgv.service;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tgv.Dao.AdminDao;
import org.tgv.pojo.Admin;

@Service
public class AdminService {
	
	@Autowired
	private AdminDao adminDao;

	public boolean save(Admin admin) {
		
		admin.setFechaCreacion(new Timestamp(new Date().getTime()));
		return adminDao.save(admin);
	}

	public List<Admin> buscarTodos() {
		
		return adminDao.buscarTodos();
	}

}
