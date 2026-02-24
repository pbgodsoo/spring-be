package org.example.springbe.board;

import lombok.RequiredArgsConstructor;
import org.example.springbe.board.model.Board;
import org.example.springbe.board.model.BoardDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void register(BoardDto.RegReq dto) {
        Board board = dto.toEntity();
        boardRepository.save(board);
    }
}
