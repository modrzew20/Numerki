package sample;

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
        String a="F(x)=x*x-2.0";
        String b="F(x)=((x + 1.0) * x - 2.0) * x - 1.0";
        String c="F(x)=sin(x) - cos(x + 1.0)";
        String d="F(x)=exp(x) - 4.0 * x";
        String e="F(x)=sin(exp(-x*x)) - 0.5";
        list.addAll(a,b,c,d,e);
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

    public static byte funkcja;
    public static double dokladnosc;
    public static int iteracje;
    public static double  od , dok ;
    public String opcjabledu;


    void f () {
        String funkcj=function.getValue();
        if(funkcj=="F(x)=x*x-2.0") funkcja=1;



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
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
    }


    public void reload(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ChoiceWindow.fxml"));
        Parent root = fxmlLoader.load();
        Main.stage.getScene().setRoot(root);
    }
}
