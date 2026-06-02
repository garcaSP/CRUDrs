package com.template;


import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import java.util.ArrayList;

public class MainController {

    @FXML private TextField txtId;
    @FXML private TextField txtNome;
    @FXML private TextField txtCidade;
    @FXML private TextField txtEstadio;
    @FXML private TextField txtMascote;

    @FXML private TableView<TimesDTO> tblTimes;
    @FXML private TableColumn<TimesDTO, String> colSigla;
    @FXML private TableColumn<TimesDTO, String> colNome;
    @FXML private TableColumn<TimesDTO, String> colCidade;
    @FXML private TableColumn<TimesDTO, String> colEstadio;
    @FXML private TableColumn<TimesDTO, String> colMascote;

    @FXML
    private void initialize() {
        System.out.println("FXML loaded successfully!");

        colSigla.setCellValueFactory(new PropertyValueFactory<>("sigla"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colCidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
        colEstadio.setCellValueFactory(new PropertyValueFactory<>("estadio"));
        colMascote.setCellValueFactory(new PropertyValueFactory<>("mascote"));

        carregarTimes();
    }

    private void carregarTimes() {
        TimesDAO objTimesDAO = new TimesDAO();
        ArrayList<TimesDTO> listaTimes = objTimesDAO.listarTimes();
        tblTimes.setItems(FXCollections.observableArrayList(listaTimes));
    }

    @FXML
    private void carregarCampos() {
        TimesDTO objTimesDTO = tblTimes.getSelectionModel().getSelectedItem();

        if (objTimesDTO != null) {
            txtId.setText(objTimesDTO.getSigla());
            txtNome.setText(objTimesDTO.getNome());
            txtCidade.setText(objTimesDTO.getCidade());
            txtEstadio.setText(objTimesDTO.getEstadio());
            txtMascote.setText(objTimesDTO.getMascote());
        }
    }

    @FXML
    private void btnSalvarAction(ActionEvent event) {
        String sigla = txtId.getText();
        String nome = txtNome.getText();
        String cidade = txtCidade.getText();
        String estadio = txtEstadio.getText();
        String mascote = txtMascote.getText();

        TimesDTO objTimesDTO = new TimesDTO();
        objTimesDTO.setSigla(sigla);
        objTimesDTO.setNome(nome);
        objTimesDTO.setCidade(cidade);
        objTimesDTO.setEstadio(estadio);
        objTimesDTO.setMascote(mascote);

        TimesDAO objTimesDAO = new TimesDAO();
        objTimesDAO.cadastrarTime(objTimesDTO);

        btnLimparAction(event);
        carregarTimes();
    }

    @FXML
    private void btnAtualizarAction(ActionEvent event) {
        String sigla = txtId.getText();
        String nome = txtNome.getText();
        String cidade = txtCidade.getText();
        String estadio = txtEstadio.getText();
        String mascote = txtMascote.getText();

        TimesDTO objTimesDTO = new TimesDTO();
        objTimesDTO.setSigla(sigla);
        objTimesDTO.setNome(nome);
        objTimesDTO.setCidade(cidade);
        objTimesDTO.setEstadio(estadio);
        objTimesDTO.setMascote(mascote);

        TimesDAO objTimesDAO = new TimesDAO();
        objTimesDAO.alterarTime(objTimesDTO);
        btnLimparAction(event);
        carregarTimes();
    }

    @FXML
    private void btnDeletarAction(ActionEvent event) {
        String sigla = txtId.getText();
        TimesDTO objTimesDTO = new TimesDTO();
        objTimesDTO.setSigla(sigla);
        TimesDAO objTimesDAO = new TimesDAO();
        objTimesDAO.excluirTime(objTimesDTO);
        btnLimparAction(event);
        carregarTimes();
    }

    @FXML
    private void btnLimparAction(ActionEvent event) {
        txtId.clear();
        txtNome.clear();
        txtCidade.clear();
        txtEstadio.clear();
        txtMascote.clear();
    }
}