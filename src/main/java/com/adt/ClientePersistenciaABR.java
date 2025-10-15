package com.adt;

import java.sql.*;

public class ClientePersistenciaABR {
    //En esta clase tenemos desarrollados los métodos que usaremos con los clientes de la base de datos.
    
    public static int crearCliente(String nombre, String apellidos, String email, String dni, String clave){
        //DEVUELVE EL ID DEL NUEVO CLIENTE
        int idReturn = 0;
        try {
			Connection con = GestorConexiones.getMySQL_Connection("hotel");
            String query = "INSERT INTO clienteabr (nombre, apellidos, email, dni, clave) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, nombre);    // El primer ?
            pstmt.setString(2, apellidos); // El segundo ?
            pstmt.setString(3, email);     // El tercer ?
            pstmt.setString(4, dni);       // El cuarto ?
            pstmt.setString(5, clave);     // El quinto ?
			
            int filas = pstmt.executeUpdate();

			if (filas > 0) {
				System.out.println("Cliente insertado correctamente.");
			} else {
				System.out.println("No se insertó ningún registro.");
			}

            String query2 = "select max(id) from clienteabr";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query2);
            //RECORREMOS RESULTSET PARA DARLE VALOR A NUESTRO RETURN
            if (rs.next()) {
                idReturn = rs.getInt(1); 
            }

            rs.close();
            st.close();
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println("Error al conectar a la Base de Datos: " + e.getMessage());
		}
        return idReturn;
    }

    public static String leerCliente(int idCliente, String campo){
        //DEVUELVE EL VALOR DE LA COLUMNA "CAMPO" DEL CLIENTE IDENTIFICADO POR IDCLIENTE
        String campoReturn = "";
        try {
		    Connection con = GestorConexiones.getMySQL_Connection("hotel");
			Statement st = con.createStatement();
			String query = "SELECT " + campo + " from clienteabr where id = "+idCliente;
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
				campoReturn = rs.getString(campo);	
			}
			
			rs.close();
			st.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println("Error al conectar a la Base de Datos: " + e.getMessage());
		}
        return campoReturn;
    }

    public static boolean actualizarCliente(int idCliente, String campo, String nuevoValor){
        //ACTUALIZA EL VALOR DE LA COLUMNA "CAMPO" DEL CLIENTE IDENTIFICADO POR idCliente. DEVUELVE TRUE SI SE HA LOGRADO ACTUALIZAR.
        boolean update = false;
        try {
		    Connection con = GestorConexiones.getMySQL_Connection("hotel");
			Statement st = con.createStatement();
			String query = "UPDATE clienteabr SET " + campo + " = ? WHERE id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, nuevoValor);
			preparedStatement.setInt(2, idCliente);
			

			int filasActualizadas = preparedStatement.executeUpdate();

			if (filasActualizadas > 0) {
                update = true;
			} else {
                update = false;
			}

            preparedStatement.close();
			st.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println("Error al conectar a la Base de Datos: " + e.getMessage());
		}
        return update;
    }
    
    public static boolean eliminarCliente(int idCliente){
        //ELIMINA EL CLIENTE IDENTIFICADO POR idCliente. DEVUELVE TRUE SI SE HA LOGRADO ELIMINADO.
        boolean delete = false;
        try {
		    Connection con = GestorConexiones.getMySQL_Connection("hotel");
			Statement st = con.createStatement();
			String query = "delete from clienteabr WHERE id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, idCliente);
			
			int filasActualizadas = preparedStatement.executeUpdate();

			if (filasActualizadas > 0) {
                delete = true;
			} else {
                delete = false;
			}

            preparedStatement.close();
			st.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println("Error al conectar a la Base de Datos: " + e.getMessage());
		}
        return delete;
    }
}
