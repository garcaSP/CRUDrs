package com.template.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

public class TimesDAO {

    private static final Logger logger = Logger.getLogger(TimesDAO.class.getName());

    public void cadastrarTime(TimesDTO time) {
        String sql = "INSERT INTO timesrs (sigla, nome, cidade, estadio, mascote) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = new Conexao().conectaBD();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, time.getSigla().toUpperCase());
            pstm.setString(2, time.getNome());
            pstm.setString(3, time.getCidade());
            pstm.setString(4, time.getEstadio());
            pstm.setString(5, time.getMascote());

            pstm.execute();

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao cadastrar", e);
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
                time.setId(rs.getInt("id"));
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
        String sql = "UPDATE timesrs SET sigla = ?, nome = ?, cidade = ?, estadio = ?, mascote = ? WHERE id = ?";

        try (Connection conn = new Conexao().conectaBD();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, time.getSigla().toUpperCase());
            pstm.setString(2, time.getNome());
            pstm.setString(3, time.getCidade());
            pstm.setString(4, time.getEstadio());
            pstm.setString(5, time.getMascote());
            pstm.setInt(6, time.getId());

            pstm.executeUpdate();

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao atualizar", e);
        }
    }

    public void deletarTime(int id) {
        String sql = "DELETE FROM timesrs WHERE id = ?";

        try (Connection conn = new Conexao().conectaBD();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setInt(1, id);
            pstm.executeUpdate();

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao deletar", e);
        }
    }
}