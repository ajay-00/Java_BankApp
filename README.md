# Java_BankApp
Java Banking application. Final project for Object Oriented Eng Analysis and Design. 

Assignment Details:
Develop a simple Bank Account Application. The application must be a graphical user inter-face (GUI) based.  There are two kinds of users of this application: Manager and Customer. Here we will assume there is  only  one  manager  and  zero  or  more  customers  who  uses  the  application.  Every customer has only one bank account. A customer can login, logout, deposit money, withdraw money, get balance, do online purchase(s). The manager can login, logout, add customer, delete customer. 

Every customer has three levels: silver, gold, platinum. When a customer has less than 10000 dollars in her account, she is at silver level. When a customer has 10000 dollars or more but less than 20000 dol-lars in her account, she is at gold level. When a customer has 20000 dollars or more in her account, she is at platinum level.
 A customer can do an online purchase using the money in her account. The online purchase must be of 50 dollars or more. When a silver customer does an online purchase using her account, she needs to pay a fee of 20 dollars in addition to the purchase amount from her account. When a gold customer does an online purchase using her account, she needs to pay a fee of 10 dollars. When a platinum customer does an online purchase, she does it without paying any fee.
 
In this application,  the  manager  has  username:  admin,  password: admin,  and  role  =  manager.    A customer has a username, password, and role = customer, bank account and level. The information about the customers is stored in separate files—one file per customer; the filename can have the username of the customer. When a manager tries to login through the user interface, the manager’s username, pass-word and  role  are  authenticated.  When  a  customer  tries  to  login  through  the  user interface,  the  customer’s username, password and role are authenticated using the information stored in the relevant file. Only the manager of the bank has the authority to add or delete a customer. When the manager adds a customer, she must create the account of the customer as well with a 100 dollar balance in the account. When the manager deletes a customer, the associated account should get deleted as well. It is assumed that no two users can have the same username.

The GUI of the application must be developed using JavaFX.

