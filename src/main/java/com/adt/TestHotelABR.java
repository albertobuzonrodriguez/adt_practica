package com.adt;

public class TestHotelABR extends ClientePersistenciaABR {
    public static void main(String[] args) {
        // int idClienteNuevo = crearCliente("Alberto", "Buzón", "adaskh@gmail.com", "24723949v", "aaaa");
        // System.out.println(idClienteNuevo);
        // String campoCliente = leerCliente(idClienteNuevo, "nombre");
        // System.out.println(campoCliente);
        // boolean isUpdated = actualizarCliente(17, "nombre", "Antonio");
        // if (isUpdated){
        //     System.out.println("El cliente ha sido actualizado correctamente. ");
        // }
        boolean isDeleted = eliminarCliente(17);
        if (isDeleted){
            System.out.println("El cliente ha sido actualizado correctamente. ");
        }
    }
}
