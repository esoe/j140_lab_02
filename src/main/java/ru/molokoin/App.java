package ru.molokoin;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Авторизация
 * Отображение данных из базы данных в таблице
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Text textWelcome = new Text("Welcome");
        textWelcome.setFont(new Font(20.0));
        Label labelName = new Label("User name: ");
        TextField fieldName = new TextField();
        Label labelPassword = new Label("Password: ");
        PasswordField fieldPass = new PasswordField();
        Button buttonSignin = new Button("sign in");

        /**
         * Обработка клика "sign in"
         * 1. считываются поля формы (fieldName, fieldPass), пишутся в объект User
         * 2. Подключение к базе данных
         * 3. Поиск в базе нужного пользователя
         * 4. В случае успеха, открываем PERSONS, или предлагаем пользователю повторить повытку авторизации
         */
        buttonSignin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //считываем данные пользователя
                User user = new User(fieldName.getText(), fieldPass.getText());
                /**
                 * проверяем наличие прав у пользователя
                 * окно открывается, если права пользователя подтверждены
                 */
                if (Base.checkAccess(user)){
                    textWelcome.setText("Доступ предоставлен...");
                    PersonsFrame personsFrame = new PersonsFrame();
                    personsFrame.setX(stage.getX() + 300);
				    personsFrame.setY(stage.getY() - 200);
                    personsFrame.show();
                } else {
                    textWelcome.setText("В доступе отказано...");
                }
			}
        });

        GridPane root = new GridPane();
        root.add(textWelcome, 0, 0);
        root.add(labelName, 0, 1);
        root.add(fieldName, 1, 1);
        root.add(labelPassword, 0, 2);
        root.add(fieldPass, 1, 2);
        root.add(buttonSignin,0,4,2,1);
        Scene scene = new Scene(root, 212, 102);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}