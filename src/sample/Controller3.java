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
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import sample.banco.Dao_Players;
import sample.banco.Players;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class Controller3 implements Initializable {

    @FXML
    private ProgressBar progress;

    @FXML
    private DatePicker born;

    @FXML
    private TextField city, contact, name1, name2, password1, password2;

    @FXML
    private Button back, enter;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException, SQLException {
        Button b = (Button) event.getSource();

        if (b.equals(back)) {
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

        } else if (b.equals(enter)) {

            boolean x = checkProfile();

            if (x) {
                Dao_Players d = new Dao_Players();

                String password = password1.getText();
                String name = name1.getText() + " " + name2.getText();
                String date = born.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                Players p = new Players(date, city.getText(), contact.getText(), Controller.id_steam, name, Controller.nick, password);
                d.modify(p);

                Controller.born = date;
                Controller.city = city.getText();
                Controller.contact = contact.getText();
                Controller.name = name;
                Controller.password1 = password;

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
            }
        }

    }

    @FXML
    public boolean checkProfile() {

        if (born.getValue() != null && !city.getText().equals("") && !contact.getText().equals("") && !Controller.id_steam.equals("") && !name1.getText().equals("") && !name2.getText().equals("") && !Controller.nick.equals("") && !password1.getText().equals("") && !password2.getText().equals("")) {

            if (password1.getText().equals(password2.getText())) {

                String name = name1.getText() + " " + name2.getText();
                String numbers = city.getText() + contact.getText() + name;
                char[] numbers1 = numbers.toCharArray();

                for (char x : numbers1) {
                    boolean y = Character.isDigit(x);
                    if (y) {

                        Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                        dialogoInfo.setTitle("Diálogo de informação");
                        dialogoInfo.setHeaderText("Observação!");
                        dialogoInfo.setContentText("Apenas a senha e o id da steam podem ter números.");
                        dialogoInfo.showAndWait();
                        return false;
                    }
                }
            } else {

                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                dialogoInfo.setTitle("Diálogo de informação");
                dialogoInfo.setHeaderText("Observação!");
                dialogoInfo.setContentText("As senhas não coincidem.");
                dialogoInfo.showAndWait();
                return false;
            }

        } else {

            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("Diálogo de informação");
            dialogoInfo.setHeaderText("Informações faltando!");
            dialogoInfo.setContentText("Para terminar o cadastro você deve preencher todos os campos.");
            dialogoInfo.showAndWait();
            return false;
        }

        return true;
    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void handleEnterEvent(KeyEvent keyEvent) {
        progress.setProgress(0.1);
    }
}
