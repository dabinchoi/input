package my.examples.service;

import my.examples.dao.BoardDao;
import my.examples.dao.BoardDaoImpl;
import my.examples.dto.Board;
import my.examples.util.ConnectionContextHolder;
import my.examples.util.DBUtil;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class BoardServiceImpl implements BoardService{
    public static final int SIZE = 10;

    @Override
    public List<Board> getBoards(int page) {
        BoardDao boardDao = new BoardDaoImpl();
        int start = page * SIZE -SIZE;
        int limit = SIZE;

        Connection conn = null;
        List<Board> boards = new ArrayList<>();
        try {
            conn = DBUtil.getInstance().getConnection();
            ConnectionContextHolder.setConnection(conn);
            boards = boardDao.getBoards(start, limit);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            DBUtil.close(conn);
        }
        return boards;
    }

    @Override
    public Board getBoard(int seq) {


        Board board = null;
        Connection conn = null;
        BoardDao boardDao = new BoardDaoImpl();
        try {
            conn = DBUtil.getInstance().getConnection();
            ConnectionContextHolder.setConnection(conn);
            board = boardDao.getBoard(seq);
            boardDao.updateReadCount(seq);
            conn.commit(); // 트랜젝션 commit
        }catch(Exception ex){
            DBUtil.rollback(conn);
            ex.printStackTrace();
        }finally {
            DBUtil.close(conn);
        }
        return board;
    }

    @Override
    public void deleteBoard(int seq) {

        Connection conn = null;
        BoardDao boardDao = new BoardDaoImpl();
        try {
            conn = DBUtil.getInstance().getConnection();
            ConnectionContextHolder.setConnection(conn);
            boardDao.deleteBoard(seq);
            conn.commit(); // 트랜젝션 commit
        }catch(Exception ex){
            DBUtil.rollback(conn);
            ex.printStackTrace();
        }finally {
            DBUtil.close(conn);
        }
    }
}
