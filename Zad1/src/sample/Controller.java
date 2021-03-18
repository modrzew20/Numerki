package sample;

import A.Afunctions;
import A.Model;
import A.WariantA;
import A.Wielomian;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;



public class Controller {

    public LineChart lineChart;
    public NumberAxis y;
    public CategoryAxis x;
    public Label result;


    public void initialize() {
        XYChart.Series series = new XYChart.Series();
        String x;
        series.setName("F(x) - WARIANT A");
        lineChart.setCreateSymbols(false);

        Model m=null;

        for(double i=ChoiceWindow.od; i<=ChoiceWindow.dok ;i+=0.01) {
            x=String.format("%.2f", i);
            if(ChoiceWindow.funkcja==1) {
                m = new Wielomian();
                series.getData().add(new XYChart.Data(x, m.pattern(i)));
            }
        }

        lineChart.getData().add(series);


        XYChart.Series series2 = new XYChart.Series();
        double i=0;

        Afunctions a = new Afunctions();

        if(ChoiceWindow.funkcja==1) i=a.Newton(ChoiceWindow.dokladnosc,ChoiceWindow.od, ChoiceWindow.dok,ChoiceWindow.iteracje,ChoiceWindow.which, ChoiceWindow.funkcja);

        result.setText("Wynik:" + i);
        series2.setName("Wynik");
        x=String.format("%.2f", i);
        series2.getData().add(new XYChart.Data(x,0));
        lineChart.getData().add(series2);
    }



}
