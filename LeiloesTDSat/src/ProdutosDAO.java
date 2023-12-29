/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        
        
        try {
            conectaDAO DAO = new conectaDAO();
            DAO.conectar();

            String sql = "INSERT INTO produtos(nome , valor , status) VALUES(?,?,?)";
            PreparedStatement consulta = DAO.getConnection().prepareStatement(sql);
            consulta.setString(1, produto.getNome());
            consulta.setInt(2, produto.getValor());
            consulta.setString(3, produto.getStatus());

            consulta.execute();
            DAO.desconectar();
            System.out.println("Cadastro realizado com sucesso");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir registro no banco de dados");
        }
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
    ArrayList<ProdutosDTO> produtos = new ArrayList<>();

        try {
            conectaDAO DAO = new conectaDAO();
            DAO.conectar();

            String sql = "SELECT * FROM proditos";
            PreparedStatement consulta = DAO.getConnection().prepareStatement(sql);
            ResultSet resposta = consulta.executeQuery();

            while (resposta.next()) {
                ProdutosDTO P = new ProdutosDTO();
                P.setId(resposta.getInt("id"));
                P.setNome(resposta.getString("nome"));
                P.setValor(resposta.getInt("valor"));
                P.setStatus(resposta.getString("status"));
                produtos.add(P);
            }
            DAO.desconectar();

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar o registro no banco de dados.");
        }
        return produtos;
    }
    
    
    
        
}

