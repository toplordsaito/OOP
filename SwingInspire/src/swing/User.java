/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

/**
 *
 * @author ason
 */
public class User {
    private int uid;
    private String name, surname, user, pass, role;
    private String img = "defualt_user.png";
    public User() {
    }


    public int getUid() {
        return uid;
    }

    public String getSurname() {
        return surname;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getRole() {
        return role;
    }

    public void setUid(String uid) {
        this.uid = Integer.parseInt(uid);
    }
    
    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}
