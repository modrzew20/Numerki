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
    public Label result03;
    public Label iter02;
    public Label iter03;

    public void initialize() {
        XYChart.Series series = new XYChart.Series();
        String x;
        series.setName("F(x)");
        lineChart.setCreateSymbols(false);

        for(double i=ChoiceWindow.od; i<=ChoiceWindow.dok ;i+=0.01) {
            x=String.format("%.2f", i);
            series.getData().add(new XYChart.Data(x, ChoiceWindow.m.pattern(i)));
        }
        lineChart.getData().add(series);

        Siecznych siecznychMethod = new Siecznych();
        double i = siecznychMethod.compute(ChoiceWindow.dokladnosc,ChoiceWindow.od, ChoiceWindow.dok,ChoiceWindow.iteracje,ChoiceWindow.which);

        x = String.format("%.7f", i);
        putSinglePoint("2. Wynik metody Newtona", x, ChoiceWindow.m.pattern(i));



        iter02.setText(iter02.getText()+ Siecznych.it);
        result02.setText(result02.getText() + i);

        Falsi falsiMethod = new Falsi();
        i = falsiMethod.compute(ChoiceWindow.dokladnosc,ChoiceWindow.od, ChoiceWindow.dok,ChoiceWindow.iteracje,ChoiceWindow.which);

        if(Falsi.validationCheck) {
            x=String.format("%.7f", i);
            putSinglePoint("3. Wynik metody Falsi", x, ChoiceWindow.m.pattern(i));
            iter03.setText(iter03.getText()+Falsi.it);
            result03.setText(result03.getText() + i);
        } else {
            iter03.setText(iter03.getText() + "Niespełniono założenia\no przeciwnych znakach\nfunkcji na krańcach\nbadanego przedziału");
            result03.setText(result03.getText() + "Niespełniono założenia\no przeciwnych znakach\nfunkcji na krańcach\nbadanego przedziału");
        }
    }

    private void putSinglePoint(String nameOfThePoint, String x, double y) {
        XYChart.Series series = new XYChart.Series();
        series.setName(nameOfThePoint + " [" + x + " ; " + y + " ]");
        series.getData().add(new XYChart.Data(x,y));
        lineChart.getData().add(series);
    }
}
