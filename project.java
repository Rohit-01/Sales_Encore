import java.io.*;
import java.util.*;
import java.sql.*;

class Monitor

{    Scanner sc=new Scanner(System.in);
     Connection con=null;
      Monitor()
	  {  try
	    { 
		 Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/rohit";
		String username="root";
		String password="prototype@01";
		 con=DriverManager.getConnection(url,username,password);
		}
		catch(Exception e)
		{
			 System.out.println(e);
		}
		}
		
	  void prospectRegister() throws Exception
	  {
	    System.out.println("<<<<<<<<<<<<<<<<<<Prospect Resgistration Begins>>>>>>>>>>>>>>>>>");
	   
		System.out.println("Enter id: ");
		int id=Integer.parseInt(sc.nextLine());
		System.out.println("Enter Name: ");
		String name=sc.nextLine();
		System.out.println("Enter Mobile no.: ");
		String mb=sc.nextLine();
		System.out.println("Enter Address: ");
		String ad=sc.nextLine();
		System.out.println("Enter Hotness: ");
		String h=sc.nextLine();
		System.out.println("Enter Model: ");
		String md=sc.nextLine();
		System.out.println("Enter Colour: ");
		String c=sc.nextLine();
		System.out.println("Enter Date: ");
		String dt=sc.nextLine();
		System.out.println("Enter ByMonitorId: ");
		String by=sc.nextLine();
		
		String query = "insert into prospect values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(query);
		pst.setInt(1,id);
		pst.setString(2,name);
		pst.setString(3,mb);
		pst.setString(4,ad);
		pst.setString(5,h);
		pst.setString(6,md);
		pst.setString(7,c);
		pst.setString(8,dt);
		pst.setString(9,by);
		
		int result=pst.executeUpdate();
		if(result>0)
		{
			System.out.println("Prospect Registration Successfull");
		}
		else
		{
			System.out.println("Failed");
		}
	 }
	  
	 void updateProspectData() throws Exception
	 {
		
		while(true)
		{
		 System.out.println("-------------------MENU FOR UPDATION------------------");
				
		System.out.println("1.Enter new Model");
		
		System.out.println("2.Enter new Hotness");
		
		System.out.println("3.Enter new Colour");
		
		System.out.println("4.Enter new Mobile no.");
		
		System.out.println("5.Enter new Password");
		
		System.out.println("6.EXIT");
		
		System.out.println("Enter your choice \n");
	    int ch=Integer.parseInt(sc.nextLine());
		int id, result = 0;
       
        PreparedStatement pst = null;

		
		switch(ch)
		{  
			case 1: System.out.println("Enter the Id");
			        id=Integer.parseInt(sc.nextLine());
					System.out.println("Enter new Model");
					String md=sc.nextLine();
					
					 String query="update prospect set Model=? where Id=?";
					pst=con.prepareStatement(query);
					pst.setInt(1,id);
					pst.setString(2,md);
					
					result=pst.executeUpdate();
					if(result>0)
					{
						System.out.println("Model Updated");
					}
					else
					{
						System.out.println("Failed!!");
					}
					
					break;
			
			case 2: System.out.println("Enter the Id");
			        id=Integer.parseInt(sc.nextLine());
					System.out.println("Enter new  Hotness");
					String ht=sc.nextLine();
					String query2="update prospect set Id=? where Hotness=?";
					
					pst=con.prepareStatement(query2);
					pst.setInt(1,id);
					pst.setString(2,ht);
					result=pst.executeUpdate();
					if(result>0)
					{
						System.out.println("Hotness updated");
					}
					else
					{
						System.out.println("Failed!");
					}
					break;
			
			case 3: System.out.println("Enter the Id");
			        id=Integer.parseInt(sc.nextLine());
					System.out.println("Enter new  Colour");
					String co=sc.nextLine();
					String query3="update prospect set Id=? where Colour=?";
					pst=con.prepareStatement(query3);
					pst.setInt(1,id);
					pst.setString(2,co);
					result=pst.executeUpdate();
					if(result>0)
					{
						System.out.println("Hotness updated");
					}
					else
					{
						System.out.println("Failed!!");
					}
				   break;
				   
			case 4: System.out.println("Enter the Id");
			        id=Integer.parseInt(sc.nextLine());
					System.out.println("Enter new  Mobile no.");
					String mo=sc.nextLine();
					String query4="update prospect set Id=? where Mobile=?";
					pst=con.prepareStatement(query4);
					pst.setInt(1,id);
					pst.setString(2,mo);
					result=pst.executeUpdate();
					if(result>0)
					{
						System.out.println("Mobile no. updated");
					}
					else
					{
						System.out.println("Failed!!");
					}
					break;
					
			case 5:	System.out.println("Enter the Id");
			        id=Integer.parseInt(sc.nextLine());
					System.out.println("Enter new  Password");
					String ps=sc.nextLine();
					String query5="update prospect set Id=? where Password=?";
					pst=con.prepareStatement(query5);
					pst.setInt(1,id);
					pst.setString(2,ps);
					result=pst.executeUpdate();
					if(result>0)
					{
						System.out.println("Password updated");
					}	
					else
					{
						System.out.print("Failed!!");
					}
					break;
			case 6: return;
		}
	  }
		
	}
	
	 void showMonitor() throws Exception
	 {
		String query= "select * from monitor";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next())
		{
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7));
			
		}
	 }
	
	
	 void updateMonitorPs() throws Exception
	{  System.out.println("<----------------->Updation process begins<-----------------?");
		
		 System.out.println("Enter Id ");
		int id=Integer.parseInt(sc.nextLine());
		System.out.println("Enter new Password of "+id+"-Monitor");
		String ps=sc.nextLine();
		String query="update monitor set Password=? where MonitorId=?";
		PreparedStatement pst=con.prepareStatement(query);
		pst.setString(1,ps);
		pst.setInt(2,id);	
		
		int result=pst.executeUpdate();
		if(result>0)
		{
			System.out.println("Password Updated Successfully");
		}
		else 
		{
			System.out.println("Failed!!");
		}	
	}
	
	void updateMonitorMb() throws Exception
	{  System.out.println("<----------------->Updation process begins<-----------------?");
		
		 System.out.println("Enter Id ");
		int id=Integer.parseInt(sc.nextLine());
		System.out.println("Enter new Mobile no. of "+id+"-Monitor");
		String mb=sc.nextLine();
		String query="update monitor set Mobile=? where MonitorId=?";
		PreparedStatement pst=con.prepareStatement(query);
		pst.setInt(2,id);	
		pst.setString(1,mb);
		int result=pst.executeUpdate();
		if(result>0)
		{
			System.out.println("Mobile no. Updated Successfully");
		}
		else 
		{
			System.out.println("Failed!!");
		}	
	}
}

class Admin extends Monitor
{    
	 void showProspect() throws Exception
	{
		String query= "select * from prospect";
		Statement st=con.createStatement();
		
		ResultSet rs=st.executeQuery(query);
		
		if(rs.next()==false)
		{ 
		  System.out.println("\n\n-------- Prospect Table is Empty ---------\n\n ");
		}
		 else{
		  while(rs.next())
		  {
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8)+"\t"+rs.getString(9));
			}
			  
	    	}
		}
		
	
	
	void byFilter() throws Exception
	{    
	  while(true)
	  {
	    System.out.println("-------------------MENU FOR DISPLAY------------------");
				
		System.out.println("1.Display Orderby Model");
		
		System.out.println("2.Display Orderby Hotness");
		
		System.out.println("3.Display Orderby Colour");
		
		System.out.println("4.Display Orderby Date");
		
		System.out.println("5.Display Orderby Monitor");
		
		System.out.println("6.EXIT");
		
		System.out.println("Enter your choice \n");
		int ch=Integer.parseInt(sc.nextLine());
          Statement st=null;
		  ResultSet rs=null;
		switch(ch)
		{
			case 1: String query="select * from prospect order by Model";
			        st=con.createStatement();
					rs=st.executeQuery(query);
					while(rs.next())
					{
						System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8)+"\t"+rs.getString(9));
					}
					break;
			case 2: String query2="select * from prospect order by Hotness";
			        st=con.createStatement();
				    rs=st.executeQuery(query2);
					while(rs.next())
					{
						System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8)+"\t"+rs.getString(9));;
					}
					break;
			case 3: String query3="select * from prospect order by Colour";
			        st=con.createStatement();
					rs=st.executeQuery(query3);
					while(rs.next())
					{
						System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8)+"\t"+rs.getString(9));
					}
					break;
			case 4: String query4="select * from prospect order by Date";
			        st=con.createStatement();
					rs=st.executeQuery(query4);
					while(rs.next())
					{
						System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8)+"\t"+rs.getString(9));
					}
					break;
			case 5: String query5="\nselect * from prospect order by Byid\n";
			        st=con.createStatement();
					rs=st.executeQuery(query5);
					while(rs.next())
					{
						System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8)+"\t"+rs.getString(9));
					}
					break;
			case 6:return;
		}
		}

		
	}
	
	void decAc() throws Exception
	{
		System.out.println("Enter Monitor Id ");
		int id=Integer.parseInt(sc.nextLine());
		String query="select * from monitor where MonitorId="+id;
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next())
		{
		  System.out.println(rs.getString(7));
		}
	}
	
	
	void delPros() throws Exception
	{  
	    
	    System.out.println("\nEnter Id \n");
		int id=Integer.parseInt(sc.nextLine());
		
		String query="\ndelete from prospect where Id="+id;
		Statement st=con.createStatement();
		int result=st.executeUpdate(query);
		if(result>0)
		{
			System.out.println("\n Deleted sucessfully \n");
		}
		else
		{
			System.out.println("Failed!");
		}
	}
	
	void changePs() throws Exception
	{  System.out.println("<----------------->Updation process begins<-----------------?");
		
		 System.out.println("\n Enter Id \n");
		int id=Integer.parseInt(sc.nextLine());
		System.out.println("\n Enter new Password \n");
		String ps=sc.nextLine();
		String query="update admin set Password=? where AdminId=?";
		PreparedStatement pst=con.prepareStatement(query);
			
		pst.setString(1,ps);
		pst.setInt(2,id); 
		int result=pst.executeUpdate();
		if(result>0)
		{
			System.out.println("\n Updated Successfully \n");
		}
		else 
		{
			System.out.println("Failed!!");
		}	
	}
	
	void viewAllMonitor() throws Exception
	{
		System.out.println(" \n\n Enter Admin Id under which monitor is working \n\n");
		int id=sc.nextInt();
		String query="select * from monitor where AdminId="+ id; 
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		  if(rs.next()==false)
		  { 
		    System.out.println("--------------- Monitor Table Is Empty ------------");
		   }
		   else
		   {while(rs.next())
		     {
			   System.out.println(rs.getString(1)+"\t"+rs.getString(2));
			  }
		  }	
	  } 
	  
	  void showAdmin() throws Exception
	  { 
	    
		String query="select * from admin";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		  if(rs.next()==false)
		  {
		  	 System.out.println("--------------- Admin Table Is Empty ------------");
		  }
		  else
		  {
		  	while(rs.next())
			{
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
			}
		  }
	  	
	  }
}

class Login extends Admin
{
	  
	   void registerMonitor() throws Exception
	   {
	    System.out.println("<<<<<<<<<<<<<<<<Monitor Resgistration Begins>>>>>>>>>>>>>>");
	   
		System.out.println("Enter Name: ");
		String name=sc.nextLine();
		System.out.println("Enter Mobile no.: ");
		String mb=sc.nextLine();
		System.out.println("Enter Email: ");
		String email=sc.nextLine();
		System.out.println("Enter Password: ");
		String pass=sc.nextLine();
		System.out.println("Enter Address: ");
		String ad=sc.nextLine();
		System.out.println("Enter Date: ");
		String dt=sc.nextLine();
		System.out.println("Enter Acount Status: ");
		String st=sc.nextLine();
		System.out.println("Enter MnitorId: ");
		int m=Integer.parseInt(sc.nextLine());
		System.out.println("Enter AdminId: ");
		int a=Integer.parseInt(sc.nextLine());
		
		String query = "insert into monitor values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(query);
		pst.setString(1,name);
		pst.setString(2,mb);
		pst.setString(3,email);
		pst.setString(4,pass);
		pst.setString(5,ad);
		pst.setString(6,dt);
		pst.setString(7,st);
		pst.setInt(8,m);
		pst.setInt(9,a);
			
		int result=pst.executeUpdate();
		if(result>0)
		{
			System.out.println("\n\n Monitor Registration Successfull \n\n");
		}
		else
		{
			System.out.println("Failed");
		}
	  }
	
	
	 void adminRegister() throws Exception
	  { 
	    System.out.println("<<<<<<<<<<<<<<<<<<<<Admin Resgistration Begins>>>>>>>>>>>>>>>>>>");
	  
		System.out.println("Enter Admin Id: ");
		int id=Integer.parseInt(sc.nextLine());
		System.out.println("Enter Name: ");
		String name=sc.nextLine();
		System.out.println("Enter Password: ");
		String pass=sc.nextLine();
		System.out.println("Enter Email ID");
		String email=sc.nextLine();
		System.out.println("Enter Address");
		String add=sc.nextLine();
		String query = "insert into admin values(?,?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(query);
		pst.setInt(1,id);
		pst.setString(2,name);
		pst.setString(3,pass);
		pst.setString(4,email);
		pst.setString(5,add);
			
		int result=pst.executeUpdate();
		if(result>0)
		{
			System.out.println("\n\n Admin Registration Successfull \n\n");
		}
		else
		{
			System.out.println("Failed");
		}
	  }
	  
	  
		   void monitorLogin() throws Exception
	        {  Console scan = System.console();
			
	            Monitor m=new Monitor();
			    System.out.println("\n\n Enter Monitor ID \n\n");
		        String id2=sc.nextLine();
		        System.out.println("\n\n Enter Monitor Password\n\n");
		        String ps2=new String(scan.readPassword());
		        
				String query="select * from monitor";//where ='"+id2+"' and='"+ps2+"'" 
		        
				Statement st=con.createStatement();
		        ResultSet rs=st.executeQuery(query);
				boolean status=false;
				while(rs.next())
				{   
				
					if(id2.equals(rs.getString(8)) && ps2.equals(rs.getString(4)))
					{
						
						status = true;
						break;
						
					}
					else
				     {
					   System.out.println("\n\n Either Wrong ID or PASSWORD \n\n");
				      }
				}
				
			    if(status==true)
				{ 
				 System.out.println("\n Login Succesfull!");
				 while(true)	
				 {	 	
				System.out.println("Enter AdminId");
				int aid=Integer.parseInt(sc.nextLine());	
				System.out.println("____________________MONITOR LOGED IN_________________");
				System.out.println("PRESS\n"+" 1.Add new prospect info \n"+"\n2.Update prospect Record\n"+"\n3.Show monitor Details\n"+"\n 4.Update monitor password \n"+"\n 5.Update monitor Mobile no. \n"+"\n 6.Exit\n");
				System.out.println("Enter your choice");
				int n=Integer.parseInt(sc.nextLine());
				switch(n)
				  {
				  case 1:m.prospectRegister();
				  break;
					
				  case 2:m.updateProspectData();
				  break;	
				
				  case 3:m.showMonitor();
				  break;
				
				  case 4:m.updateMonitorPs();
				  break;
				
				  case 5:m.updateMonitorMb();
				  break;
				
				  case 6:return;
				
				  default: System.out.println("____________Invalid option__________");
				  break;
				  }
				}
				}
				
				
			   }
			   
			void adminLogin() throws Exception
			{  
			   Console scan = System.console();
		       Admin a=new Admin();
			   System.out.println(" \n Enter Admin Id \n");
			   String id=sc.nextLine();
			   System.out.println("\n Enter Password \n");
			   String pas=new String(scan.readPassword());
			   
			  String query="select * from admin";
			  Statement st=con.createStatement();
			  ResultSet rs=st.executeQuery(query);
			  boolean status=false;
			  while(rs.next())
			  {
			  	if(id.equals(rs.getString(1)) && pas.equals(rs.getString(3)))
				{
					status=true;
				}
				else
				     {
					   System.out.println("\n\n Either Wrong ID or PASSWORD \n\n");
				      }
			  }
			  if(status==true)
			  { 
			   System.out.println(" \n\n LogIn Succesfully \n\n");
			   while(true)
			   { 
			    
				System.out.println("_______________ADMIN LOGED IN____________");
				System.out.println("PRESS\n"+" 1.Display prospect record \n"+"\n 2.Show Data by Filter \n"+"\n 3.Check Status\n"+"\n 4.Delete Prospect Records \n"+"\n 5.Change password of admin \n"+"\n 6.View all monitor\n"+"\n 7.Show Admin \n"+"\n 8. Exit \n");
			    System.out.println("\n Enter your choice \n");
				int n=Integer.parseInt(sc.nextLine());
				System.out.println("\n\n");
				switch(n)
				{
				  case 1:a.showProspect();
				  break;
					
				  case 2:a.byFilter();
				  break;
				
				  case 3:a.decAc();
				  break;
					
                  case 4:a.delPros();	
				  break;
				 
				  case 5:a.changePs();
				  break;
					
			      case 6:a.viewAllMonitor();
				  break;
				  
				  case 7:a.showAdmin();
				  break;
				  
				  case 8:return;
				  
				  
				  default:System.out.println("____________Invalid option__________");
				  break;
				  
				}
			  }
			}
		   }
		
	
}

class Test
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		Login l=new Login();
		
		
		
		while(true)
		{
		 
		System.out.println("_________________________________________WELCOME TO MAIN MENU___________________________________________");
		System.out.println(" \n Enter 1 to Register as Admin \n"+" \n Enter 2 to Register as Monitor \n"+" \n Enter 3 To Login as Admin \n"+" \n Enter 4 to login as Monitor \n "+" \n Enter 5 to Exit \n\n");
		int q=Integer.parseInt(sc.nextLine());
		switch(q)
	    {  case 1:l.adminRegister();
		   break;
		
		   case 2:l.registerMonitor();
		   break;
		   
	       case 3:l.adminLogin();
		   break;   
	   
		   case 4:l.monitorLogin();
		   break;      
			      
		   case 5:System.out.println("___________________________________THANK YOU FOR VISITING____________________________________");
		            return;
		 
		   default:System.out.println("Invalid choice ");
		   break;
			
		}
		
	
		}
    }
}
		
		//l.prospectRegister();
		//l.updateProspectData();
		//l.showMonitor();
		//l.updateMonitorPs();
		//l.updateMonitorMb();
		//l.showProspect();
		//l.byFilter();
		//l.delPros();
		//l.changePs();
		//l.viewAllMonitor();
		//l.registerMonitor();
		//l.adminRegister();
		//var:
		

		
	