package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.Service;


public class EmployeeService extends Service<ObservableList<String>>{
    @Override
    protected Task<ObservableList<String>> createTask(){
        return new Task<ObservableList<String>>(){
            @Override
                    protected ObservableList<String> call() throws Exception {
                String[] names = {
                        "Tim",
                        "Jan",
                        "Patryk",
                        "Agata"};

                ObservableList<String> employees = FXCollections.observableArrayList();
                for (int i = 0; i < 4; i++) {
                    employees.add(names[i]);
                    updateMessage("Added " + names[i] + " to the list");
                    updateProgress(i + 1, 4);
                    Thread.sleep(200);

                }
                return employees;
            }
        };
    }
}
