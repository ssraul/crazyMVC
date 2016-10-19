package crazy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import crazy.model.Client;

@Component
public class ClientDAO implements IClientDAO {
	@Autowired
	DataSource ds;

	@Override
	public Client getCliente(String email) {
		Client c = null;
		String consulta = "select * from cliente where email=?";

		try {
			Connection con = ds.getConnection();
			PreparedStatement query = con.prepareStatement(consulta);
			query.setString(1, email);
			ResultSet rs = query.executeQuery();
			if (rs.next()) {
				c = new Client();
				c.setName(rs.getString(rs.findColumn("nombre")));
				c.setSurname(rs.getString(rs.findColumn("apellido")));
				c.setEmail(rs.getString(rs.findColumn("email")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return c;
	}
	
	
	public List<Client> getClientList() {
		List<Client> listado=new ArrayList<Client>();
		Client c=null;
		String consulta = "select * from cliente";

		try {
			Connection con = ds.getConnection();
			PreparedStatement query = con.prepareStatement(consulta);			
			ResultSet rs = query.executeQuery();
			while (rs.next()) {
				c = new Client();
				c.setName(rs.getString(rs.findColumn("nombre")));
				c.setSurname(rs.getString(rs.findColumn("apellido")));
				c.setEmail(rs.getString(rs.findColumn("email")));
				listado.add(c);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listado;
	}
	
	public boolean addClient(String nombre, String apellido, String email){
		String consulta ="insert into cliente values( ? , ? , ? )";		
		try {
			Connection con = ds.getConnection();
			PreparedStatement ps = con.prepareStatement(consulta);
			ps.setString(1, nombre);
			ps.setString(2, apellido);
			ps.setString(3, email);
			ps.executeUpdate();
			ps.close();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}		
		
	}
	
	public boolean addClient(Client cliente){
		String consulta ="insert into cliente values( ? , ? , ? )";		
		try {
			Connection con = ds.getConnection();
			PreparedStatement ps = con.prepareStatement(consulta);
			ps.setString(1, cliente.getName());
			ps.setString(2, cliente.getSurname());
			ps.setString(3, cliente.getEmail());
			ps.executeUpdate();
			ps.close();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}		
		
	}
	
	
	
	public boolean deleteClient(String email){
		String consulta = "delete from cliente where email=?";

		try {
			Connection con = ds.getConnection();
			PreparedStatement query = con.prepareStatement(consulta);
			query.setString(1, email);
			query.executeUpdate(consulta);
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		
	}
	

}
