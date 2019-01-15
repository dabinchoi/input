package my.examples.exam;

import my.examples.dao.BoardDao;
import my.examples.dao.BoardDaoImpl;
import my.examples.dto.Board;

import java.util.List;


// 1건의 데이터를 요청하는 경우
// 조건에 해당하는 데이터가 없을 수 있다.
public class SelectOneExam {
    public static void main(String[] args){
        BoardDao boardDao = new BoardDaoImpl();
        Board board = boardDao.getBoard(5);
        System.out.println(board);
    }
}
