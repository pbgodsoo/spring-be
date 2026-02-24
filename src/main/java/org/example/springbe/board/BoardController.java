package org.example.springbe.board;

import lombok.RequiredArgsConstructor;
import org.example.springbe.board.model.BoardDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/list")
    public ResponseEntity list() {
        List<BoardDto.BoardListRes> result = boardService.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{idx}")
    public ResponseEntity BoardListRes(@PathVariable Long idx) {
        BoardDto.BoardDetailRes result = boardService.findByIdx(idx);
        return ResponseEntity.ok(result);
    }
}
