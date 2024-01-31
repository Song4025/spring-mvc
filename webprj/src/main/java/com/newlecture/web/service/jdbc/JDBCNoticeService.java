package com.newlecture.web.service.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

//@Component  범용적으로 사용하는녀석임 의미론적으로는??? @Controller, @Service, @Repository
@Service
public class JDBCNoticeService implements NoticeService {

	@Autowired
	private DataSource dataSource;
 
	/*
	 * public void setDataSource(DataSource dataSource) { this.dataSource =
	 * dataSource; }
	 */
	
	public List<Notice> getList(int page, String field, String query) throws ClassNotFoundException, SQLException {

		int start = 1 + (page-1)*10; // 1, 11, 21, 31....
		int end = 10*page; // 10, 20, 30, 40....
		
		String sql = "SELECT * FROM NOTICE_VIEW WHERE "+field+" LIKE ? AND NUM BETWEEN ? AND ?";
//				"SELECT * FROM ("
//				+ "SELECT ROWNUM NUM, N.* FROM ("
//				+ "SELECT * FROM NOTICE ORDER BY REGDATE DESC"
//				+ ") N"
//				+ ")"
//				+ "WHERE NUM BETWEEN ? AND ?";
				
				
		// JDBC 드라이버 로드
		// Class.forName(driver);
		// Connection con = DriverManager.getConnection(url, uid, pw);
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+query+"%");
		st.setInt(2, start);
		st.setInt(3, end);
		ResultSet rs = st.executeQuery();

		List<Notice> list = new ArrayList<Notice>();

		while (rs.next()) {
			String id = rs.getString("ID");
			String title = rs.getString("TITLE");
			String writer_id = rs.getString("WRITER_ID");
			Date regDate = rs.getDate("REGDATE");
			String content = rs.getString("CONTENT");
			int hit = rs.getInt("HIT");
			// String files = rs.getString("FILES");

			Notice notice = new Notice(id, title, writer_id, regDate, content, hit);

			list.add(notice);
		}

		rs.close();
		st.close();
		con.close();

		return list;

	}

	@Override
	public int getCount() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Notice notice) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Notice notice) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Notice id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	
//	public int getCount() throws ClassNotFoundException, SQLException {
//		int count = 0;
//
//		String sql = "SELECT COUNT(ID) COUNT FROM NOTICE";
//		
//		Connection con = dataSource.getConnection();
//		Statement st = con.createStatement();
//		
//		ResultSet rs = st.executeQuery(sql);
//
//		if(rs.next()) 
//			count = rs.getInt("COUNT");
//
//		rs.close();
//		st.close();
//		con.close();
//
//		return count;
//	}
//
//	public int insert(Notice notice) throws ClassNotFoundException, SQLException {
//		String title = notice.getTitle();
//		String writerId = notice.getWriter_id();
//		String content = notice.getContent();
//		//String files = notice.getFiles();
//
//		String sql = "INSERT INTO notice (" + "    title," + "    writer_id," + "    content," + "    files"
//				+ ") VALUES (?,?,?,?)";
//
//		Connection con = dataSource.getConnection();
//		PreparedStatement st = con.prepareStatement(sql);
//		st.setString(1, title);
//		st.setString(2, writerId);
//		st.setString(3, content);
//		//st.setString(4, files);
//
//		int result = st.executeUpdate();
//		st.close();
//		con.close();
//
//		return result;
//	}
//
//	public int update(Notice notice) throws ClassNotFoundException, SQLException {
//		String title = notice.getTitle();
//		String content = notice.getContent();
//		//String files = notice.getFiles();
//		String id = notice.getId();
//
//		String sql = "UPDATE NOTICE " + "SET " + "    TITLE = ?," + "    CONTENT = ?," + "    FILES = ?"
//				+ "WHERE ID = ?";
//
//		Connection con = dataSource.getConnection();
//		PreparedStatement st = con.prepareStatement(sql);
//		st.setString(1, title);
//		st.setString(2, content);
//		//st.setString(3, files);
//		st.setString(3, id);
//
//		int result = st.executeUpdate();
//		st.close();
//		con.close();
//
//		return result;
//	}
//
//	public int delete(Notice notice) throws ClassNotFoundException, SQLException {
//
//		String id = notice.getId();
//		String sql = "DELETE NOTICE WHERE ID=?";
//
//		Connection con = dataSource.getConnection();
//		PreparedStatement st = con.prepareStatement(sql);
//		st.setString(1, id);
//
//		int result = st.executeUpdate();
//
//		st.close();
//		con.close();
//
//		return result;
//	}

}