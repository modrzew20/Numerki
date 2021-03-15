package sample;

import com.sun.glass.ui.EventLoop;
import com.sun.javafx.binding.StringFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ChoiceWindow {
    public ChoiceBox <String> epsilon;
    public MenuButton option;
    public TextField iteriation;
    public ChoiceBox <String> function;
    public TextField to;
    public TextField from;
    public Button count;
    public TextField eps;
    public Label l1;
    public Label l2;
    public Label l3;
    public AnchorPane pane;
    boolean op=true;

    ObservableList list = FXCollections.observableArrayList();
    ObservableList listepsilon = FXCollections.observableArrayList();


    public void initialize() {
    fillList();
    fillsecondlist();
    iteriation.setVisible(false);
    eps.setVisible(false);
    epsilon.setVisible(false);
    l1.setVisible(false);
    l2.setVisible(false);
    l3.setVisible(false);


    }

    void fillsecondlist() {
        listepsilon.removeAll(listepsilon);
        String a="|xn-xn-1|<E";
        String b="|F(x)<E|";
        listepsilon.addAll(a,b);
        epsilon.getItems().addAll(listepsilon);
    }


    void fillList () {
        list.removeAll(list);
        String a="F(x)=x*x-2.0";
       // String b="F(x)=(2.0+4.0)";
        list.addAll(a);
        function.getItems().addAll(list);
    }


    public void byepsilon(ActionEvent actionEvent) {
        eps.setVisible(true);
        epsilon.setVisible(true);
        option.setVisible(false);
        l1.setVisible(true);
        l3.setVisible(true);
        op=true;

    }

    public void byiteration(ActionEvent actionEvent) {
        iteriation.setVisible(true);
        option.setVisible(false);
        l2.setVisible(true);
        op=false;
    }



    public static double dokladnosc;
    public double iteracje;
    public String opcjabledu;
    public static String funkcja;
    public static boolean wariant;


    public void countfunction(ActionEvent actionEvent) throws IOException {

        funkcja = function.getValue();

        if (op) {
            dokladnosc = Double.parseDouble(eps.getText());
            opcjabledu = epsilon.getValue();
            if (opcjabledu == "|xn-xn-1|<E") wariant = true;
            else wariant = false;
        } else {
             iteracje= Double.parseDouble(iteriation.getText());
        }

        Stage stage= new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setScene(new Scene(root, 800, 600));
        stage.show();



    }

    public void reload(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ChoiceWindow.fxml"));
        Parent root = fxmlLoader.load();
        Main.stage.getScene().setRoot(root);
    }
}
