package idusw.springboot.service;

import idusw.springboot.domain.Board;

import java.util.List;

public interface BoardService {
    int registerBoard(Board board);
    Board findBoardById(Board board);
    List<Board> findBoardAll();
    int updateBoard(Board board);
    int deleteBoard(Board board);
}
