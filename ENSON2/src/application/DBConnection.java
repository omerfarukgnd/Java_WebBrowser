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
			//conn.createStatement().execute("create table urls(urls varchar(20))");//Bu satýrý yorum yapmadan yada tablo adýný deðiþtirmeden DBConnection çalýþmýyor
			//conn.createStatement().execute("insert into urls values"+"('google')");//bu satýrý yorum satýrý yapmadan DBConnection çalýþmýyor

			if(this.conn!= null){
				System.out.println("Baðlantý Gerçekleþti");
			}
		}catch(SQLException e){
			System.out.println("Baðlantý hatalý");

	}

	}
}