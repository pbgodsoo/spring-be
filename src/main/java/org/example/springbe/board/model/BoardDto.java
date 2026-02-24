package org.example.springbe.board.model;

import lombok.Getter;

public class BoardDto {
    @Getter
    public static class RegReq {
        private String title;
        private String contents;

        public Board toEntity() {
            return Board.builder()
                    .title(this.title)
                    .contents(this.title)
                    .build();
        }
    }
}
