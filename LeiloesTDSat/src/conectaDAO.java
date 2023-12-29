
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class conectaDAO {
    
   private Connection conexao;

    public void conectar() {
        try {
            System.out.println("Iniciando conexao");
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/produtos?autoReconnect=true&useSSL=false", "root", "4584rtirRTIR");
            System.out.println("Sucesso De Conexão");
        } catch (SQLException e) {
            System.out.println("Falha nao conseguiu conectar");
        } catch (ClassNotFoundException e) {
            System.out.println("Falha nao conseguiu conectar a");
        }
    }

    public void desconectar() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
                System.out.println("Desconectado Com Sucesso");
            }

        } catch (SQLException e) {
            System.out.println("ERRO ao desconectar");
        }
    }

    public Connection getConnection() {
        return conexao;
    }
    
}
