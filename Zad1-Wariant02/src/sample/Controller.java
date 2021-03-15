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
            if(ChoiceWindow.funkcja=="F(x)=((x + 1.0) * x - 2.0) * x - 1.0")   series.getData().add(new XYChart.Data(x,functions.secondp(i)));
            if(ChoiceWindow.funkcja=="F(x)=sin(x) - cos(x + 1.0)")   series.getData().add(new XYChart.Data(x,functions.thirdp(i)));
            if(ChoiceWindow.funkcja=="F(x)=exp(x) - 4.0 * x")   series.getData().add(new XYChart.Data(x,functions.fourthp(i)));
            if(ChoiceWindow.funkcja=="F(x)=sin(exp(-x*x)) - 0.5")   series.getData().add(new XYChart.Data(x,functions.fifthp(i)));




        }
        lineChart.getData().add(series);


        XYChart.Series series2 = new XYChart.Series();
        double i=0;

        if(ChoiceWindow.funkcja=="F(x)=x*x-2.0") i=functions.first(ChoiceWindow.dokladnosc,ChoiceWindow.wariant,ChoiceWindow.od, ChoiceWindow.dok,ChoiceWindow.op,ChoiceWindow.iteracje);
        if(ChoiceWindow.funkcja=="F(x)=((x + 1.0) * x - 2.0) * x - 1.0") i=functions.second(ChoiceWindow.dokladnosc,ChoiceWindow.wariant,ChoiceWindow.od, ChoiceWindow.dok,ChoiceWindow.op,ChoiceWindow.iteracje);
        if(ChoiceWindow.funkcja=="F(x)=sin(x) - cos(x + 1.0)") i=functions.third(ChoiceWindow.dokladnosc,ChoiceWindow.wariant,ChoiceWindow.od, ChoiceWindow.dok,ChoiceWindow.op,ChoiceWindow.iteracje);
        if(ChoiceWindow.funkcja=="F(x)=exp(x) - 4.0 * x") i=functions.fourth(ChoiceWindow.dokladnosc,ChoiceWindow.wariant,ChoiceWindow.od, ChoiceWindow.dok,ChoiceWindow.op,ChoiceWindow.iteracje);
        if(ChoiceWindow.funkcja=="F(x)=sin(exp(-x*x)) - 0.5") i=functions.fifth(ChoiceWindow.dokladnosc,ChoiceWindow.wariant,ChoiceWindow.od, ChoiceWindow.dok,ChoiceWindow.op,ChoiceWindow.iteracje);


        result.setText("Wynik:" + i);
        x=String.format("%.2f", i);
        series2.getData().add(new XYChart.Data(x,0));
        lineChart.getData().add(series2);
    }

}
