package ru.molokoin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DomainsFrame extends Stage{
    DomainsFrame(int id){
        ObservableList<Domain> obsPerson = FXCollections.observableArrayList(Base.getDomains(id));
        TableView<Domain> table = new TableView<>(obsPerson);
        
        //добавляем поле id
        TableColumn<Domain, Integer> idColumn = new TableColumn<>("id");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        table.getColumns().add(idColumn);

        //добавляем поле webname
        TableColumn<Domain, String> webnameColumn = new TableColumn<>("webname");
        webnameColumn.setCellValueFactory(new PropertyValueFactory<>("webname"));
        table.getColumns().add(webnameColumn);

        //добавляем поле domainname
        TableColumn<Domain, String> domainnameColumn = new TableColumn<>("domainname");
        domainnameColumn.setCellValueFactory(new PropertyValueFactory<>("domainname"));
        table.getColumns().add(domainnameColumn);

        //добавляем поле ip
        TableColumn<Domain, String> ipColumn = new TableColumn<>("ip");
        ipColumn.setCellValueFactory(new PropertyValueFactory<>("ip"));
        table.getColumns().add(ipColumn);

        //добавляем поле datereg
        TableColumn<Domain, String> dateregColumn = new TableColumn<>("datereg");
        dateregColumn.setCellValueFactory(new PropertyValueFactory<>("datereg"));
        table.getColumns().add(dateregColumn);

        //добавляем поле countryreg
        TableColumn<Domain, String> countryregColumn = new TableColumn<>("countryreg");
        countryregColumn.setCellValueFactory(new PropertyValueFactory<>("countryreg"));
        table.getColumns().add(countryregColumn);

        //добавляем поле id
        TableColumn<Domain, Integer> personidColumn = new TableColumn<>("personid");
        personidColumn.setCellValueFactory(new PropertyValueFactory<>("personid"));
        table.getColumns().add(personidColumn);
        
        GridPane root = new GridPane();
        root.getChildren().add(table);
        Scene scene = new Scene(root, 600, 600);
        this.setScene(scene);
        this.setTitle("FRAME:DOMAINS");
        this.show();
    }
    
}
