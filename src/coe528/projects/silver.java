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
public class silver extends level {

    public silver() {
    }

    @Override
    public void degrade(customer c) {
        
    }

    @Override
    public void upgrade(customer c) {
        c.setLevel(new gold());
    }

    @Override
    public String toString() {
        return "silver";
    }
    
    
}
