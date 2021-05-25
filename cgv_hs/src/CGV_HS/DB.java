package CGV_HS;


import java.sql.*;
import java.io.IOException;
import java.util.Vector;

/**
 * DB 클래스
 *    실제 MySQL DBMS와 연결하고 DB 테이블의 저장 및 검색을 위한 메소드를 갖는 클래스
 *    
 *    DBMS 연결, 테이블에 대한 처리 요청은 모두 public static 메소드로 구현되므로 
 *    다른 클래스에서 DB 클래스의 메소드를 호출할 때 수신자는 DB이다.
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
			// 연결을 닫는다.
			if( stmt != null ) stmt.close();
			if( con != null ) con.close();
		} catch (SQLException ex ) {};  

		// 드라이버 로딩
		try {
			Class.forName(driver);

		} catch ( java.lang.ClassNotFoundException e ) {
			System.err.println("** Driver loaderror in loadConnect: " + e.getMessage() );
			e.printStackTrace();

		}

		try {

			// 연결하기
			con  = DriverManager.getConnection(URL, "root", "onlyroot");

			System.out.println("\n"+URL+"에 연결됨");


		} catch( SQLException ex ) 
		{

			System.err.println("** connection error in loadConnect(): " + ex.getMessage() );
			ex.printStackTrace();
		}	   

	}

	public static void disconnect()  {
		try {
			// 연결을 닫는다.
			if( stmt != null ) stmt.close();
			if( con != null ) con.close();
		} catch (SQLException ex ) {};    
	}

	public static ResultSet selectQuery(String sql) { 
		try {
			// Statement 생성 
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
			// Statement 생성 
			stmt = con.createStatement();
			count = stmt.executeUpdate(sql);  
			return count;

		} catch( SQLException ex ) 	    {
			System.err.println("** SQL exec error in updateQuery() : " + ex.getMessage() );
			return 0;
		}	
	}


	//모든 고객님들 불러오기 ->(고객+관리자)
	public static ResultSet selectAllMember() {
		String sql = "select * from member;";
		System.out.println("   >> SQL : " + sql + "\n");

		return selectQuery(sql);
	}

	//모든 고객정보만 불러오기
	public static ResultSet selectAllCustomer() {
		String sql = "select * from member where member.memberno like 'c%';";
		System.out.println("   >> SQL : " + sql + "\n");

		return selectQuery(sql);
	}
	
	//관리자 정보 불러오기
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
		// 고객 주어진 ID에 대한 고객 검색
		String sql = "select memberno, ID, name from member where ID = '"+ID+"' and memberno like 'c%';";
		System.out.println("   >> SQL : " + sql + "\n");

		return selectQuery(sql);
	}

}

