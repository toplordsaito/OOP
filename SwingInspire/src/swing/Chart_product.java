/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javax.swing.*;

/**
 *
 * @author FallenDown
 */

public class Chart_product extends JFrame{
    private int cc = 1;
    private JFXPanel fxPanel;
    private JButton b1;
    ProductMenu obj = new ProductMenu();
    ArrayList<Product> list = obj.getProductList();
    private int red = 200;
    private int green = 200;
    private int blue = 200;
    

    public void Chart_product(){
        init();
    }
    public void init(){
        JPanel mainPanel = new JPanel(new BorderLayout());
        fxPanel = new JFXPanel();
        mainPanel.add(fxPanel, BorderLayout.CENTER);
        b1 = new JButton("Change Chart");
        JLabel titleLabel = new JLabel("Products");
        titleLabel.setFont(new Font("Courier", Font.BOLD, 30));
        JPanel p = new JPanel(new GridLayout(1, 5));
        p.add(new JLabel(""));
        p.add(new JLabel(""));
        titleLabel.setForeground(Color.white);
        p.setBackground(Color.darkGray);
        p.add(titleLabel);
        p.add(new JLabel(""));
        p.add(b1);
        mainPanel.add(p, BorderLayout.NORTH);
        Color myColor = new Color(red,green,blue);
        b1.setBackground(myColor);
        b1.setForeground(Color.black);
        add(mainPanel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        setSize(900, 800);
        setMinimumSize(new Dimension(800, 800));
        ShowChart();
        b1.addActionListener((java.awt.event.ActionEvent evt1) -> {
            cc += 1;
            ShowChart();
        });
    }
    private void ShowChart() {
        
        if (cc % 2 == 0) {

                PieChart pieChart = new PieChart();
                for (int i = 0; i < list.size(); i++) {
                    PieChart.Data slice1 = new PieChart.Data(list.get(i).getName(), list.get(i).getCount());
                    pieChart.getData().add(slice1);

                }
                StackPane root = new StackPane(pieChart);
                Scene scene = new Scene(root, 800, 800);
                fxPanel.setScene(scene);
                pieChart.setMinSize(700, 700);
            } else {
                NumberAxis lineYAxis = new NumberAxis(0, 200, 10);
                //lineYAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(lineYAxis,"$",null));
                lineYAxis.setLabel("Numbers");
                CategoryAxis lineXAxis = new CategoryAxis();
                lineXAxis.setLabel("Products");
                BarChart barChart
                        = new BarChart<>(lineXAxis, lineYAxis);

                for (int i = 0; i < list.size(); i++) {
                    XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>();
                    series1.setName(list.get(i).getName());
                    series1.getData().add(new XYChart.Data<String, Number>(list.get(i).getName(), list.get(i).getCount()));
                    barChart.getData().add(series1);
                }

                StackPane root = new StackPane(barChart);
                Scene scene = new Scene(root, 800, 800);
                fxPanel.setScene(scene);
                barChart.setMinSize(700, 700);
            }
        
    }
    public static void main(String[] args) {

        new Chart_product();

    }
}
