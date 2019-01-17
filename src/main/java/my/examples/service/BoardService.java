package my.examples.service;

import my.examples.dto.Board;

import java.util.List;

public interface BoardService {
    // page에 해당하는 목록을 읽어온다.
    // 전체 건수를 읽어온다.
    // 글을 읽어온다.(글읽기 + 조회수 증가)
    // 글을 삭제
    public List<Board> getBoards(int page);

    public Board getBoard(int seq);



    public void deleteBoard(int seq);

    public void addBoard(Board board);
   public  int modifyCount(int seq,String title, String content);

}
