package my.examples.dao;

import my.examples.dto.Board;

import java.util.List;

public interface BoardDao {
  // public Board getBoard(Long user_id);
  public Board getBoard(Integer seq);
    public List<Board> getBoards(int start, int limit);

    void addBoard(Board board);

    void deleteBoard(int seq);

    void updateReadCount(int  seq);
    }



