package b2w.desafio.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {

	//conexão MongoDB
		private static final String URL_MYSQL= "jdbc:mongo://";
		private static final String IP = "localhost:3306";
		private static final String NOME_BANCO = "fitrank";
		private static final String URL_DA_CONEXAO = URL_MYSQL + IP + "/" + NOME_BANCO;
		private static final String login = "root";
		private static final String senha = "1234";
	
	public Connection getConnection(){
				
		try{
			Class.forName("mongodb.jdbc.MongoDriver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		Connection conexao = null;
		
		try{
			conexao = (Connection)DriverManager.getConnection(URL_DA_CONEXAO , login , senha);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return conexao;
	}
	
	public static void main(String[] args) throws SQLException {
		Connection conexao = DriverManager.getConnection(URL_DA_CONEXAO , login , senha);
		System.out.println("Conectado!");
		conexao.close();
	}
	
}
