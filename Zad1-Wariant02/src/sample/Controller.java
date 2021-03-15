package sample;

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
        series.setName("F(x)");
        lineChart.setCreateSymbols(false);
        for(double i=ChoiceWindow.od; i<=ChoiceWindow.dok ;i+=0.01) {
            x=String.format("%.2f", i);
            if(ChoiceWindow.funkcja=="F(x)=x*x-2.0")   series.getData().add(new XYChart.Data(x,functions.firstp(i)));




        }
        lineChart.getData().add(series);


        XYChart.Series series2 = new XYChart.Series();
        double i=0;

        if(ChoiceWindow.funkcja=="F(x)=x*x-2.0") i=functions.first(ChoiceWindow.dokladnosc,ChoiceWindow.wariant,ChoiceWindow.od, ChoiceWindow.dok,ChoiceWindow.op,ChoiceWindow.iteracje);




        result.setText("Wynik:" + i);
        x=String.format("%.2f", i);
        series2.getData().add(new XYChart.Data(x,0));
        lineChart.getData().add(series2);
    }

}
