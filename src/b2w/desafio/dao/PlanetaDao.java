package b2w.desafio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import b2w.desafio.connection.ConnectionFactory;
import b2w.desafio.model.Planeta;

public class PlanetaDao {
	
	public List<Planeta> getPlanetas()
	{
		Connection conexao = new ConnectionFactory().getConnection();
		List<Planeta> lista_planetas = new ArrayList<Planeta>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "select * from planeta ";

		try{
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();

			while(rs.next()){
				Planeta planeta = new Planeta();
				planeta.setId_planeta(rs.getLong("id_planeta"));
				planeta.setNome(rs.getString("nome"));
				planeta.setClima(rs.getString("clima"));
				planeta.setTerreno(rs.getString("terreno"));
				planeta.setQtd_aparicoes(rs.getInt("qtd_aparicoes"));
		
				lista_planetas.add(planeta);
			}

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				try{
					if(stmt!=null){
						stmt.close();
					}
				}catch(SQLException e){
					e.printStackTrace();
				}finally{
					try{
						if(conexao!=null){
							conexao.close();
						}
					}catch(SQLException e){
						e.printStackTrace();
					}
				}
			}
		}


		return (lista_planetas);
	} // fim getListaPlanetas
	

}
