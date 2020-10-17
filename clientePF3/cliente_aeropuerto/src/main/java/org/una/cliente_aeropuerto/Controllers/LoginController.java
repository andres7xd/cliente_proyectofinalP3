/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.cliente_aeropuerto.Controllers;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.una.cliente_aeropuerto.App;
import org.una.cliente_aeropuerto.DTO.AuthenticationRequest;
import org.una.cliente_aeropuerto.Service.UsuarioService;

/**
 * FXML Controller class
 *
 * @author Andres
 */
public class LoginController implements Initializable {

    @FXML
    private Button btnIniciar;
    @FXML
    private TextField txtCedula;
    @FXML
    private PasswordField txtfPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Ingresar(ActionEvent event)throws IOException, InterruptedException, ExecutionException {
        try {
        
            AuthenticationRequest aure = new AuthenticationRequest(txtCedula.getText(),txtfPassword.getText());
        UsuarioService.getInstance().Login(aure);
        
        Parent root = FXMLLoader.load(App.class.getResource("secundary.fxml"));
        Scene creacionDocs = new Scene(root);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(creacionDocs);
        window.show();
            
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "", ButtonType.OK);
                alert.setTitle("Mensaje");
                alert.setHeaderText("Usuario no autenticado.");
                alert.show();
        }
    }
    
}
