package my.examples.exam;



import my.examples.util.DBUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;

public class TransactionExam {
    public static void main(String[] args) {
        Connection conn = null;

        try {
            conn = DBUtil.getInstance().getConnection();
            conn.setAutoCommit(false);
            // 여러개의 sql이 실행
            String sql = "insert into board (user_name,user_id,title, content, name) values ('123','ttt333', 'ttt333', 'kim')";
            try(PreparedStatement ps = conn.prepareStatement(sql);) {
                ps.executeUpdate();
                ps.clearParameters();
                if (1 == 1) throw new RuntimeException("-_-;");
                ps.executeUpdate();
                ps.clearParameters();
            }
            conn.commit();
        }catch(Exception ex){
            try{ conn.rollback(); }catch(Exception ignore){}
            ex.printStackTrace();
        }finally{
            DBUtil.close(conn);
        }
    }
}
