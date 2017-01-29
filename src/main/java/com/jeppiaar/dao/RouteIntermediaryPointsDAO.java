package com.jeppiaar.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;


import com.jeppiaar.model.RouteIntermediaryPoints;
import com.jeppiaar.util.ConnectionUtil;

public class RouteIntermediaryPointsDAO {

	
	JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	
	public void save(RouteIntermediaryPoints routeIp)
	{
		String sql="insert into route_intermediary_points(IP_NAME,IP_CODE) values(?,?)";
		Object[] params={routeIp.getIpName(),routeIp.getIpCode()};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println(rows);
	}
	public void update(RouteIntermediaryPoints routeIp)
	{
		String sql="update route_intermediary_points set IP_CODE=? where IP_NAME=? ";
		Object[] params={routeIp.getIpCode(),routeIp.getIpName()};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println(rows);
	}
	public void delete(int id)
	{
		String sql="delete from route_intermediary_points where ID=?";
		int rows=jdbcTemplate.update(sql,id);
		System.out.println(rows);
	}
	public List<RouteIntermediaryPoints> list() {
		final String sql = "select ID,IP_NAME,IP_CODE from route_intermediary_points";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			RouteIntermediaryPoints routeIp=convert(rs);
			return routeIp;
		});

	}
 /**
  * Converts Object to ResultSet
  * @param rs
  * @return
  * @throws SQLException
  */
	static RouteIntermediaryPoints convert(final ResultSet rs) throws SQLException {
		RouteIntermediaryPoints routeIp = new RouteIntermediaryPoints();
		routeIp.setId(rs.getInt("ID"));
		routeIp.setIpName(rs.getString("IP_NAME"));
		routeIp.setIpCode(rs.getString("IP_CODE"));
		return routeIp;
	}
	
}
