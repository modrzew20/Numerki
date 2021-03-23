package sample;

import A.*;
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

public class ChoiceWindow {

    //###########################################################################################
    public ChoiceBox <String> function;  // Wybor funkcji

    ObservableList list = FXCollections.observableArrayList();
    void fillList () {
        list.removeAll(list);
        String a="x*x+5*x-3";
        String b="2*cos(x+1)";
        String c="2^x-12";
        String d="2*cos((x*x+5*x+3)+1)";
        String e="2^(x*x+5*x+3)-12";
        list.addAll(a, b, c, d, e);
        function.getItems().addAll(list);
    }

    //###########################################################################################
    public MenuButton option; // Wybór sposobu

    public void byepsilon(ActionEvent actionEvent) {
        eps.setVisible(true);
        epsilon.setVisible(true);
        option.setVisible(false);
        l1.setVisible(true);
        l3.setVisible(true);
        whichOption=1;
    }

    public void byiteration(ActionEvent actionEvent) {
        iteriation.setVisible(true);
        option.setVisible(false);
        l2.setVisible(true);
        whichOption=2;
    }

    //###########################################################################################

    ObservableList listepsilon = FXCollections.observableArrayList();

    public ChoiceBox <String> epsilon;// ktora metoda stopu

    void fillsecondlist() {
        listepsilon.removeAll(listepsilon);
        String a="|xn-xn-1|<E";
        String b="|F(x)<E|";
        listepsilon.addAll(a,b);
        epsilon.getItems().addAll(listepsilon);
    }

    //###########################################################################################
    // pola od (kolejno) ilosci iteracji , przedział x2, dokładnosc
    public TextField iteriation;
    public TextField to;
    public TextField from;
    public TextField eps;

    //###########################################################################################
    // sposob
    //1 bledem
    //2 iteracjami
    //3 wariantem A bledu
    //4 wariantem B bledu
    byte whichOption=0;
    static byte which=0;

    //###########################################################################################
    public Button count;
    public Label l1;
    public Label l2;
    public Label l3;
    public AnchorPane pane;

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

    public static double dokladnosc;
    public static int iteracje;
    public static double  od , dok ;
    public String opcjabledu;
    public static Model m;


    void f () {
        String funkcj=function.getValue();
        if(funkcj=="x*x+5*x-3") m = new Wielomian();
        if(funkcj=="2*cos(x+1)") m = new Trygonometryczna();
        if(funkcj=="2^x-12") m = new Wykladnicza();
        if(funkcj=="2*cos((x*x+5*x+3)+1)") m = new Funkcja1();
        if(funkcj=="2^(x*x+5*x+3)-12") m = new Funkcja2();
    }

    public void countfunction(ActionEvent actionEvent) throws IOException {
        f();
        if (whichOption==1) {
            dokladnosc = Double.parseDouble(eps.getText());
            opcjabledu = epsilon.getValue();
            if (opcjabledu == "|xn-xn-1|<E") {
                whichOption=3;
            }
            else {
                whichOption=4;
            }
        } else {
             iteracje= Integer.parseInt(iteriation.getText());
        }

        od = Double.parseDouble(from.getText());
        dok = Double.parseDouble(to.getText());

        which=whichOption;
        if(whichOption==3 || whichOption==4) whichOption = 1;
        else whichOption = 2;

        Stage stage= new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void reload(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ChoiceWindow.fxml"));
        Parent root = fxmlLoader.load();
        Main.stage.getScene().setRoot(root);
    }
}
