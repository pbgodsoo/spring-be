package org.example.springbe.board;

import lombok.RequiredArgsConstructor;
import org.example.springbe.board.model.BoardDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody BoardDto.RegReq dto) {
        boardService.register(dto);
        return ResponseEntity.ok("성공");
    }
}
