package CGV_HS;


import java.sql.*;
import java.io.IOException;
import java.util.Vector;

/**
 * DB Ŭ����
 *    ���� MySQL DBMS�� �����ϰ� DB ���̺��� ���� �� �˻��� ���� �޼ҵ带 ���� Ŭ����
 *    
 *    DBMS ����, ���̺� ���� ó�� ��û�� ��� public static �޼ҵ�� �����ǹǷ� 
 *    �ٸ� Ŭ�������� DB Ŭ������ �޼ҵ带 ȣ���� �� �����ڴ� DB�̴�.
 *    
 */

public class DB {
  
	static  Connection con         = null;
    static  Statement stmt         = null;
    static  ResultSet rs           = null ;
    
    static String driver= "com.mysql.jdbc.Driver";
    static String URL = "jdbc:mysql://localhost:3306/cgv_hs" ;;


	public static void loadConnect()  {
		try {
			// ������ �ݴ´�.
			if( stmt != null ) stmt.close();
			if( con != null ) con.close();
		} catch (SQLException ex ) {};  

		// ����̹� �ε�
		try {
			Class.forName(driver);

		} catch ( java.lang.ClassNotFoundException e ) {
			System.err.println("** Driver loaderror in loadConnect: " + e.getMessage() );
			e.printStackTrace();

		}

		try {

			// �����ϱ�
			con  = DriverManager.getConnection(URL, "root", "onlyroot");

			System.out.println("\n"+URL+"�� �����");


		} catch( SQLException ex ) 
		{

			System.err.println("** connection error in loadConnect(): " + ex.getMessage() );
			ex.printStackTrace();
		}	   

	}

	public static void disconnect()  {
		try {
			// ������ �ݴ´�.
			if( stmt != null ) stmt.close();
			if( con != null ) con.close();
		} catch (SQLException ex ) {};    
	}

	public static ResultSet selectQuery(String sql) { 
		try {
			// Statement ���� 
			stmt = con.createStatement();


			rs = stmt.executeQuery(sql);  

		} catch( SQLException ex ) 	    {
			System.err.println("** SQL exec error in selectQuery() : " + ex.getMessage() );
		}

		return rs;

	}

	public static int updateQuery(String sql) { 
		int count;

		try {
			// Statement ���� 
			stmt = con.createStatement();
			count = stmt.executeUpdate(sql);  
			return count;

		} catch( SQLException ex ) 	    {
			System.err.println("** SQL exec error in updateQuery() : " + ex.getMessage() );
			return 0;
		}	
	}


	//��� ���Ե� �ҷ����� ->(��+������)
	public static ResultSet selectAllMember() {
		String sql = "select * from member;";
		System.out.println("   >> SQL : " + sql + "\n");

		return selectQuery(sql);
	}

	//��� �������� �ҷ�����
	public static ResultSet selectAllCustomer() {
		String sql = "select * from member where member.memberno like 'c%';";
		System.out.println("   >> SQL : " + sql + "\n");

		return selectQuery(sql);
	}
	
	//������ ���� �ҷ�����
	public static ResultSet selectAllManager() {
		String sql = "select * from member where member.memberno like 'm%';";
		System.out.println("   >> SQL : " + sql + "\n");

		return selectQuery(sql);
	}

	
	public static ResultSet selectMember(String memberno) {
		String sql = "select * from member where memberno = " + memberno + " ;";
		System.out.println("   >> SQL : " + sql + "\n");

		return selectQuery(sql);
	}

	public static ResultSet selectMemberofID(String ID) {
		// �� �־��� ID�� ���� �� �˻�
		String sql = "select memberno, ID, name from member where ID = '"+ID+"' and memberno like 'c%';";
		System.out.println("   >> SQL : " + sql + "\n");

		return selectQuery(sql);
	}

}

