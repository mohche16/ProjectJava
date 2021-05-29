package main;

import java.sql.SQLException;

import sqlConnection.*;

public class MovieMain {

	public static void main(String[] args) throws SQLException {
		SqlMain sql = new SqlMain();
		SqlBean bean = new SqlBean(sql.connectToDB());
		
		System.out.println("Skriv en query som listar alla skådespelare som är med i filmen “Seven”");
		System.out.println(bean.getSevenCast());
		System.out.println("Skriv en query som listar alla filmer som fått en oscar för bästa film");
		System.out.println(bean.getOscarWinners());
		System.out.println("Skriv en query som listar alla filmer som skådespelaren Brad Pitt varit med i");
		System.out.println(bean.getbradMovies());
		System.out.println("Skriv en query som listar alla priser som Brad Pitt's filmer har fått.");
		System.out.println(bean.getbradmovieAwards());

	}

}
