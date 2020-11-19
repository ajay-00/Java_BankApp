/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.projects;

/**
 *
 * @author ajay0
 */
public class gold  extends level{

    gold() {
       
    }

    @Override
    public void degrade(customer c) {
        c.setLevel(new silver());
    }

    @Override
    public void upgrade(customer c) {
        c.setLevel(new platinum());
    }

    @Override
    public String toString() {
        return "gold";
    }
    
}
