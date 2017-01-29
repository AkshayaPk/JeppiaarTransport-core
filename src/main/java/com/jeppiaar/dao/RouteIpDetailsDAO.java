package com.jeppiaar.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;


import com.jeppiaar.model.RouteDetails;
import com.jeppiaar.model.RouteIpDetails;
import com.jeppiaar.util.ConnectionUtil;

public class RouteIpDetailsDAO {

	
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	
	public void save(RouteIpDetails routeIpDetails)
	{
		String sql="insert into route_details(ROUTE_ID,IP_1,IP_2,IP_3,IP_4,IP_5,IP_6) values (?,?,?,?,?,?,?)";
		Object[] params={routeIpDetails.getRouteId().getId(),routeIpDetails.getIp1(),routeIpDetails.getIp2(),routeIpDetails.getIp3(),routeIpDetails.getIp4(),routeIpDetails.getIp5(),routeIpDetails.getIp6()};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println(rows);
	}
	public void updateIP1(RouteIpDetails routeIpDetails)
	{
		String sql="update route_details set IP_1=? where ROUTE_ID=?";
		Object[] params={routeIpDetails.getIp1(),routeIpDetails.getRouteId().getId()};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println(rows);
	}
	public void updateIP2(RouteIpDetails routeIpDetails)
	{
		String sql="update route_details set IP_2=? where ROUTE_ID=?";
		Object[] params={routeIpDetails.getIp2(),routeIpDetails.getRouteId().getId()};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println(rows);
	}
	public void updateIP3(RouteIpDetails routeIpDetails)
	{
		String sql="update route_details set IP_3=? where ROUTE_ID=?";
		Object[] params={routeIpDetails.getIp3(),routeIpDetails.getRouteId().getId()};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println(rows);
	}
	public void updateIP4(RouteIpDetails routeIpDetails)
	{
		String sql="update route_details set IP_4=? where ROUTE_ID=?";
		Object[] params={routeIpDetails.getIp4(),routeIpDetails.getRouteId().getId()};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println(rows);
	}
	public void updateIP5(RouteIpDetails routeIpDetails)
	{
		String sql="update route_details set IP_5=? where ROUTE_ID=?";
		Object[] params={routeIpDetails.getIp5(),routeIpDetails.getRouteId().getId()};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println(rows);
	}
	public void updateIP6(RouteIpDetails routeIpDetails)
	{
		String sql="update route_details set IP_6=? where ROUTE_ID=?";
		Object[] params={routeIpDetails.getIp6(),routeIpDetails.getRouteId().getId()};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println(rows);
	}
	public void delete(int id)
	{
		String sql="delete from route_details where ID=?";
		int rows=jdbcTemplate.update(sql,id);
		System.out.println(rows);
	}
 	public List<RouteIpDetails> list() {
		final String sql = "select ID,ROUTE_ID,IP_1,IP_2,IP_3,IP_4,IP_5,IP_6";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			RouteIpDetails routeIpDetails=convert(rs);
			return routeIpDetails;
		});

	}
 /**
  * Converts Object to ResultSet
  * @param rs
  * @return
  * @throws SQLException
  */
	static RouteIpDetails convert(final ResultSet rs) throws SQLException {
        RouteIpDetails routeIpDetails=new RouteIpDetails();
        routeIpDetails.setId(rs.getInt("ID"));
        RouteDetails routeDetails=new RouteDetails();
        routeDetails.setId(rs.getInt("ROUTE_ID"));
        routeIpDetails.setRouteId(routeDetails);
        routeIpDetails.setIp1(rs.getString("IP_1"));
        routeIpDetails.setIp1(rs.getString("IP_2"));
        routeIpDetails.setIp1(rs.getString("IP_3"));
        routeIpDetails.setIp1(rs.getString("IP_4"));
        routeIpDetails.setIp1(rs.getString("IP_5"));
        routeIpDetails.setIp1(rs.getString("IP_6"));
		return routeIpDetails;
	}
}
