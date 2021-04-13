package zadanie3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

public class App extends Application
{
    static Function function = new Wykladnicza();;
    static int N = 8;
    static double A = -12;
    static double B = 12;
    static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setScene(new Scene(root));
        stage=primaryStage;
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Function[] functions = new Function[]{new Wielomian(), new Wykladnicza(), new Trygonometryczna(), new Funkcja1(), new Funkcja2()};
        System.out.println("Wybierz numer funkcji:");
        for(int i=0; i<functions.length; i++)
        {
            System.out.println(i + ": " + functions[i].name);
        }/*
        int number = Integer.parseInt(scan.nextLine());
        function = functions[number];
        System.out.println("Podaj początek rozpatrywanego przedziału:");
        A = Integer.parseInt(scan.nextLine());
        System.out.println("Podaj koniec rozpatrywanego przedziału:");
        B = Integer.parseInt(scan.nextLine());
        System.out.println("Podaj ilość węzłów Czebyszewa:");
        N = Integer.parseInt(scan.nextLine());
        */
        function = functions[0];
        A = -10;
        B = 10;
        N = 3;
        //
        launch(args);
    }
}
