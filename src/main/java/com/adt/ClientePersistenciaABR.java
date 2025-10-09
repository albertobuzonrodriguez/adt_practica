package com.adt;

import java.sql.*;

public class ClientePersistenciaABR {
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
        return campoReturn;
    }

    public static boolean actualizarCliente(int idCliente, String campo, String nuevoValor){
        //ACTUALIZA EL VALOR DE LA COLUMNA "CAMPO" DEL CLIENTE IDENTIFICADO POR idCliente. DEVUELVE TRUE SI SE HA LOGRADO ACTUALIZAR.
        boolean update = false;
        return update;
    }
    
    public static boolean eliminarCliente(int idCliente){
        //ELIMINA EL CLIENTE IDENTIFICADO POR idCliente. DEVUELVE TRUE SI SE HA LOGRADO ELIMINADO.
        boolean delete = false;
        return delete;
    }
}
