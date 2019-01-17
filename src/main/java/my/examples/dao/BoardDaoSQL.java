package my.examples.dao;

public class BoardDaoSQL {
    public static final String SELECT_BY_ID =
            "SELECT seq,user_id,user_name,title,content,pr_no,re_depth,re_ord,reg_date,hit,del_yn FROM board where seq = ?";

    public static final String SELECT_BY_PAGING =
            "SELECT seq,user_id, user_name,title, content,pr_no,re_depth,re_ord, reg_date, hit,del_yn FROM board ORDER BY seq DESC LIMIT ?, ?";

    public static final String INSERT =
            "INSERT INTO board(user_id,user_name,title,content) VALUES (?,?,?,?)";

    public static final String UPDATE =
            "UPDATE board SET hit = hit + 1 WHERE seq = ?";

    public static final String DELETE =
            "DELETE FROM board WHERE seq = ?";

    public static final String MODIFY =
            "UPDATE board SET title=?, content=? WHERE seq=?";
}
