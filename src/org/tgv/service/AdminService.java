package org.tgv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tgv.Dao.AdminDao;

@Service
public class AdminService {
	
	@Autowired
	private AdminDao admindao;
}
