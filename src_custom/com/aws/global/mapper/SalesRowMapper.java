package com.aws.global.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;

import com.aws.global.classes.Sales;

public class SalesRowMapper implements RowMapper<Sales>{

	@Autowired
	@Qualifier("sales")
	private Sales sales;
	
	@Override
	public Sales mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		if (rs.getRow() == 0) return null;
		sales = new Sales();
		sales.setDineType(rs.getBoolean("dine_type"));
		sales.setPizzaName(rs.getString("pizza_name"));
		sales.setPizzaPrice(rs.getInt("pizza_price"));
		sales.setQuantity(rs.getInt("quantity"));
		sales.setTotalPrice(rs.getInt("price"));
		sales.setCustomerName(rs.getString("customer"));
		sales.setPayment(rs.getInt("payment"));
		return sales;
	}
	
}
