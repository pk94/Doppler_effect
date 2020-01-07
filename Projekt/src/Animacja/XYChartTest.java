package Animacja;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.JPanel;

public class XYChartTest {
	double frequency=10;
	XYSeries dataSet= new XYSeries("seria 1");
	
	public XYChartTest (JPanel pan)
    {
        XYSeriesCollection xySeriesCollection = new XYSeriesCollection(dataSet);
        XYDataset xyDataset = xySeriesCollection;
        JFreeChart lineGraph = ChartFactory.createXYLineChart
                ("Tytul wykresu",  // Title
                        "Tytul osi X",           // X-Axis label
                        "Tytul osi Y",           // Y-Axis label
                        xyDataset,          // Dataset
                        PlotOrientation.VERTICAL,        //Plot orientation
                        true,                //show legend
                        true,                // Show tooltips
                        false               //url show
                );
        // Zapisywanie wykresu do pliku JPG:
       /* try {
        ChartUtilities.saveChartAsJPEG(new File("LineGraph.jpg"), lineGraph, 800, 600);
        } catch (Exception e) {
        System.out.println("Problem z zapisem wykresu do pliku");
        }*/
       // WYSWIETLANIE WYKRESOW W OKNIE SWING
       // Dodawanie wykresu przy pomocy klasy ChartPanel
        ChartPanel chartPanel = new ChartPanel(lineGraph);
        pan.add(chartPanel);
    }
	
	public void setFrequency(double f)
	{
		this.frequency = f;
	}
	
	public double getFrequency()
	{
		return frequency;
	}
}