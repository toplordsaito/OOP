/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.sql.Timestamp;

/**
 *
 * @author FallenDown
 */
public class log {
    private Timestamp date;
    private int uid, target;
    private String string, type;
    private String name;

    public log(Timestamp date, int uid, int target, String string, String type) {
        this.date = date;
        this.uid = uid;
        this.target = target;
        this.string = string;
        this.type = type;
    }

    public Timestamp getDate() {
        return date;
    }

    public int getUid() {
        return uid;
    }

    public int getTarget() {
        return target;
    }

    public String getString() {
        return string;
    }

    public String getType() {
        return type;
    }
    
    
}
