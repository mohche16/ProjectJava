package main;

import java.sql.SQLException;

import sqlConnection.*;

public class MovieMain {

	public static void main(String[] args) throws SQLException {
		SqlMain sql = new SqlMain();
		SqlBean bean = new SqlBean(sql.connectToDB());
		
		System.out.println("Skriv en query som listar alla sk�despelare som �r med i filmen �Seven�");
		System.out.println(bean.getSevenCast());
		System.out.println("Skriv en query som listar alla filmer som f�tt en oscar f�r b�sta film");
		System.out.println(bean.getOscarWinners());
		System.out.println("Skriv en query som listar alla filmer som sk�despelaren Brad Pitt varit med i");
		System.out.println(bean.getbradMovies());
		System.out.println("Skriv en query som listar alla priser som Brad Pitt's filmer har f�tt.");
		System.out.println(bean.getbradmovieAwards());

	}

}
