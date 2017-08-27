package System;

import java.sql.*;
import com.hxtt.sql.access.*;  //���� ������ɾ��
public  class CreatConnect {
	static private String connectway="jdbc:Access:///information.mdb";
    private static  Connection con;
    static private CreatConnect uniqueConnect;
    static Connection  getConnect()
    {
    	if(uniqueConnect==null)
    	{
    		uniqueConnect=new CreatConnect();
    	}
    	return con;
    	
    }
    private CreatConnect()
    {
    	try {
    		
			con=DriverManager.getConnection(connectway);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    static void setconnectway(String way)
    {
    	connectway=way;
    }
    static String getConnectWay()
    {
    	return connectway;
    }


}
