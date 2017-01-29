package com.jeppiaar.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.jeppiaar.model.Route;
import com.jeppiaar.util.ConnectionUtil;

public class RouteDAO {
	
JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	
     public void save(Route route)
     {
    	String sql="insert into seed_route(ROUTE_NAME,START_POINT,END_POINT) values(?,?,?,?)";
    	Object[] params={route.getRouteName(),route.getStartPoint(),route.getEndPoint()};
    	int rows=jdbcTemplate.update(sql,params);
    	System.out.println(rows);
     }
     public void update(Route route)
     {
    	String sql="update seed_route set ROUTE_NAME=? where ID=?";
    	Object[] params={route.getRouteName(),route.getId()};
    	int rows=jdbcTemplate.update(sql,params);
    	System.out.println(rows);
     }
     public void delete(int id)
     {
    	String sql="delete from seed_route where ID=?";
    	
    	int rows=jdbcTemplate.update(sql,id);
    	System.out.println(rows);
     }
 	public List<Route> list() {
		final String sql = "select ID,ROUTE_NAME,START_POINT,END_POINT from seed_route";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			Route route=convert(rs);
			return route;
		});

	}
 /**
  * Converts Object to ResultSet
  * @param rs
  * @return
  * @throws SQLException
  */
	static Route convert(final ResultSet rs) throws SQLException {
		Route route=new Route();
		route.setId(rs.getInt("ID"));
		route.setRouteName(rs.getString("ROUTE_NAME"));
		route.setStartPoint(rs.getString("START_POINT"));
		route.setEndPoint(rs.getString("END_POINT"));
		return route;
	}
}
