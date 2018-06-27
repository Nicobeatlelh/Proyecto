package org.tgv.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.tgv.pojo.Admin;


@Component("adminDao")
public class AdminDaoImpl implements AdminDao {
	
	private NamedParameterJdbcTemplate jdbcTemplate;
	@Autowired
	private void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate((javax.sql.DataSource) dataSource);
	}

	/* (non-Javadoc)
	 * @see org.tgv.Dao.AdminDao#save(org.tgv.pojo.Admin)
	 */
	public boolean save(Admin admin) {
		// Podemos reemplazar las siguientes lineas de codigo con el Bean, si y solo si los
		// atributos de la clase son identicos a los nombres de la tabla
		/*MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("nombre", admin.getNombre());
		paramMap.addValue("cargo", admin.getCargo());
		paramMap.addValue("fechaCreacion", admin.getFechaCreacion());*/
		BeanPropertySqlParameterSource paramMap = new BeanPropertySqlParameterSource(admin);
		return jdbcTemplate.update("insert into Admin (nombre,cargo,fechaCreacion) values (:nombre,:cargo,:fechaCreacion)", 
				paramMap) == 1;
	}

	public List<Admin> buscarTodos() {
		return jdbcTemplate.query("Select * from Admin", new RowMapper<Admin>() {

			public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
				Admin admin = new Admin();
				admin.setIdAd(rs.getInt("idAd"));
				admin.setNombre(rs.getString("nombre"));
				admin.setCargo(rs.getString("cargo"));
				admin.setFechaCreacion(rs.getTimestamp("fechaCreacion"));
				return admin;
			}
		});
	}

	public Admin buscarXId(int id) {
		//return jdbcTemplate.query("Select * from Admin where idad = :idAd", new MapSqlParameterSource("idAd",id),new AdminRowMapper());
		return jdbcTemplate.queryForObject("Select * from Admin where idad = :idAd", new MapSqlParameterSource("idAd",id),new AdminRowMapper());
	}

	public List<Admin> buscarXNombre(String nombre) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("Select * from Admin where nombre like :nombre",new MapSqlParameterSource("nombre", "%" + nombre + "%"), new AdminRowMapper());
	}

	public boolean actualizar(Admin admin) {
		// BeanPropertySqlParameterSource, porque los campos de nuestra tabla son identicos al de nuestra clase
		return jdbcTemplate.update("Update admin set nombre:nombre, cargo:cargo, fechaCreacion:fechaCreacion where idAd=:idAd ", 
				new BeanPropertySqlParameterSource(admin)) == 1;
	}

	public boolean borrar(int idAd) {
		// MapSqlParameterSource porque solo enviamos un parametro
		return jdbcTemplate.update("delete from admin Where idAd=idAd", new MapSqlParameterSource("idAd",idAd)) == 1;
	}

	@Transactional
	public int[] grabarTodos(List<Admin> admins) {
		// Necesitamos pasar esta lista a un arreglo(Array), para esto usamos el metodo toArray()
		
		
		//String resultado = jdbcTemplate.query(sql, null);
		
		SqlParameterSource[] batchArgs = SqlParameterSourceUtils.createBatch(admins.toArray());
		return jdbcTemplate.batchUpdate("insert into Admin (idAd,nombre,cargo,fechaCreacion) values (:idAd,:nombre,:cargo,:fechaCreacion)", batchArgs);
	}

}
