package idusw.springboot.service;

import idusw.springboot.domain.Board;
import idusw.springboot.domain.PageRequestDTO;
import idusw.springboot.entity.BoardEntity;
import idusw.springboot.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

    private BoardRepository boardRepository;

    @Override
    public int registerBoard(Board board) {
        BoardEntity entity = dtoToEntity(board);

        if (boardRepository.save(entity) != null) {
            return 1;
        } else {
            return 0;
        }

    }

    @Override
    public Board findBoardById(Board board) {
        return null;
    }

    @Override
    public List<Board> findBoardAll(PageRequestDTO pageRequestDTO) {
        return null;
    }

    @Override
    public int updateBoard(Board board) {
        return 0;
    }

    @Override
    public int deleteBoard(Board board) {
        return 0;
    }
}
