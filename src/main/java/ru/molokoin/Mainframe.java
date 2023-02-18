package ru.molokoin;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Mainframe extends Stage{
    Mainframe(){
        Text textWelcome = new Text("MAINFRAME");
        textWelcome.setFont(new Font(20.0));
        GridPane root = new GridPane();
        root.add(textWelcome, 0, 0);
        Scene scene = new Scene(root, 200, 600);
        this.setScene(scene);
        this.setTitle("MAINFRAME");
        this.show();
    }
}
