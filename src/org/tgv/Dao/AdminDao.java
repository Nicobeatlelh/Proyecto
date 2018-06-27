package org.tgv.Dao;

import java.util.List;

import org.tgv.pojo.Admin;

public interface AdminDao {

	public boolean save(Admin admin);
	public List<Admin> buscarTodos();
	public Admin buscarXId(int id);
	public List<Admin> buscarXNombre(String nombre);
	public boolean actualizar(Admin admin);
	public boolean borrar(int idAd);
	public int[] grabarTodos(List<Admin> admins);
}
