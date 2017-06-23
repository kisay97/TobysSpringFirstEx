package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.UserDTO;
import util.ConnectionMaker;

public class UserDao {
	
	private ConnectionMaker connectionMaker;
	
	public UserDao(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}
	
	public void setConnectionMaker(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}
	
	public void add(UserDTO user) throws ClassNotFoundException, SQLException {
		Connection conn = connectionMaker.makeConnection();
		
		PreparedStatement ps = conn.prepareStatement("insert into users(id, name, pw) values(?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPw());
		
		ps.executeUpdate();
		
		ps.close();
		conn.close();
	}
	
	public UserDTO get(String id) throws ClassNotFoundException, SQLException{
		Connection conn = connectionMaker.makeConnection();
		
		PreparedStatement ps = conn.prepareStatement("select * from users where id = ?");
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		UserDTO user = new UserDTO();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPw(rs.getString("pw"));
		
		rs.close();
		ps.close();
		conn.close();
		
		return user;
	}
}
