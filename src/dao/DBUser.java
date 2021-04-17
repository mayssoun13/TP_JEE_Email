package dao;

import java.sql.*;
import java.util.*;

import business.User;

public class DBUser {
	
	public static int insert(User user) {
		int res = 0;
		String requete = "insert into Users (email, prenom, nom) values (?, ?, ?)";
		try {
			PreparedStatement  ps = DBConnection.getConnection().prepareStatement(requete);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPrenom());
			ps.setString(3, user.getNom());
			res = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public static int delete(int id) {
		int res = 0;
		String requete = "delete from Users where userid=?";
		try {
			PreparedStatement  ps = DBConnection.getConnection().prepareStatement(requete);
			ps.setInt(1, id);
			res = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public static int update(User user, int id) {
		int res = 0;
		String requete = "update Users set email=?, prenom=?, nom=? where userId=?";
		try {
			PreparedStatement  ps = DBConnection.getConnection().prepareStatement(requete);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPrenom());
			ps.setString(3, user.getNom());
			ps.setInt(4, id);
			res = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public static List<User> getList() {
		List<User> list = new ArrayList<>();
		String requete = "select * from Users";
		try {
			ResultSet rs = DBConnection.getConnection().prepareStatement(requete).executeQuery();
			
			while(rs.next())
				list.add(new User(rs.getInt("userID"), rs.getString("email"), rs.getString("prenom"), rs.getString("nom")) );
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<User> chercher(String mot) {
		List<User> list = new ArrayList<>();
		for(User u : getList())
			if( (u.getEmail()+u.getNom()+u.getPrenom()).toLowerCase().contains(mot.toLowerCase()) )
				list.add(u);
		return list;
	}
	
	public static User get(int id) {
		User user = null ;
		String requete = "select * from Users where userId="+id;
		try {
			ResultSet rs = DBConnection.getConnection().createStatement().executeQuery(requete);
			
			if(rs.next())
				user = new User(rs.getInt("userID"), rs.getString("email"), rs.getString("prenom"), rs.getString("nom")) ;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}