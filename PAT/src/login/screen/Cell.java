/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.screen;

import java.awt.Color;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author xpeng
 */
public class Cell extends JButton{
    public Date date;
    private boolean Title;
    public Cell(){
        setContentAreaFilled(false);
        setBorder(null);
        setHorizontalAlignment(JLabel.CENTER);
    }
    public void asTitle(){
        Title = true;
    }
    public boolean isTitle(){
        return Title;
    }
    public void setDate(Date date){
        this.date=date;
    }
    public void currentMonth(boolean act){
        if (act) {
            setForeground(new Color(228, 27, 3 ));
        }else{
            setForeground(new Color(3, 208, 228 ));
        }
    }
}

