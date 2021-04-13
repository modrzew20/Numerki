package zadanie3;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class Controller
{
    public LineChart lineChart;

    public void initialize()
    {
        XYChart.Series series = new XYChart.Series();
        String x;
        series.setName("F(x)");
        lineChart.setCreateSymbols(true);
        for(double i=App.A; i<=App.B ;i+=0.01)
        {
            x = String.format("%.2f", i);
            series.getData().add(new XYChart.Data(x, App.function.pattern(i)));
        }

        XYChart.Series series1 = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        XYChart.Series series3 = new XYChart.Series();
        series1.setName("Lagrange Interpolation");
        series2.setName("Newton Interpolation");
        series3.setName("Czybyszew's points");
        double[] C = Czybyszew.getNodes(App.N, App.A, App.B);
        for(int i=0; i<C.length; i++)
        {
            x = String.format("%.2f", C[i]);
            series3.getData().add(new XYChart.Data(x, App.function.pattern(C[i])));
        }
        for(double i=App.A; i<=App.B ;i+=0.01)
        {
            x = String.format("%.2f", i);
            series1.getData().add(new XYChart.Data(x, Lagrange.compute(C, App.function, i)));

            x = String.format("%.2f", i);
            series2.getData().add(new XYChart.Data(x, Newton.compute(C, App.function, i)));
        }
        lineChart.getData().add(series);
        lineChart.getData().add(series1);
        lineChart.getData().add(series2);
        lineChart.getData().add(series3);
    }
}
