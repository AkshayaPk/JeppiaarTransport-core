package com.jeppiaar.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.jeppiaar.model.Route;
import com.jeppiaar.model.RouteDetails;
import com.jeppiaar.util.ConnectionUtil;

public class RouteDetailsDAO {

	JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	
	public void save(RouteDetails routeDetails)
	{
		String sql="insert into seed_route_details(ROUTE_ID,ROUTE_BUS_NO,DEPARTURE_DATE,DEPARTURE_TIME) values(?,?,?,?,?)";
		Object[] params={routeDetails.getRouteId().getId(),routeDetails.getBusNo(),routeDetails.getDepartureDate(),routeDetails.getDepartureTime()};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println(rows);
	}
	public void update(RouteDetails routeDetails)
	{
		String sql="update seed_route_details set ROUTE_BUS_NO=? where ROUTE_ID=?";
		Object[] params={routeDetails.getBusNo(),routeDetails.getRouteId().getId()};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println(rows);
	}
	public void delete(int id)
	{
		String sql="delete from seed_route_details where ID=?";
		
		int rows=jdbcTemplate.update(sql,id);
		System.out.println(rows);
	}
	public List<RouteDetails> list() {
		final String sql = "select ID,ROUTE_ID,ROUTE_BUS_NO,DEPARTURE_DATE,DEPARTURE_TIME from seed_route_details";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			RouteDetails routeDetails=convert(rs);
			return routeDetails;
		});

	}
 /**
  * Converts Object to ResultSet
  * @param rs
  * @return
  * @throws SQLException
  */
	static RouteDetails convert(final ResultSet rs) throws SQLException {
		RouteDetails routeDetails=new RouteDetails();
		routeDetails.setId(rs.getInt("ID"));
		Route route=new Route();
		route.setId(rs.getInt("ROUTE_ID"));
		routeDetails.setRouteId(route);
		routeDetails.setBusNo(rs.getInt("ROUTE_BUS_NO"));
		routeDetails.setDepartureDate(rs.getDate("DEPARTURE_DATE").toLocalDate());
		routeDetails.setDepartureTime(rs.getTime("DEPARTURE_TIME").toLocalTime());
		return routeDetails;
	}
	
}
