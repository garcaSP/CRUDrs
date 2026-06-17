package com.template;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import java.util.List;
import javafx.scene.control.Label;

public class MainController {

    @FXML private TextField txtId;
    @FXML private TextField txtSigla;
    @FXML private TextField txtNome;
    @FXML private TextField txtCidade;
    @FXML private TextField txtEstadio;
    @FXML private TextField txtMascote;

    @FXML private TableView<TimesDTO> tblTimes;
    @FXML private TableColumn<TimesDTO, Integer> colId;
    @FXML private TableColumn<TimesDTO, String> colSigla;
    @FXML private TableColumn<TimesDTO, String> colNome;
    @FXML private TableColumn<TimesDTO, String> colCidade;
    @FXML private TableColumn<TimesDTO, String> colEstadio;
    @FXML private TableColumn<TimesDTO, String> colMascote;

    @FXML private Label txtInfo;

    private void mostrarInfo(String mensagem) {
        txtInfo.setText(mensagem);
        txtInfo.setStyle("-fx-text-fill: " + "green" + ";");
    }

    @FXML
    private void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colSigla.setCellValueFactory(new PropertyValueFactory<>("sigla"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colCidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
        colEstadio.setCellValueFactory(new PropertyValueFactory<>("estadio"));
        colMascote.setCellValueFactory(new PropertyValueFactory<>("mascote"));

        carregarTimes();
    }

    private void carregarTimes() {
        TimesDAO objTimesDAO = new TimesDAO();
        List<TimesDTO> listaTimes = objTimesDAO.listarTimes();
        tblTimes.setItems(FXCollections.observableArrayList(listaTimes));
    }

    @FXML
    private void carregarCampos() {
        TimesDTO objTimesDTO = tblTimes.getSelectionModel().getSelectedItem();

        if (objTimesDTO != null) {
            txtId.setText(String.valueOf(objTimesDTO.getId()));
            txtSigla.setText(objTimesDTO.getSigla());
            txtNome.setText(objTimesDTO.getNome());
            txtCidade.setText(objTimesDTO.getCidade());
            txtEstadio.setText(objTimesDTO.getEstadio());
            txtMascote.setText(objTimesDTO.getMascote());
        }
    }

    @FXML
    private void btnSalvarAction(ActionEvent event) {
        TimesDTO objTimesDTO = new TimesDTO();
        objTimesDTO.setSigla(txtSigla.getText());
        objTimesDTO.setNome(txtNome.getText());
        objTimesDTO.setCidade(txtCidade.getText());
        objTimesDTO.setEstadio(txtEstadio.getText());
        objTimesDTO.setMascote(txtMascote.getText());

        TimesDAO objTimesDAO = new TimesDAO();

        mostrarValidacao(objTimesDTO);
        objTimesDAO.cadastrarTime(objTimesDTO);

        btnLimparAction(event);
        carregarTimes();
    }

    @FXML
    private void btnAtualizarAction(ActionEvent event) {

        TimesDTO selecionado = tblTimes.getSelectionModel().getSelectedItem();
        if (selecionado == null) return;

        TimesDTO objTimesDTO = new TimesDTO();
        objTimesDTO.setId(selecionado.getId());
        objTimesDTO.setSigla(txtSigla.getText());
        objTimesDTO.setNome(txtNome.getText());
        objTimesDTO.setCidade(txtCidade.getText());
        objTimesDTO.setEstadio(txtEstadio.getText());
        objTimesDTO.setMascote(txtMascote.getText());
        mostrarValidacao(selecionado);

        TimesDAO objTimesDAO = new TimesDAO();
        objTimesDAO.atualizarTime(selecionado);

        btnLimparAction(event);
        carregarTimes();
    }

    @FXML
    private void btnDeletarAction(ActionEvent event) {
        TimesDTO selecionado = tblTimes.getSelectionModel().getSelectedItem();
        if (selecionado == null) return;

        TimesDAO objTimesDAO = new TimesDAO();
        objTimesDAO.deletarTime(selecionado.getId());

        btnLimparAction(event);
        carregarTimes();
    }

    @FXML
    private void btnLimparAction(ActionEvent event) {
        txtId.clear();
        txtSigla.clear();
        txtNome.clear();
        txtCidade.clear();
        txtEstadio.clear();
        txtMascote.clear();
    }

    private void mostrarValidacao(TimesDTO time) {
        if (time.getSigla().isEmpty()) mostrarInfo("Sigla é obrigatória!");
        if (time.getSigla().length() > 3) mostrarInfo("Sigla deve ter no máximo 3 letras!");
    }
}