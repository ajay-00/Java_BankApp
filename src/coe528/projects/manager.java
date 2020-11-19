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
import java.io.*;

/**
 *
 * @author ajay0
 */
public class manager extends user{

    public manager() {
    }
    
    public manager(String usernmae, String password, String role) {
        super(usernmae, password, role);
    }
    
    public boolean addCustomer(String username, String password)
    {
        boolean created = false;
        
        try 
        { 
           
            File myFile = new File(username);
            if (myFile.createNewFile())
            {
                System.out.println("File is created!");
                FileWriter myWriter = new FileWriter(username,true);
                myWriter.write(username+"\n");
                myWriter.write(password+"\n");
                myWriter.write(100+"\n");
                
                created = true;
                
                FileWriter text = new FileWriter("accounts",true);
                text.write(username+" "+password + "\n" );
                
                myWriter.close();
                text.close(); 
            } 
            else 
            {
                System.out.println("File already exists.");    
                created = false; 
            }
           
                      
        } 
        catch (IOException e) 
        {        
            System.out.println("An error occurred.");            
            e.printStackTrace();    
        }
        return created;
        
    }
    
    public boolean deleteCustomer(String username, String password)
    {
        boolean deleted; 
        
        
        File myObj =new File(username); 
        if (myObj.delete()) { 
          System.out.println("Deleted the file: " + myObj.getName());
          updateList(username,password);
          deleted = true; 
        } else {
          System.out.println("Failed to delete the file.");
          deleted = false; 
        }

        return deleted; 
    }
    
  
    public void updateList(String username, String password)
    {
       
        Scanner sc2 = null;
            try {
                File input = new File("accounts");
                //File output = new File("temp");
 
                sc2 = new Scanner(input);
                FileWriter printer = new FileWriter("temp");
            
            while (sc2.hasNextLine()) {
                    Scanner s2 = new Scanner(sc2.nextLine());
                while (s2.hasNext()) {
                    String u = s2.next();
                    String p = s2.next();
                    System.out.print(u + " " + p  +"\n");
                    //printer.write(u+" "+p + "\n");
                    if (!(username.equals(u)  && password.equals(p)))
                    {
                        printer.write(u+" "+p + "\n");
                    }
                }
            }
            printer.close();
            input = new File("temp");
            sc2 = new Scanner(input);
            printer = new FileWriter("accounts");
            while (sc2.hasNextLine()) {
                    Scanner s2 = new Scanner(sc2.nextLine());
                while (s2.hasNext()) {
                    String u = s2.nextLine();
                   
                    System.out.print(u);
                   
          
                     printer.write(u+"\n");
                    
                }
            }
            printer.close();
            }
            catch (Exception e) {
                e.printStackTrace();  
            }
            
            
    }
    
    
}
