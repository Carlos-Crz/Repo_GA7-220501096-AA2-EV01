// src/main/java/com/supermarket/superinvent/SuperInvent.java
package com.supermarket.superinvent;

import com.supermarket.dao.ProveedDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class Superinvent {
    private static ProveedDAO ProveedDAO = new ProveedDAO();

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Elige una opcion: \n");
            System.out.println("1. Insertar un nuevo proveedor");
            System.out.println("2. Mostrar detalles de un proveedor ID");
            System.out.println("3. Actualizar un proveedor existente");
            System.out.println("4. Eliminar un Proveedor");
            System.out.println("5. Salir");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    // Insertar  Proveedor
                    System.out.print("Ingresa el nombre del proveedor: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingresa el nombre del encargado: ");
                    String encargado = scanner.nextLine();
                    System.out.print("Ingresa el telefono del proveedor: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Ingresa el correo electronico del proveedor: ");
                    String email = scanner.nextLine();       
                    try {
                        ProveedDAO.insertProveed(nombre, encargado, telefono, email);
                        System.out.println("Proveedor agregado correctamente. \n Presione Enter para continuar...");
                        scanner.nextLine();
                    } catch (SQLException e) {
                        System.err.println("Error al intentar agregar un proveedor: " + e.getMessage());
                    }
                    break;

                case 2:
                    // Ver Proveedor
                    System.out.print("Ingresa el ID del proveedor: ");
                    int id = scanner.nextInt();
                    try {
                        ProveedDAO.getProveedId(id);
                    } catch (SQLException e) {
                        System.err.println("Error al buscar el proveedor: " + e.getMessage());
                    }
                    break;
                    
                case 3:
                    // Actualizar Proveedor
                    System.out.print("Ingresa el ID del proveedor a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    
                    System.out.print("Ingrese el nuevo nombre del proveedor: ");
                    String upnombre = scanner.nextLine();
                    System.out.print("Ingrese el nuevo nombre del encargado: ");
                    String upencargado = scanner.nextLine();
                    System.out.print("Ingrese el nuevo telefono del proveedor: ");
                    String uptelefono = scanner.nextLine();
                    System.out.print("Ingrese el nuevo correo del proveedor: ");
                    String upemail = scanner.nextLine();                    
                  
                    try {
                        ProveedDAO.updateProveed(updateId, upnombre, upencargado, uptelefono, upemail);
                        System.out.println("Proveedor actualizado correctamente.  \n Presione Enter para continuar...");
                        scanner.nextLine();
                    } catch (SQLException e) {
                        System.err.println("Error al actualizar el proveedor: " + e.getMessage());
                    }
                    break;
                    
                case 4:
                    // Eliminar Proveedor
                    System.out.print("Ingrese el ID del proveedor a eliminar: ");
                    int deleteId = scanner.nextInt();
                    try {
                        ProveedDAO.deleteProveed(deleteId);
                        System.out.println("Proveedor eliminado correctamente.  \n Presione Enter para continuar...");
                        scanner.nextLine();
                    } catch (SQLException e) {
                        System.err.println("Error al eliminar el proveedor: " + e.getMessage());
                    }
                    break;
                    
                case 5:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción incorrecta. Inténtalo de nuevo..");
            }
        }
    }
}
