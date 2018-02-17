package sample;

import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;


public class Controller {

    @FXML
    private javafx.scene.control.ListView listView;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Label progressLabel;

    private Service<ObservableList<String>> service;
    public void initialize(){
        service = new EmployeeService();
        listView.itemsProperty().bind(service.valueProperty());
        progressLabel.textProperty().bind(service.messageProperty());
        progressBar.progressProperty().bind(service.progressProperty());

        progressBar.visibleProperty().bind(service.runningProperty());
        progressLabel.visibleProperty().bind(service.runningProperty());

    }

    @FXML
    public void buttonPressed(){
        // can press the button even if th listView is loaded without exception's
        if(service.getState() == Service.State.SUCCEEDED){
            service.reset();
            service.start();
         // if we load the listViewfor the first time
        }else if(service.getState() == Service.State.READY) {
            service.start();
        }
    }
}








