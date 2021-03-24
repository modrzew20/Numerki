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

        //x = Double.toString(i);

        if(siecznychMethod.validationCheck) {
            putSinglePoint("2. Wynik metody Siecznych", i, ChoiceWindow.m.pattern(i));
            iter02.setText(iter02.getText() + Siecznych.it);
            result02.setText(result02.getText() + i);
        }else {
            iter03.setText(iter02.getText() + "Niespełniono założenia\no przeciwnych znakach\nfunkcji na krańcach\nbadanego przedziału");
            result03.setText(result02.getText() + "Niespełniono założenia\no przeciwnych znakach\nfunkcji na krańcach\nbadanego przedziału");

        }


        Falsi falsiMethod = new Falsi();
        i = falsiMethod.compute(ChoiceWindow.dokladnosc,ChoiceWindow.od, ChoiceWindow.dok,ChoiceWindow.iteracje,ChoiceWindow.which);

        if(Falsi.validationCheck) {
            //x = Double.toString(i);
            putSinglePoint("3. Wynik metody Falsi", i, ChoiceWindow.m.pattern(i));
            iter03.setText(iter03.getText()+Falsi.it);
            result03.setText(result03.getText() + i);
        } else {
            iter03.setText(iter03.getText() + "Niespełniono założenia\no przeciwnych znakach\nfunkcji na krańcach\nbadanego przedziału");
            result03.setText(result03.getText() + "Niespełniono założenia\no przeciwnych znakach\nfunkcji na krańcach\nbadanego przedziału");
        }
    }

    private void putSinglePoint(String nameOfThePoint, double x, double f_x) {
        XYChart.Series newSeries = new XYChart.Series();
        String xString = String.format("%.2f", x);
        newSeries.setName(nameOfThePoint + " [" + x + " ; " + f_x + " ]");
        newSeries.getData().add(new XYChart.Data(xString, f_x));
        lineChart.getData().add(newSeries);
    }

    public static int sign(double a) {
        return (a >= 0 ? 1 : -1);
    }
}
