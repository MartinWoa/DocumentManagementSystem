package System;

import java.sql.*;
import com.hxtt.sql.access.*;  //���� ������ɾ��
public  class CreatConnect {
	static private String connectway="jdbc:Access:///information.mdb";
    private  Connection con;
    CreatConnect()
    {
    	try {
    		
			con=DriverManager.getConnection(connectway);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    Connection getConnection()
    {
    	return con;
    }
    void setconnectway(String way)
    {
    	this.connectway=way;
    }
    String getConnectWay()
    {
    	return this.connectway;
    }


}
