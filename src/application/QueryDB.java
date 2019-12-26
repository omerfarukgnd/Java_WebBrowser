package application;
import java.sql.*;
public class QueryDB {
	static final String JDBC_URL ="jdbc:derby:ConnectingCreatingJavaDB;create=true";
	public static final String SQL_STATEMENT="select * from urls";
	public static void main(String[] args)throws SQLException{
		Connection connection =DriverManager.getConnection(JDBC_URL);
		Statement statement=connection.createStatement();
		ResultSet resultset=statement.executeQuery(SQL_STATEMENT);
		ResultSetMetaData resultSetMetaData=resultset.getMetaData();
		int columnCount = resultSetMetaData.getColumnCount();
		for(int x =1;x<=columnCount;x++)System.out.format("%20s", resultSetMetaData.getColumnName(x)+"|");
		while(resultset.next()) {
			System.out.println("");
			for(int x=1;x<=columnCount;x++)System.out.format("%20s", resultset.getString(x)+" |");

		}
		if(statement!=null)statement.close();
		if(connection!=null)connection.close();
		}
}
