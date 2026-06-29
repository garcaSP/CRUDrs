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
    @FXML private Label txtInfo;

    @FXML private TableView<TimesDTO> tblTimes;
    @FXML private TableColumn<TimesDTO, Integer> colId;
    @FXML private TableColumn<TimesDTO, String> colSigla;
    @FXML private TableColumn<TimesDTO, String> colNome;
    @FXML private TableColumn<TimesDTO, String> colCidade;
    @FXML private TableColumn<TimesDTO, String> colEstadio;
    @FXML private TableColumn<TimesDTO, String> colMascote;

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

    private void setInfo(String mensagem, String cor) {
        txtInfo.setText(mensagem);
        txtInfo.setStyle("-fx-text-fill: " + cor + ";");
    }

    private boolean validar(TimesDTO time) {
        txtSigla.setStyle("");
        txtNome.setStyle("");
        boolean valido = true;

        if (time.getSigla().isBlank() || time.getSigla().length() > 3) {
            txtSigla.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            setInfo("Sigla inválida! Deve ter entre 1 e 3 letras.", "red");
            valido = false;
        }

        if (time.getNome().isBlank()) {
            txtNome.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            setInfo("Nome é obrigatório!", "red");
            valido = false;
        }

        return valido;
    }

    @FXML
    private void btnSalvarAction(ActionEvent event) {
        TimesDTO objTimesDTO = new TimesDTO();
        objTimesDTO.setSigla(txtSigla.getText());
        objTimesDTO.setNome(txtNome.getText());
        objTimesDTO.setCidade(txtCidade.getText());
        objTimesDTO.setEstadio(txtEstadio.getText());
        objTimesDTO.setMascote(txtMascote.getText());

        if (!validar(objTimesDTO)) return;

        new TimesDAO().cadastrarTime(objTimesDTO);
        setInfo("Time cadastrado com sucesso!", "green");
        btnLimparAction(event);
        carregarTimes();
    }

    @FXML
    private void btnAtualizarAction(ActionEvent event) {
        TimesDTO selecionado = tblTimes.getSelectionModel().getSelectedItem();
        if (selecionado == null) {
            setInfo("Selecione um time na tabela!", "red");
            return;
        }

        TimesDTO objTimesDTO = new TimesDTO();
        objTimesDTO.setId(selecionado.getId());
        objTimesDTO.setSigla(txtSigla.getText());
        objTimesDTO.setNome(txtNome.getText());
        objTimesDTO.setCidade(txtCidade.getText());
        objTimesDTO.setEstadio(txtEstadio.getText());
        objTimesDTO.setMascote(txtMascote.getText());

        if (!validar(objTimesDTO)) return;

        new TimesDAO().atualizarTime(objTimesDTO);
        setInfo("Time atualizado com sucesso!", "green");
        btnLimparAction(event);
        carregarTimes();
    }

    @FXML
    private void btnDeletarAction(ActionEvent event) {
        TimesDTO selecionado = tblTimes.getSelectionModel().getSelectedItem();
        if (selecionado == null) {
            setInfo("Selecione um time para deletar!", "red");
            return;
        }

        new TimesDAO().deletarTime(selecionado.getId());
        setInfo("Time deletado com sucesso!", "green");
        btnLimparAction(event);
        carregarTimes();
    }

    @FXML
    private void btnLimparAction(ActionEvent event) {
        txtId.clear();
        txtSigla.clear();
        txtSigla.setStyle("");
        txtNome.clear();
        txtNome.setStyle("");
        txtCidade.clear();
        txtEstadio.clear();
        txtMascote.clear();
        //btn limpar pode chamar funcao limpar (com tudo isso) e chamar o setInfo("") pra limpar a label info
    }
}