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
	
	public Planeta getPlanetaId(Long id_planeta)
	{
		Connection conexao = new ConnectionFactory().getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Planeta planeta = null;
		
		String sql = "select * from planeta where id_planeta = ? ";

		try{
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, id_planeta);
			rs = stmt.executeQuery();

			if(rs.next()){
				planeta = new Planeta();
				planeta.setId_planeta(rs.getLong("id_planeta"));
				planeta.setNome(rs.getString("nome"));
				planeta.setClima(rs.getString("clima"));
				planeta.setTerreno(rs.getString("terreno"));
				planeta.setQtd_aparicoes(rs.getInt("qtd_aparicoes"));
		
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


		return planeta;
	} // fim getPlaneta por id

	public Planeta getPlanetaNome(String nome)
	{
		Connection conexao = new ConnectionFactory().getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Planeta planeta = null;
		
		String sql = "select * from planeta where nome = ? ";

		try{
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, nome);
			rs = stmt.executeQuery();

			if(rs.next()){
				planeta = new Planeta();
				planeta.setId_planeta(rs.getLong("id_planeta"));
				planeta.setNome(rs.getString("nome"));
				planeta.setClima(rs.getString("clima"));
				planeta.setTerreno(rs.getString("terreno"));
				planeta.setQtd_aparicoes(rs.getInt("qtd_aparicoes"));
		
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


		return planeta;
	} // fim getPlaneta por nome

	
	public void inserePlaneta(Planeta planeta)
	{
		Connection conexao = new ConnectionFactory().getConnection();
		PreparedStatement stmt = null;
		
		String sql = "insert into planeta(id_planeta, nome, clima, terreno, qtd_aparicoes) " + 
					"values(?,?,?,?,?)";
		
		try{
			stmt = (PreparedStatement) conexao.prepareStatement(sql);
			stmt.setLong(1, planeta.getId_planeta());
			stmt.setString(2, planeta.getNome());
			stmt.setString(3, planeta.getClima());
			stmt.setString(4, planeta.getTerreno());
			stmt.setInt(5, planeta.getQtd_aparicoes());
						
			stmt.execute();
			
			
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
			}//fim insere planeta
}
	
	
	
	public void removeUsuario(Long id_planeta)
	{
		Connection conexao = new ConnectionFactory().getConnection();
		PreparedStatement stmt = null;
		
		String sql = "delete from planeta where id_planeta = ? ";
		
		try{
			stmt = (PreparedStatement)conexao.prepareStatement(sql);
			stmt.setLong(1, id_planeta);
			
			stmt.execute();			
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(conexao!=null){
					conexao.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				try{
					if(stmt!= null){
						stmt.close();
					}
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
	}// fim removePlaneta

}
