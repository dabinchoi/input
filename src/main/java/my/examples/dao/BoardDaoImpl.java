package my.examples.dao;

import my.examples.dto.Board;
import my.examples.util.DBUtil;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDaoImpl implements BoardDao {
    @Override
    public Board getBoard(Integer idParam) {
        Board board = null; // return할 타입을 선언한다.

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // a. DB 연결 - Connection
            //    DB연결을 하려면 필요한 정보가 있다. Driver classname, DB URL, DB UserId , DB User Password
            conn = DBUtil.getInstance().getConnection();

            // b. SELECT SQL 준비 - Connection
            //  String sql = "select seq,id,user_name,title,content,pr_no,re_depth,re_ord,reg_date,hit,del_yn from board LEFT JOIN user.id=board.user_id where user_id =?";
            //  String sql = "select seq,user_id,user_name,title,content,pr_no,re_depth,re_ord,reg_date,hit,del_yn,user_id where user_id =?";
            //  String sql = "select seq,user_id,user_name,title,content,reg_date,hit where user_id =?";


            //    String sql = "SELECT id, title, content, name, regdate, read_count FROM board ORDER BY id DESC LIMIT ?, ?";
            String sql = "SELECT seq,user_id,user_name,title,content,pr_no,re_depth,re_ord,reg_date,hit,del_yn FROM board where seq = ?";
            //  System.out.println(sql);
            // String sql = "select seq,user_id,user_name,title,content,pr_no,re_depth,re_ord,reg_date,hit,del_yn from board where id = ? ";


            ps = conn.prepareStatement(sql);
            // c. 바인딩 - PreparedStatement
            ps.setInt(1, idParam); // 첫번째 물음표에 5를 바인딩한다.

            // d. SQL 실행 - PreparedStatement
            rs = ps.executeQuery(); // SELECT 문장을 실행, executeUpdate() - insert, update, delete

            // e. 1건의 row를 읽어온다. row는 여러개의 컬럼으로 구성되어 있다. - ResultSet
            // f. e에서 읽어오지 못하는 경우도 있다.
            if (rs.next()) {
                int seq = rs.getInt(1);
                String user_id = rs.getString(2);
                String user_name = rs.getString(3);
                String title = rs.getString(4);
                String content = rs.getString(5);
                //   int pr_no = rs.getInt(6);
                // int re_depth = rs.getInt(7);
                //int re_ord = rs.getInt(8);
                Date reg_date = rs.getDate(6);
                int hit = rs.getInt(7);
                // String del_yn = rs.getString(11);


                board = new Board(seq, user_id, title, content, user_name, reg_date, hit);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // g. ResultSet, PreparedStatement, Connection 순으로 close를 한다.
            DBUtil.close(rs, ps, conn);
        }

        return board;
    }

    @Override
    public List<Board> getBoards(int start, int limit) {
        List<Board> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // a. DB 연결 - Connection
            //    DB연결을 하려면 필요한 정보가 있다. Driver classname, DB URL, DB UserId , DB User Password
            conn = DBUtil.getInstance().getConnection();
            if (conn != null) {
                System.out.println("conn ok!");
                System.out.println(conn.getClass().getName());
            }
            // b. SELECT SQL 준비 - Connection
            String sql = "SELECT seq,user_id, user_name,title, content,pr_no,re_depth,re_ord, reg_date, hit,del_yn FROM board ORDER BY seq DESC LIMIT ?, ?";
            ps = conn.prepareStatement(sql);
            // c. 바인딩 - PreparedStatement
            ps.setInt(1, start); // 첫번째 물음표에 5를 바인딩한다.
            ps.setInt(2, limit);

            // d. SQL 실행 - PreparedStatement
            rs = ps.executeQuery(); // SELECT 문장을 실행, executeUpdate() - insert, update, delete

            // e. 1건의 row를 읽어온다. row는 여러개의 컬럼으로 구성되어 있다. - ResultSet
            // f. e에서 읽어오지 못하는 경우도 있다.
            while (rs.next()) {
                int seq = rs.getInt(1);
                String user_id = rs.getString(2);
                String user_name = rs.getString(3);
                String title = rs.getString(4);
                String content = rs.getString(5);
                int pr_no = rs.getInt(6);
                int re_depth = rs.getInt(7);
                int re_ord = rs.getInt(8);
                Date reg_date = rs.getDate(9);
                int hit = rs.getInt(10);
                String del_yn = rs.getString(11);

                Board board = new Board(seq, user_id, title, content, user_name, reg_date,hit);
                list.add(board);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // g. ResultSet, PreparedStatement, Connection 순으로 close를 한다.
            DBUtil.close(rs, ps, conn);
        }
        return list;
    }

    @Override
    public void addBoard(Board board) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getInstance().getConnection();
            //  String sql = "INSERT INTO board(seq,title, user_name, content,reg_date) VALUES(?, ?, ?)";
            String sql = "INSERT INTO board(user_id,user_name,title,content) VALUES (?,?,?,?)";


            ps = conn.prepareStatement(sql);


            ps.setString(1, board.getUesr_id());
            ps.setString(2, board.getUser_name());
            ps.setString(3, board.getTitle());
            ps.setString(4, board.getContent());

            ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.close(ps, conn);
        }
    }

    @Override
    public void deleteBoard(int seq) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getInstance().getConnection();
            String sql = "DELETE FROM board WHERE seq = ?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, seq);
            ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.close(ps, conn);
        }
    }


    @Override
    public void updateReadCount(int seq) {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DBUtil.getInstance().getConnection();
            String sql = "UPDATE board SET hit = hit + 1 WHERE seq = ?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, seq);
            ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            DBUtil.close(ps, conn);
        }
    }
}