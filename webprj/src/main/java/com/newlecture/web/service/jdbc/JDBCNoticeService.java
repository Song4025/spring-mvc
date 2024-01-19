package com.newlecture.web.service.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

public class JDBCNoticeService implements NoticeService{

    public List<Notice> getList(int page, String field, String query) throws ClassNotFoundException, SQLException{

    String url = "jdbc:oracle:thin:@localhost:1521/xe";
    String sql = "SELECT * FROM NOTICE";

    // JDBC 드라이버 로드
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con = DriverManager.getConnection(url, "SONG", "gjgkgl135");
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery(sql);

    List<Notice> list = new ArrayList<Notice>();
    
    while (rs.next()) {
        int id = rs.getInt("ID");
        String title = rs.getString("TITLE");
        String writer_id = rs.getString("WRITER_ID");
        Date regdate = rs.getDate("REGDATE");
        String content = rs.getString("CONTENT");
        int hit = rs.getInt("HIT");

        Notice notice = new Notice(
        		id,
        		title,
        		writer_id,
        		regdate,
        		content,
        		hit
        		);
        
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

}