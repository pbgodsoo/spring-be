package org.example.springbe.board;

import lombok.RequiredArgsConstructor;
import org.example.springbe.board.model.Board;
import org.example.springbe.board.model.BoardDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void register(BoardDto.RegReq dto) {
        Board board = dto.toEntity();
        boardRepository.save(board);
    }

    public List<BoardDto.BoardListRes> findAll() {
        List<Board> entityList = boardRepository.findAll();
        return entityList.stream().map(BoardDto.BoardListRes::toListDto).toList();
    }

    public BoardDto.BoardDetailRes findByIdx(Long idx) {
        Board entity = boardRepository.findById(idx).orElseThrow();
        return BoardDto.BoardDetailRes.toDetailDto(entity);
    }
}
