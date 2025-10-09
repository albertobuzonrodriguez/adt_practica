package com.adt;

public class TestHotelABR extends ClientePersistenciaABR {
    public static void main(String[] args) {
        // int idClienteNuevo = crearCliente("Alberto", "Buzón", "adaskh@gmail.com", "24723949v", "aaaa");
        // System.out.println(idClienteNuevo);
        String campoCliente = leerCliente(15, "nombre");
        System.out.println(campoCliente);
    }
}
