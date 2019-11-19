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
public class Supplier {
    private int sid;
    private String fname, lname, address, tel, des;
    private String img = "default.png";
    private JFrame frame;
    
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        if (Function.isAllLetter(fname)) {
            this.fname = fname;
        }
        else {
            JOptionPane.showMessageDialog(frame, "Input only a character please.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        if (Function.isAllLetter(lname)) {
            this.lname = lname;
        }
        else {
            JOptionPane.showMessageDialog(frame, "Input only a character please.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        if (Function.isAllNumber(tel)) {
            this.tel = tel;
        }
        else {
            JOptionPane.showMessageDialog(frame, "Input only an interger please.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
    
}
