/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.projects;
import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author ajay0
 * 
 * Overview: The customer class stems from a user. A customer is defined by 
 * a username, password, and role(which is customer). The customer has the ability
 * to withdraw, deposite and has a level status that keeps a track of the levels using 
 * a state configuration. The customer's purpose is to be a member of the bank and 
 * keep funds in the account. The customer object is mutable as the amount of funds, level, 
 * can change at any time. This is also mutable as it writes to files that change over time
 * 
 * Constructors: The object can be initalized as is with no parameters or can be given 
 * a username, password and role in the form of s String
 * 
 * Abstraction Function:
 * AF(c) = This function is defined for all role that are = "customer" and all 
 *  account balance that are above 0  
 * 
 * 
 * Rep invariant:
 * -amount must be greater than 0
 * -role must = "customer"
 * 
 * Effects: 
 * Returns the level, amount of funds, read from files to see username, password and balance
 * 
 * Modifies: 
 * can modify the level in which the customer is in. Can modify the amount of funds
 * modifies files to track balnce
 * 
 * 
 * Requires:
 * username
 * password
 * role 
 * level
 */


public class customer extends user 
{
    private double amount;
    
    private level myLevel;
    
    /**
     *
     */
    public customer() {
            }
    
    /**
     *
     * @param usernmae
     * @param password
     * @param role
     */
    public customer(String usernmae, String password, String role) 
    {
        super(usernmae, password, role);
        this.setAmount(this.getAmount());
        
    }
   
    /**
     *
     * @param amount
     */
    public void setAmount(double amount) {
        this.amount = amount;
        this.updateBalance(this.amount);
    }
    
    /**
     *
     * @param amount
     */
    public void deposite(double amount)
    {
        this.amount = this.amount + amount;
        this.updateBalance(this.amount);
    }
    
    /**
     *
     * @param amount
     */
    public void withdraw(double amount)
    {
        this.amount = this.amount - amount; 
        this.updateBalance(this.amount);
    }
    
    /**
     *
     * @return
     */
    public String getLevel()
    {
        return myLevel.toString();
    }
    
    /**
     *
     * @param l
     */
    public void setLevel( level l)
    {
         myLevel = l;
    }
    
    /**
     *
     */
    public void upgrade()
    {
        myLevel.upgrade(this);
    }
    
    /**
     *
     */
    public void degrade()
    {
        myLevel.degrade(this);
    }

    /**
     *
     * @param amount
     */
    public void updateBalance(double amount)
    {
        try 
        { 

            {
                FileWriter myWriter = new FileWriter(super.getUserName(),false);
                myWriter.write(super.getUserName()+"\n");
                myWriter.write(super.getPassword()+"\n");
                myWriter.write(amount+"\n");
                myWriter.close();
            }
        } 
        catch (IOException e) 
        {        
            System.out.println("An error occurred.");            
            e.printStackTrace();    
        }
    }
    
    /**
     *
     * @return
     */
    public double getAmount() {
        double balance = 0 ;
        try 
        { 
            File file = new File(super.getUserName());
            Scanner text = new Scanner(file);
            
            String un = text.nextLine();
            String pass = text.nextLine();
            balance = text.nextDouble();
        }          
           
        
        catch (IOException e) 
        {          
            System.out.println("An error occurred.");
            e.printStackTrace(); 
        }
        return balance;
    }
    
    /**
     *
     * @return
     */
    public String getAmountS()
    {
        String balance = "";
        try 
        { 
            File file = new File(super.getUserName());
            Scanner text = new Scanner(file);
            
            String un = text.nextLine();
            String pass = text.nextLine();
            balance = text.nextLine();
        }          
           
        
        catch (IOException e) 
        {          
            System.out.println("An error occurred.");
            e.printStackTrace(); 
        }
        return balance;
    
    }

    @Override
    public String toString() {
        return "customer" + super.getUserName() + "amount=" + getAmount() + ", myLevel=" + getLevel() + '}';
    }
    
    
    public boolean repOk()
    {
        boolean rep = true;
        if (!super.getRole().equals("customer"))
            rep = false;
        if (getAmount() < 0)
            rep = false;
        return rep;
    
    }
    
    
    

}
