package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import sample.banco.Dao_Players;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller2 implements Initializable {

    @FXML
    private TextField born, city, contact, id_steam, name, nick;

    @FXML
    private Button back, delete, modify, players, teams;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {

        Dao_Players d = new Dao_Players();
        Button b = (Button) event.getSource();

        if (b.equals(back)) {
            backMainController(event);

        } else if (b.equals(delete)) {
            Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
            ButtonType yes = new ButtonType("Sim");
            ButtonType not = new ButtonType("Não", ButtonBar.ButtonData.CANCEL_CLOSE);
            dialogoExe.setTitle("Dialogo de confirmação");
            dialogoExe.setHeaderText("Essa é uma ação irreversivel!");
            dialogoExe.setContentText("Você tem certeza que deseja deletar sua conta?");
            dialogoExe.getButtonTypes().setAll(yes, not);
            dialogoExe.showAndWait().ifPresent(y -> {
                if (y == yes) {

                    try {
                        d.remove(Controller.nick);
                        backMainController(event);
                    } catch (SQLException | IOException throwables) {
                        throwables.printStackTrace();
                    }

                }
            });

        } else if (b.equals(modify)) {

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("sample3.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage1 = new Stage();
            stage1.setTitle("Copinha");
            Image image = new Image("sample/img/logo.png");
            stage1.getIcons().add(image);
            stage1.setScene(scene);
            stage1.show();

        } else if (b.equals(players)) {

            try {
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.close();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("Sample5.fxml"));
                Parent root = loader.load();

                Scene scene = new Scene(root);
                Stage stage1 = new Stage();
                stage1.setTitle("Copinha");
                Image image = new Image("sample/img/logo.png");
                stage1.getIcons().add(image);
                stage1.setScene(scene);
                stage1.show();

            } catch (IOException e) {
                System.err.println("Erro ao abrir a janela");
            }
        }

    }

    @FXML
    public void backMainController(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        Stage stage1 = new Stage();
        stage1.setTitle("Copinha");
        Image image = new Image("sample/img/logo.png");
        stage1.getIcons().add(image);
        stage1.setScene(scene);
        stage1.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        born.setText("Nascimento: " + Controller.born);
        city.setText("Cidade: " + Controller.city);
        contact.setText("Contato: " + Controller.contact);
        id_steam.setText("Id_steam: " + Controller.id_steam);
        name.setText("Nome: " + Controller.name);
        nick.setText("Nick: " + Controller.nick);

    }
}
