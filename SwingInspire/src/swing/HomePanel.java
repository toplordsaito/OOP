/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.GridPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author waruwat
 */
public class HomePanel extends javax.swing.JPanel {

    /**
     * Creates new form HomePanel
     */
    public HomePanel() {
        initComponents();
        productMenu1.SetQueryTable("WHERE count <= '20' ");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        productMenu1 = new swing.ProductMenu();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swing/images/welcome.png"))); // NOI18N
        jLabel1.setText("Welcome!");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel3.setText("สินค้าที่ใกล้หมด");

        jButton1.setText("Chart");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(productMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(14, 14, 14)))
                        .addGap(181, 181, 181))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(274, 274, 274))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                .addGap(29, 29, 29)
                .addComponent(jButton1)
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ProductMenu obj = new ProductMenu();
        ArrayList<Product> list = obj.getProductList();
        JFXPanel fxPanel;
        JPanel mainPanel = new JPanel(new BorderLayout());
        fxPanel = new JFXPanel();

        mainPanel.add(fxPanel, BorderLayout.CENTER);

        JLabel titleLabel = new JLabel("ยอดคงเหลือ");

        mainPanel.add(titleLabel, BorderLayout.NORTH);
        JFrame framePie = new JFrame();
        framePie.add(mainPanel);
        framePie.setVisible(true);
        framePie.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        framePie.setSize(800, 800);

        GridPane grid = new GridPane();
        Scene scene = new Scene(grid, 800, 800);
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
        XYChart.Series bar1 = new XYChart.Series<>();

//        bar10.setName("Computing Devices");
//        bar1.getData().add(getData(40000, "Desktop"));
//        bar1.getData().add(getData(30_000, "Netbooks"));
//        bar1.getData().add(getData(70_000, "Tablets"));
//        bar1.getData().add(getData(90_000, "Smartphones"));
//
//        XYChart.Series bar2 = new XYChart.Series<>();
//        bar20.setName("Consumer Goods");
//        bar2.getData().add(getData(60_000, "Washing Machines"));
//        bar2.getData().add(getData(70_000, "Telivision"));
//        bar2.getData().add(getData(50_000, "Microwave Ovens"));
//
//        barChart.getData().addAll(bar1, bar2);
        grid.setVgap(50);
        grid.setHgap(75);
        grid.add(barChart, 1, 1);
        fxPanel.setScene(scene);
        barChart.setPrefSize(600, 600);

    }//GEN-LAST:event_jButton1ActionPerformed
    private XYChart.Data getData(double x, String y) {
        XYChart.Data data = new XYChart.Data<>();
        data.setYValue(x);
        data.setXValue(y);
        return data;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private swing.ProductMenu productMenu1;
    // End of variables declaration//GEN-END:variables
}
