package com.template;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

import model.Conexao;

public class TimesDAO {

    private static final Logger logger = Logger.getLogger(TimesDAO.class.getName());

    public void cadastrarTime(TimesDTO time) {
        String sql = "INSERT INTO timesrs (sigla, nome, cidade, estadio, mascote) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = new Conexao().conectaBD();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, time.getSigla());
            pstm.setString(2, time.getNome());
            pstm.setString(3, time.getCidade());
            pstm.setString(4, time.getEstadio());
            pstm.setString(5, time.getMascote());

            pstm.execute();
            System.out.println("Sucesso: Time cadastrado com êxito!");

        } catch (SQLException e) {

            logger.log(Level.SEVERE, "Erro ao listar", e);
        }
    }

    public List<TimesDTO> listarTimes() {
        String sql = "SELECT * FROM timesrs";
        List<TimesDTO> lista = new ArrayList<>();

        try (Connection conn = new Conexao().conectaBD();
             PreparedStatement pstm = conn.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {
                TimesDTO time = new TimesDTO();
                time.setSigla(rs.getString("sigla"));
                time.setNome(rs.getString("nome"));
                time.setCidade(rs.getString("cidade"));
                time.setEstadio(rs.getString("estadio"));
                time.setMascote(rs.getString("mascote"));

                lista.add(time);
            }

        } catch (SQLException e) {

            logger.log(Level.SEVERE, "Erro ao listar", e);
        }
        return lista;
    }

    public void atualizarTime(TimesDTO time) {
        String sql = "UPDATE timesrs SET nome = ?, cidade = ?, estadio = ?, mascote = ? WHERE sigla = ?";

        try (Connection conn = new Conexao().conectaBD();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, time.getNome());
            pstm.setString(2, time.getCidade());
            pstm.setString(3, time.getEstadio());
            pstm.setString(4, time.getMascote());
            pstm.setString(5, time.getSigla());

            pstm.executeUpdate();
            System.out.println("Sucesso: Dados do time atualizados!");

        } catch (SQLException e) {

            logger.log(Level.SEVERE, "Erro ao atualizar", e);
        }
    }

    public void deletarTime(String sigla) {
        String sql = "DELETE FROM timesrs WHERE sigla = ?";

        try (Connection conn = new Conexao().conectaBD();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, sigla);
            pstm.executeUpdate();
            System.out.println("Sucesso: Time removido do sistema!");

        } catch (SQLException e) {

            logger.log(Level.SEVERE, "Erro ao deletar", e);
        }
    }
}