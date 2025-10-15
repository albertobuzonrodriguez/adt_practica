package com.adt;

public class TestHotelABR extends ClientePersistenciaABR {
    //Aquí tenemos nuestro main. Para poder usar los métodos de persistencia he hecho que nuestro test herede de ClientePersistenciaABR. 
    public static void main(String[] args) {
        // int idClienteNuevo = crearCliente("Alberto", "Buzón", "adaskh@gmail.com", "24723949v", "aaaa");
        // System.out.println(idClienteNuevo);

        // String campoCliente = leerCliente(idClienteNuevo, "nombre");
        // System.out.println(campoCliente);

        // boolean isUpdated = actualizarCliente(24, "nombre", "Antonio");
        // if (isUpdated){
        //     System.out.println("El cliente ha sido actualizado correctamente. ");
        // }

        boolean isDeleted = eliminarCliente(24);
        if (isDeleted){
            System.out.println("El cliente ha sido eliminado correctamente. ");
        }
    }
}
