package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
   static final String JDBC_URL ="jdbc:derby:ConnectingCreatingJavaDB;create=true";

	Connection conn ;
	public DBConnection(){
		try{
			this.conn =DriverManager.getConnection(JDBC_URL);
			//conn.createStatement().execute("create table urls(urls varchar(20))");//Bu sat�r� yorum yapmadan yada tablo ad�n� de�i�tirmeden DBConnection �al��m�yor
			//conn.createStatement().execute("insert into urls values"+"('google')");//bu sat�r� yorum sat�r� yapmadan DBConnection �al��m�yor

			if(this.conn!= null){
				System.out.println("Ba�lant� Ger�ekle�ti");
			}
		}catch(SQLException e){
			System.out.println("Ba�lant� hatal�");

	}

	}
}