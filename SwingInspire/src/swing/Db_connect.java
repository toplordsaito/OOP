/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

/**
 *
 * @author waruwat
 */
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author waruwat
 */
public class Db_connect {

    public static Connection getConnection() {
        Connection con;
        try {
            con = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/oop", "root", "keep1234");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("x");
            return null;
        }
    }

    public static void executeSQlQuery(String query, String message) {
        Connection con = new Db_connect().getConnection();
        Statement st = null;
        try {
            st = con.createStatement();
            if ((st.executeUpdate(query)) == 1) {
                // refresh jtable data
                System.out.println("OK");

                JOptionPane.showMessageDialog(null, "Data " + message + " Succefully");
            } else {
                JOptionPane.showMessageDialog(null, "Data Not " + message);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            if (con != null) {
                st.close();
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void ShowIMG(JLabel j, String name, String type) {
        try {
            String ImagePath = new File(".").getCanonicalPath() + "\\img\\" + type + "\\" + name;
            ImageIcon MyImage = new ImageIcon(ImagePath);
            Image img = MyImage.getImage();
            Image newImg = img.getScaledInstance(j.getWidth(), j.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon image = new ImageIcon(newImg);
            j.setIcon(image);
        } catch (IOException ex) {
            System.out.println("err");
        }
    }

    public static ImageIcon getIcon(String name, String type) {
        try {
            String ImagePath = new File(".").getCanonicalPath() + "\\img\\" + type + "\\" + name;
            ImageIcon MyImage = new ImageIcon(ImagePath);
            Image imgz = MyImage.getImage();
            Image newImg = imgz.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon image = new ImageIcon(newImg);
            return image;
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return null;
    }
    public static ImageIcon getIcon2(String name, String type) {
        try {
            String ImagePath = new File(".").getCanonicalPath() + "\\img\\" + type + "\\" + name;
            ImageIcon MyImage = new ImageIcon(ImagePath);
            Image imgz = MyImage.getImage();
            Image newImg = imgz.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
            ImageIcon image = new ImageIcon(newImg);
            return image;
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static String BrowImg(String type) {
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Choose file");

        if (ret == JFileChooser.APPROVE_OPTION) {
            String file = fileopen.getSelectedFile().toString();
            System.out.println(file);
            String fileName = file.substring(file.lastIndexOf('\\') + 1, file.length());
            String last = '.' + fileName.substring(fileName.lastIndexOf('.') + 1, fileName.length());
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            last = timestamp.getTime() + last;
            System.out.println(last);
            // Copy file
            String desFile = null;
            try {
                desFile = new File(".").getCanonicalPath() + "\\img\\" + type + "\\" + last;
                System.out.println(new File(".").getCanonicalPath());
                Files.copy(Paths.get(file), Paths.get(desFile),
                        StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);
//                p.setImg(last);
                return last;

            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        }
        return "default.jpg";
    }

    public static void NewLog(String type, String editor, String target, String txt) {
        long time = new Date().getTime();
        String query = "INSERT INTO `log`(`date`, `string`, `uid`, `target`, `type`) VALUES ('" + time + "','" + txt + "','" + editor + "','" + target + "','" + type + "')";
        Connection con = new Db_connect().getConnection();
        Statement st;
        try {
            st = con.createStatement();
            if ((st.executeUpdate(query)) == 1) {
                // refresh jtable data
                System.out.println("Log update");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("LOG OK");
    }

}
