package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int addUser(UserBean userBean) {

		return jdbcTemplate.update("insert into users(uname,uemail,upassword,uage)values(?,?,?,?)", userBean.getuName(),
				userBean.getuEmail(), userBean.getuPassword(), userBean.getuAge());
	}

	private final static class UserMapper implements RowMapper<UserBean> {

		public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {

			UserBean userBean = new UserBean();
			userBean.setuId(rs.getInt("uid"));
			userBean.setuName(rs.getString("uname"));
			userBean.setuEmail(rs.getString("uemail"));
			userBean.setuPassword(rs.getString("upassword"));
			userBean.setuAge(rs.getInt("uage"));

			return userBean;
		}

	}

	public List<UserBean> listofUser() {

		return jdbcTemplate.query("select * from users", new UserMapper());
	}

	public UserBean loginUser(UserBean userBean) {

		return jdbcTemplate.queryForObject("select * from users where uemail ='" + userBean.getuEmail()
				+ "' and upassword ='" + userBean.getuPassword() + "'", new UserMapper());
	}

}
