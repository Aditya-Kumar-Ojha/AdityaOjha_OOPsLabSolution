import java.util.Scanner;

 class Employee
 {
       String fName;
       String lName;
       String pass;
       String dept;
       String email;
       int defaultPasswordLength=10;
       String companySuffix="StayinFront.com";
       
       public Employee(String fName,String lName)
       {
           this.fName = fName;
           this.lName = lName;
           this.dept=setDepartment();
           this.pass=CredentialService(defaultPasswordLength);
           
           System.out.println("Your password is: "+this.pass+"\n\n");
       }
       public String setDepartment()
       {
           Scanner sc=new Scanner(System.in);
           System.out.print("Please Enter the department from the following:" + "\nDEPARTMENT CODES:\n1. Technical\n2. Admin\n3. Human Resource\n4. Legal \n0 for none\nEnter the department code: ");
           int depchoice=sc.nextInt();
           if(depchoice==1)
           {
               return "Technical";
           }
           else if(depchoice==2) 
           {
               return "Admin";
           }
           else if(depchoice==3)
           {
               return "Human Resource";
           }
           else if(depchoice==4) 
           {
               return "Legal";
           }
           else 
           {
               return "";
           }
       }
      
       public String CredentialService(int length) 
       {
    	   email=fName.toLowerCase()+"."+lName.toLowerCase()+"@" +dept+"."+companySuffix;
           String passwordSet= "ABCDEFGHIJKLMNOpqrstuvwxyz0123456789!@#$%";
           char[] password=new char[length];
           for(int i=0;i<length;i++) 
           {
               int rand=(int) (Math.random()*passwordSet.length());
               password[i]=passwordSet.charAt(rand);
           }
           return new String(password);
           
 
       }     
       public void changePassword(String password)
       {
           this.pass=password;
       }
       
       public String getPassword() { return pass; }
       
       public String showinfo()
       {
           return "Dear: "+fName+" "+lName+"\n"+
                   "\nyour generated credentials are as follows:"+"\n"+"\nEmailID: "+email+
                   "\nPassword: "+pass+"\n";
       }
 }    
public class EmailApp
 {
    	   public static void main (String [] args)
    	   {
    		   Employee em1=new Employee("Aditya","Ojha");
    		   Employee em2=new Employee("Raushan","Kumar");
                   System.out.println(em1.showinfo());
                   System.out.println(em2.showinfo());   		   
    	   }
}