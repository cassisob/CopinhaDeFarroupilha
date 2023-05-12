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
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public static String born, city, contact, id_steam, name, nick, password1;

    @FXML
    private TextField password, user;

    @FXML
    private Button account, enter, recover;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException, SQLException {

        Button b = (Button) event.getSource();

        if (b.equals(account)) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("sample1.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage1 = new Stage();
            stage1.setTitle("Copinha");
            Image image = new Image("sample/img/logo.png");
            stage1.getIcons().add(image);
            stage1.setScene(scene);
            stage1.show();

        } else if (b.equals(enter)) {

            Dao_Players d = new Dao_Players();

            String id = user.getText();
            Boolean x = d.searchId(id);
            System.out.println(id);
            System.out.println(x);

            if (x.equals(true)) {

                String pass = password.getText();
                Boolean y = d.searchId(pass);

                if (y.equals(true)) {

                    List<String> search = d.searchall();

                    for (int i = 0; i < search.size(); i++) {
                        if (search.get(i).contains(id)) {
                            nick = search.get(i);
                            born = search.get(i + 1);
                            city = search.get(i + 2);
                            contact = search.get(i + 3);
                            id_steam = search.get(i + 4);
                            name = search.get(i + 5);
                            password1 = search.get(i + 6);
                        }
                    }

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.close();

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("sample2.fxml"));
                    Parent root = loader.load();

                    Scene scene = new Scene(root);
                    Stage stage1 = new Stage();
                    stage1.setTitle("Copinha");
                    Image image = new Image("sample/img/logo.png");
                    stage1.getIcons().add(image);
                    stage1.setScene(scene);
                    stage1.show();

                } else {

                    Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                    dialogoInfo.setTitle("Diálogo de informação");
                    dialogoInfo.setHeaderText("Informações erradas!");
                    dialogoInfo.setContentText("Usúario ou senha errados.");
                    dialogoInfo.showAndWait();
                }

            } else {

                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                dialogoInfo.setTitle("Diálogo de informação");
                dialogoInfo.setHeaderText("Informações erradas!");
                dialogoInfo.setContentText("Usúario ou senha errados.");
                dialogoInfo.showAndWait();
            }


        } else if (b.equals(recover)) {

            TextInputDialog recoverstr = new TextInputDialog();
            recoverstr.setTitle("Recuperar");
            recoverstr.setHeaderText("Enviaremos um e-mail com as informações necessarias para fazer login");
            recoverstr.setContentText("Digite nick ou e-mail para recuperar:");
            recoverstr.showAndWait();

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
