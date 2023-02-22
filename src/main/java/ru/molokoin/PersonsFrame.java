package ru.molokoin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PersonsFrame extends Stage{
    PersonsFrame(){
        ObservableList<Person> obsPerson = FXCollections.observableArrayList(Base.getPersons());
        TableView<Person> table = new TableView<>(obsPerson);
        
        //добавляем поле id
        TableColumn<Person, Integer> idColumn = new TableColumn<>("id");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        table.getColumns().add(idColumn);

        //добавляем поле jobtitle
        TableColumn<Person, String> jobtitleColumn = new TableColumn<>("jobtitle");
        jobtitleColumn.setCellValueFactory(new PropertyValueFactory<>("jobtitle"));
        table.getColumns().add(jobtitleColumn);

        //добавляем поле firstnamelastname
        TableColumn<Person, String> firstnamelastnameColumn = new TableColumn<>("firstnamelastname");
        firstnamelastnameColumn.setCellValueFactory(new PropertyValueFactory<>("firstnamelastname"));
        table.getColumns().add(firstnamelastnameColumn);

        //добавляем поле phone
        TableColumn<Person, String> phoneColumn = new TableColumn<>("phone");
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        table.getColumns().add(phoneColumn);

        //добавляем поле email
        TableColumn<Person, String> emailColumn = new TableColumn<>("email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        table.getColumns().add(emailColumn);

        //добавляем поле domainsCount
        TableColumn<Person, Integer> domainsCountColumn = new TableColumn<>("domainsCount");
        domainsCountColumn.setCellValueFactory(new PropertyValueFactory<>("domainsCount"));
        table.getColumns().add(domainsCountColumn);

        //обработка клика : двойной клик по строке
        table.setOnMouseClicked(e -> {
            if(e.getClickCount()==2){
                System.out.println("Выбран пользователь: " + table.getSelectionModel().getSelectedItem().getFirstnamelastname());
                DomainsFrame df = new DomainsFrame(table.getSelectionModel().getSelectedItem().getId());
                //df.showAndWait();
                df.show();
            }
        });

        GridPane root = new GridPane();
        root.getChildren().add(table);
        Scene scene = new Scene(root, 600, 600);
        this.setScene(scene);
        this.setTitle("FRAME:PERSONS");
        this.show();
    }
}
