package com.aws.global.dao;

import java.util.Date;

import com.aws.global.common.base.BaseDAO;

public class TransactionDAO extends BaseDAO{
	
	public void addTransaction(int payment, String customer)
	{
		Date date = new Date();
		String sql = "INSERT INTO TRANSACTION (transaction_id, payment, customer, pay_date) VALUES (NULL, ?, ?, ?);";
		getJdbcTemplate().update(sql, new Object[] { payment, customer, date});
	}
	
	public int getLatestTransactionId()
	{
		String sql = "SELECT TRANSACTION_ID FROM TRANSACTION ORDER BY TRANSACTION_ID DESC LIMIT 1";
		int latestId = getJdbcTemplate().queryForInt(sql);
		return latestId;
	}
}
