/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;
import javax.swing.*;

/**
 *
 * @author waruwat
 */
public class Category {
    private int cid, product, max, min;
     private JFrame frame;
    private String name;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (Function.isAllLetter(name)) {
            this.name = name;
        }
        else {
            JOptionPane.showMessageDialog(frame, "Input only a character please.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}
