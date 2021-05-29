package sqlConnection;

import java.sql.*;
import java.util.ArrayList;

public class SqlBean {
	private Connection con;
	
	public SqlBean(Connection con) throws SQLException {
		this.con = con;
		
	}
	
	public ArrayList<String> getSevenCast() throws SQLException
	{
		ArrayList<String> cast = new ArrayList<String>();
		String Query = "SELECT movies.title, actors.name FROM movies JOIN actors ON movies.movie_id = actors.movie_id WHERE movies.movie_id = 1";
		PreparedStatement state = this.con.prepareStatement(Query);
		ResultSet rs = state.executeQuery();
		
		while (rs.next()) {
			cast.add(rs.getString(2));
		}
		return cast;
	}
	
	public ArrayList<String> getOscarWinners() throws SQLException
	{
		ArrayList<String> cast = new ArrayList<String>();
		String Query = "SELECT movies.title FROM `movies` WHERE `haswon_oscar` = 1";
		PreparedStatement state = this.con.prepareStatement(Query);
		ResultSet rs = state.executeQuery();
		
		while (rs.next()) {
			cast.add(rs.getString(1));
		}
		return cast;
	}
	
	public ArrayList<String> getbradMovies() throws SQLException
	{
		ArrayList<String> cast = new ArrayList<String>();
		String Query = "SELECT movies.title, actors.name FROM movies JOIN actors ON movies.movie_id = actors.movie_id WHERE actors.name LIKE 'Brad Pitt'";
		PreparedStatement state = this.con.prepareStatement(Query);
		ResultSet rs = state.executeQuery();
		
		while (rs.next()) {
			cast.add(rs.getString(1));
		}
		return cast;
	}
	
	public ArrayList<String> getbradmovieAwards() throws SQLException
	{
		ArrayList<String> cast = new ArrayList<String>();
		String Query = "SELECT movies.awards, actors.name FROM movies JOIN actors ON movies.movie_id = actors.movie_id WHERE actors.name LIKE 'Brad Pitt'";
		PreparedStatement state = this.con.prepareStatement(Query);
		ResultSet rs = state.executeQuery();
		
		while (rs.next()) {
			cast.add(rs.getString(1));
		}
		return cast;
	}
	
	
	
}
