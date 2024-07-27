// src/main/java/com/supermarket/dao/SupplierDAO.java
package com.supermarket.dao;

import com.supermarket.db.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProveedDAO {
    
    // Agregar un Nuevo Proveedor
    public void insertProveed(String nombre, String encargado, String telefono, String email) throws SQLException {
        String query = "INSERT INTO proveedores (nombre, encargado, telefono, email) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nombre);
            stmt.setString(2, encargado);
            stmt.setString(3, telefono);
            stmt.setString(4, email);
            stmt.executeUpdate();
        }
    }

    // Buscar un Proveedor por su ID
    public void getProveedId(int id) throws SQLException {
        String query = "SELECT * FROM proveedores WHERE id_proveedor = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("nombre");
                String manager = rs.getString("encargado");
                String phone = rs.getString("telefono");
                String email = rs.getString("email");
                System.out.println("Provedor Encontrado: " + name + " - " + manager + " - " + phone + " - " + email);
            } else {
                System.out.println("Proveedor no encontrado.");
            }
        }
    }

    // Actualizar un Proveedor
    public void updateProveed(int id, String nombre, String encargado, String telefono, String email) throws SQLException {
        String query = "UPDATE proveedores SET nombre = ?, encargado = ?, telefono = ?, email = ? WHERE id_proveedor = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nombre);
            stmt.setString(2, encargado);
            stmt.setString(3, telefono);
            stmt.setString(4, email);
            stmt.setInt(5, id);
            stmt.executeUpdate();
        }
    }

    // Eliminar un Proveedor
    public void deleteProveed(int id) throws SQLException {
        String query = "DELETE FROM proveedores WHERE id_proveedor = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
