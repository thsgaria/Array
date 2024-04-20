/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Banco {
    public static Connection conectar () throws SQLException {
         var jbdcUrl = "jdbc:mysql://localhost:3306/locadora";
            var jdbcUsuario = "root";
            var jdbcSenha = "admin";
            return DriverManager.getConnection(jbdcUrl, jdbcUsuario, jdbcSenha);
    }
    
}
