package com.template.controller;

import com.template.model.TimesDTO;
import com.template.service.TimesService;
import com.template.util.DialogUtil;
import com.template.validator.ValidationResult;
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

    private final TimesService timesService = new TimesService();

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
        List<TimesDTO> listaTimes = timesService.listarTimes();
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

    private TimesDTO montarTimeDosCampos() {
        TimesDTO objTimesDTO = new TimesDTO();
        objTimesDTO.setSigla(txtSigla.getText());
        objTimesDTO.setNome(txtNome.getText());
        objTimesDTO.setCidade(txtCidade.getText());
        objTimesDTO.setEstadio(txtEstadio.getText());
        objTimesDTO.setMascote(txtMascote.getText());
        return objTimesDTO;
    }

    private boolean tratarResultadoValidacao(ValidationResult resultado) {
        DialogUtil.limparEstiloCampo(txtSigla);
        DialogUtil.limparEstiloCampo(txtNome);

        if (!resultado.isCampoValido("sigla")) {
            DialogUtil.marcarCampoInvalido(txtSigla);
        }
        if (!resultado.isCampoValido("nome")) {
            DialogUtil.marcarCampoInvalido(txtNome);
        }
        if (!resultado.isValido()) {
            DialogUtil.exibirErro(txtInfo, resultado.getMensagemErro());
        }

        return resultado.isValido();
    }

    @FXML
    private void btnSalvarAction(ActionEvent event) {
        TimesDTO objTimesDTO = montarTimeDosCampos();

        ValidationResult resultado = timesService.cadastrarTime(objTimesDTO);
        if (!tratarResultadoValidacao(resultado)) return;

        DialogUtil.exibirSucesso(txtInfo, "Time cadastrado com sucesso!");
        btnLimparAction(event);
        carregarTimes();
    }

    @FXML
    private void btnAtualizarAction(ActionEvent event) {
        TimesDTO selecionado = tblTimes.getSelectionModel().getSelectedItem();
        if (selecionado == null) {
            DialogUtil.exibirErro(txtInfo, "Selecione um time na tabela!");
            return;
        }

        TimesDTO objTimesDTO = montarTimeDosCampos();
        objTimesDTO.setId(selecionado.getId());

        ValidationResult resultado = timesService.atualizarTime(objTimesDTO);
        if (!tratarResultadoValidacao(resultado)) return;

        DialogUtil.exibirSucesso(txtInfo, "Time atualizado com sucesso!");
        btnLimparAction(event);
        carregarTimes();
    }

    @FXML
    private void btnDeletarAction(ActionEvent event) {
        TimesDTO selecionado = tblTimes.getSelectionModel().getSelectedItem();
        if (selecionado == null) {
            DialogUtil.exibirErro(txtInfo, "Selecione um time para deletar!");
            return;
        }

        timesService.deletarTime(selecionado.getId());
        DialogUtil.exibirSucesso(txtInfo, "Time deletado com sucesso!");
        btnLimparAction(event);
        carregarTimes();
    }

    @FXML
    private void btnLimparAction(ActionEvent event) {
        txtId.clear();
        txtSigla.clear();
        DialogUtil.limparEstiloCampo(txtSigla);
        txtNome.clear();
        DialogUtil.limparEstiloCampo(txtNome);
        txtCidade.clear();
        txtEstadio.clear();
        txtMascote.clear();
    }
}
