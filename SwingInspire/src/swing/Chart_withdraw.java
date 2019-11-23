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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javax.swing.*;
import java.util.LinkedHashMap; 
import java.util.Map; 


/**
 *
 * @author FallenDown
 */
public class Chart_withdraw extends JFrame {

    private int cc = 2;
    private JFXPanel fxPanel;
    private JButton b1;
    private String string_query = "SELECT * FROM  `log` ";
    private int red = 200;
    private int green = 200;
    private int blue = 200;
    private String name;
    private int num;
    ArrayList<log> w_list = getLogList();

    public ArrayList<log> getLogList() {
        ArrayList<log> withdraw_list = new ArrayList<log>();
        Connection connection = Db_connect.getConnection();

        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(string_query);
            log l;
            while (rs.next()) {
                //double date, int uid, int target, String string, String type
                l = new log(new Timestamp(Long.parseLong(rs.getString("date"))), rs.getInt("uid"), rs.getInt("target"), rs.getString("string"), rs.getString("type"));
                String sql = "SELECT  `name` FROM `product` WHERE `pid` =" + l.getTarget();
                ResultSet rec = st.executeQuery(sql);
                rec.next();
                name = rec.getString("name");

                if ("WITHDRAW".equals(l.getType())) {

                    withdraw_list.add(l);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return withdraw_list;
    }

    public void init() {

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
        Color myColor = new Color(red, green, blue);
        b1.setBackground(myColor);
        b1.setForeground(Color.black);
        add(mainPanel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        setSize(900, 800);
        setMinimumSize(new Dimension(800, 800));
        ShowChart();
        b1.addActionListener((java.awt.event.ActionEvent evt1) -> {
            cc += 1;
            ShowChart();
        });
        System.out.println(w_list);
    }

    private void ShowChart() {

        if (cc % 2 == 0) {

            PieChart pieChart = new PieChart();
            for (int i = 0; i < w_list.size(); i++) {
                String[] number = w_list.get(i).getString().split(" ");
                System.out.println(number[1]);
                Connection connection = Db_connect.getConnection();
                Statement st;
                ResultSet rs;
                try {
                    st = connection.createStatement();
                    String sql = "SELECT  `name` FROM `product` WHERE `pid` =" + w_list.get(i).getTarget();
                    ResultSet rec = st.executeQuery(sql);
                    rec.next();
                    name = rec.getString("name");

                } catch (Exception e) {
                    e.printStackTrace();
                }
                num = Integer.parseInt(number[1]);

                PieChart.Data slice1 = new PieChart.Data(name, num);
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
            StackedBarChart barChart
                    = new StackedBarChart<>(lineXAxis, lineYAxis);

            for (int i = 0; i < w_list.size(); i++) {
                String[] number = w_list.get(i).getString().split(" ");
                Connection connection = Db_connect.getConnection();
                Statement st;
                ResultSet rs;
                try {
                    st = connection.createStatement();
                    String sql = "SELECT  `name` FROM `product` WHERE `pid` =" + w_list.get(i).getTarget();
                    ResultSet rec = st.executeQuery(sql);
                    rec.next();
                    name = rec.getString("name");

                } catch (Exception e) {
                    e.printStackTrace();
                }
                num = Integer.parseInt(number[1]);
                XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>();
                series1.setName(name);
                series1.getData().add(new XYChart.Data<String, Number>(name, num));
                barChart.getData().add(series1);
            }

            StackPane root = new StackPane(barChart);
            Scene scene = new Scene(root, 800, 800);
            fxPanel.setScene(scene);
            barChart.setMinSize(700, 700);
        }
    }

    public static void main(String[] args) {

        new Chart_withdraw().init();

    }
}
