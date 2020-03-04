package lesson4.HW1.src.sample;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {
    private ObservableList<String> observableList;
    String[] frend = {"Петров", "Иванов", "Зимков", "Кудрин"};
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField inputFild;
    @FXML
    private Button sendMessage;
    @FXML
    private ListView<String> listOfCounterPoints = new ListView<>();
    ObservableList<String> fren = FXCollections.observableArrayList(frend);
    @FXML
    private ListView<String> chatFild = new ListView<>();
    @FXML
    void sendEnter(KeyEvent event) {
        if (event.getCode()== KeyCode.ENTER) {
            chatFild.getItems().add(sender()+" : "+inputFild.getText());
            inputFild.setText("");
        }
    }
   
    private String sender() {
        if (listOfCounterPoints.getSelectionModel().getSelectedItem()==null){
            return "Я";
        }
        return listOfCounterPoints.getSelectionModel().getSelectedItem();
    }

    @FXML
    void initialize() {
        listOfCounterPoints.setItems(fren);
        assert chatFild != null : "fx:id=\"chatFild\" was not injected: check your FXML file 'sample.fxml'.";
        assert inputFild != null : "fx:id=\"inputFild\" was not injected: check your FXML file 'sample.fxml'.";
        assert sendMessage != null : "fx:id=\"sendMessage\" was not injected: check your FXML file 'sample.fxml'.";
        assert listOfCounterPoints != null : "fx:id=\"listOfCounterPoints\" was not injected: check your FXML file 'sample.fxml'.";

    }

    public void sendButton(javafx.event.ActionEvent actionEvent) {
        chatFild.getItems().add(sender()+" : "+inputFild.getText());
        inputFild.setText("");
    }
}
