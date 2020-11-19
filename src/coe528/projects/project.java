
package coe528.projects;

/**
 *
 * @author ajay0
 */
  
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
public class project extends Application {

    Stage window;
    Scene scene1, scene2, scene3;
    private String userN;
    private String pass;
    private String role;
    private manager M;
    private customer C;
    private double value;        
          

    public static void main(String[] args) {
        launch(args);
    }

    public boolean signIn ()
    {
        boolean success = false;
        if(role.equals("manager"))
        {
            if (userN.equals("admin")  && pass.equals("admin"))
            {
                success = true; 
                M = new manager();
            }
            else 
                success = false; 
    
        }
        
        else if (role.equals("customer"))
        {
            Scanner sc2 = null;
            try {
                sc2 = new Scanner(new File("accounts"));
            } catch (Exception e) {
                e.printStackTrace();  
            }
            while (sc2.hasNextLine()) {
                    Scanner s2 = new Scanner(sc2.nextLine());
                while (s2.hasNext()) {
                    String u = s2.next();
                    String p = s2.next();
                    
                    if (userN.equals(u)  && pass.equals(p))
                    {
                        success = true; 
                        C = new customer(userN,pass,"customer");
                    
                    }
                }
            }
            
          
            
        }
        return success; 
    }
    
    public void setLevel()
    {
        C.setLevel(new silver());
        if (C.getAmount()<10000)
        {}
        else if (C.getAmount()>=10000 && C.getAmount()<20000 )
            C.upgrade();
        else if(C.getAmount()>20000)
            C.setLevel(new platinum());
    }
    
    public double onlineP(double amount)
    {
        if (amount > 50)
        {
            if (C.getLevel().equals("silver"))
                amount = amount + 20; 
            else if (C.getLevel().equals("gold"))
                amount = amount + 10;
            else if (C.getLevel().equals("platinum"))
                 amount = amount ;
            
            
        }
        else 
        {
            amount = 0 ;
        }
        return amount;
    }
    
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        //home button
        Button home = new Button("logout");
        home.setOnAction(e ->{
            
            window.setScene(scene1);
                
               
                        });
        
        //Label
        Label promt = new Label("Please eneteruser name and password");
        Label usernamePromt = new Label("Username:");
        Label passwordPromt = new Label("Password:");
        
        //TextFeild
        TextField username = new TextField();
        TextField password = new TextField();
        
        //check boxes
        CheckBox managerBox = new CheckBox("Manager");
        CheckBox customerBox = new CheckBox("Customer");
          managerBox.setOnAction(e->{
                customerBox.setSelected(false);
         });
         customerBox.setOnAction(e->{
                managerBox.setSelected(false);
         });

        //Button login
        Button login = new Button("login");
      
        
        
        login.setOnAction(e ->{
            
            
            
            if (managerBox.isSelected())
            {
                role = "manager";
                
            }
            if (customerBox.isSelected())
            {
                role = "customer";
            }
            
            
            
            userN=username.getText();
            pass = password.getText();
            
            if (signIn())
            {
                if (role.equals("manager"))
                     window.setScene(scene2);
                else
                     window.setScene(scene3);
            }
             
                username.clear();
                password.clear();
                  
                });
        
        
        
        //Layout 1 - children laid out in vertical column
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(promt,usernamePromt, username,passwordPromt, password,
                managerBox, customerBox,login);
        scene1 = new Scene(layout1, 400, 400);

        ///////////////////////////////////////////////////////////////////////
        //label
        Label welcome = new Label("Welcome admin");
        Label addCustomer = new Label("Add or remove customer");
        
        
        //TextFeild
        TextField addUser = new TextField();
        TextField addUserPass = new TextField();
       
        //CHECKBOX
        CheckBox addPerson = new CheckBox("Add");
        CheckBox removePerson = new CheckBox("Remove");
          addPerson.setOnAction(e->{
                removePerson.setSelected(false);
         });
         removePerson.setOnAction(e->{
                addPerson.setSelected(false);
         });
        
        
        //Button 
        Button submit = new Button("Submit");
        submit.setOnAction(e ->{
            
            if (addPerson.isSelected())
                M.addCustomer(addUser.getText(), addUserPass.getText());
            
            if (removePerson.isSelected())
                M.deleteCustomer(addUser.getText(), addUserPass.getText());
                
               
                        });
        
       

        //Layout 2
        VBox layout2 = new VBox(20);
        layout2.getChildren().addAll(welcome,addCustomer,usernamePromt,addUser,
                passwordPromt,addUserPass,addPerson, removePerson, submit,home 
                );
        scene2 = new Scene(layout2, 600, 500);

        
        
        
        
        ///////////////////////////////////////////////////////////////////////
        
               
        //Labe3
        String amount = "";
        String llll = "silver";
        Label level = new Label(llll);
        
        Label dep = new Label("Please eneter amount:");
        Label getBal = new Label("Balance: " + amount);
        Label purchace = new Label("Online Purchase");
        
        //TextFeild
        TextField entry = new TextField();
        TextField purch = new TextField();
        
        
        //check boxes
        CheckBox depBox = new CheckBox("Deposite");
        CheckBox withBox = new CheckBox("WithDraw");
          depBox.setOnAction(e->{
                withBox.setSelected(false);
         });
         withBox.setOnAction(e->{
                depBox.setSelected(false);
         });

        //Button login
       
        
        Button home2 = new Button("logout");
        
        home2.setOnAction(e ->{
            
            window.setScene(scene1);
        });
        
        Button getBalance = new Button("Get Balnce");
        
        getBalance.setOnAction(e ->{
            getBal.setText("Balnce: " + C.getAmountS());
            this.setLevel();
            level.setText("Level: "+ C.getLevel());
        });
        
        Button go = new Button("GO");
        go.setOnAction(e ->{
            
             
            if (depBox.isSelected())
            {
                value = Double.parseDouble(entry.getText());
                C.deposite(value);
                
            }
            if (withBox.isSelected())
            {
                value = Double.parseDouble(entry.getText());
                if (value <= C.getAmount())
                    C.withdraw(value);
                
                   
            }
            this.setLevel();
            level.setText("Level: "+ C.getLevel());
            
          
                  
                });
        
       Button buy = new Button("Buy");
        
        buy.setOnAction(e ->{
            value = Double.parseDouble(purch.getText());
            if (value <= C.getAmount())
                C.withdraw(onlineP(value));
        });
        
        
        
        //Layout 3 - children laid out in vertical column
        VBox layout3 = new VBox(20);
        layout3.getChildren().addAll(level,dep, entry, depBox, withBox,
            go,getBalance, getBal,purchace, purch,buy, home2);
        scene3 = new Scene(layout3, 400, 500);

        //Display scene 1 at first
        window.setScene(scene1);
        window.setTitle("BankApp");
        window.show();
    }

    

}
