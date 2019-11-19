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
public class Product {

    private int pid, count, price, cid, sid;
    private String name, des;
    private String img = "default.png";
     private JFrame frame;
    public Product() {
    }
    

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

}
