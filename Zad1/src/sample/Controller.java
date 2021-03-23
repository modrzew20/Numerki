package sample;

import A.*;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;



public class Controller {

    public LineChart lineChart;
    public NumberAxis y;
    public CategoryAxis x;
    public Label result02;
    public Label iter02;



    public void initialize() {
        XYChart.Series series = new XYChart.Series();
        String x;
        series.setName("F(x)");
        lineChart.setCreateSymbols(false);

        Model m=null;

        for(double i=ChoiceWindow.od; i<=ChoiceWindow.dok ;i+=0.01) {
            x=String.format("%.2f", i);
            if(ChoiceWindow.funkcja==1) { m = new Wielomian(); }
            if(ChoiceWindow.funkcja==2) { m = new Trygonometryczna(); }
            series.getData().add(new XYChart.Data(x, m.pattern(i)));


        }

        lineChart.getData().add(series);



        XYChart.Series series2 = new XYChart.Series();

        functions a = new functions();
        double i=a.siecznych(ChoiceWindow.dokladnosc,ChoiceWindow.od, ChoiceWindow.dok,ChoiceWindow.iteracje,ChoiceWindow.which, ChoiceWindow.funkcja);


        series2.setName("Wynik");
        x=String.format("%.2f", i);
        series2.getData().add(new XYChart.Data(x,0));
        lineChart.getData().add(series2);
        iter02.setText(iter02.getText()+functions.it);
        result02.setText(result02.getText() + i);

    }



}
