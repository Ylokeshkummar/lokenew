//SelectTest2.java
package com.nt.jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.SQLException;

class SelectTest2
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try{
			sc=new Scanner(System.in);
			String initChar=null;
			if(sc!=null){
				System.out.println("Enter Initial characther of the emp Name");
				initChar=sc.next();
				initChar="'"+initChar+"%'";
			}//ifend
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Mom@1434");
		if(con!=null){
		st=con.createStatement();
		}//ifend
		if(st!=null){
		rs=st.executeQuery("SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE ENAME LIKE"+initChar+"ORDER BY ENAME");
		}//if end
		if(rs!=null){
			boolean isRsEmpty=true;
		while(rs.next()!=false){
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getDouble(4)+" "+rs.getInt(5));
			isRsEmpty=false;
		}//whileend
		if(isRsEmpty){
			System.out.println("Records Not Found");
		}//ifend
		else{
			System.out.println("Record Found and Displayed");
		}//else end
		}//ifend
		}//tryend
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf){
			cnf.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
		try{
			if(rs!=null){
			rs.close();
			}
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		try{
			if(st!=null){
			st.close();
			}
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		try{
			if(con!=null){
			con.close();
			}
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		try{
			if(sc!=null){
			sc.close();
			}
		}
		catch(Exception se){
			se.printStackTrace();
		}
		
	}
}
}
