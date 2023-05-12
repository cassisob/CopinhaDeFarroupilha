package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import sample.banco.Dao_Players;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class Controller4 {

    @FXML
    private TableView<Players> personTable;
    @FXML
    private TableColumn<Players, String> nickColumn;
    @FXML
    private TableColumn<Players, String> steamColumn;
    @FXML
    private TableColumn<Players, String> nameColumn;
    @FXML
    private TableColumn<Players, String> cityColumn;
    @FXML
    private Button back;

    private final ObservableList<Players> playersData = FXCollections.observableArrayList();

    public String born, city, contact, id_steam, name, nick;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
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
        }
    }

    public Controller4() throws SQLException {

        Dao_Players d = new Dao_Players();
        List<String> search = d.searchall();
        nick = search.get(0);

        for (int i = 0; i < search.size() - 7; i = i + 1) {

            if (nick.equals(search.get(i))) {

                nick = search.get(i);
                city = search.get(i + 2);
                id_steam = search.get(i + 4);
                name = search.get(i + 5);
                playersData.add(new Players(nick, city, id_steam, name));
                nick = search.get(i + 7);

            }
        }

    }

    @FXML
    private void initialize() {
        personTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        nickColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNick()));
        steamColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSteam()));
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        cityColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCity()));

        personTable.setItems(playersData);
    }
}
