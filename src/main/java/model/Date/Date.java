/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Date;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Manohar
 */

@Embeddable
public class Date implements Serializable {
    private int year;
    private int month;
    private int date;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.month) 
                + "/" + String.valueOf(this.date)
                + "/" + String.valueOf(this.year);
    }
    
}
