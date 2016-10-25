package crazy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import crazy.model.Order;

@Component
public class OrderDAO implements IOrderDAO {
	
	@Autowired
	DataSource ds;
	
	SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
	
	
	public boolean addOrder(String nombre, String email){
		String consulta ="insert into pedido values( ? , ? , ?)";		
		try {
			Connection con = ds.getConnection();
			PreparedStatement ps = con.prepareStatement(consulta);
			ps.setString(1, nombre);
			ps.setString(2, email);
			ps.setDate(3, (java.sql.Date) new Date());
			ps.executeUpdate();
			ps.close();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}		
		
	}
	
	public List<Order> listOrders(String email){
		List<Order> listadoPedidos=new ArrayList<Order>();
		Order c=null;
		String consulta = "select * from pedido where email ='"+email+"'";

		try {
			Connection con = ds.getConnection();
			PreparedStatement query = con.prepareStatement(consulta);			
			ResultSet rs = query.executeQuery();
			while (rs.next()) {
				c = new Order();
				c.setId(rs.getLong("idpedido"));
				c.setName(rs.getString("nombre"));
				c.setEmail(rs.getString("email"));
				//c.setFecha(rs.getTime("fecha"));
				listadoPedidos.add(c);			
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listadoPedidos;
	
		
		
	}

}
