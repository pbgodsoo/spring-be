package org.example.springbe.board.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class BoardDto {
    @Getter
    public static class RegReq {
        private String title;
        private String contents;

        public Board toEntity() {
            return Board.builder()
                    .title(this.title)
                    .contents(this.contents)
                    .build();
        }
    }

    @Getter
    public static class UpdateReq {
        private String title;
        private String contents;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BoardListRes{
        private Long idx;
        private String title;

        public static BoardListRes toListDto(Board entity) {
            return BoardListRes.builder()
                    .idx(entity.getIdx())
                    .title(entity.getTitle())
                    .build();
        }
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BoardDetailRes{
        private Long idx;
        private String title;
        private String contents;

        public static BoardDetailRes toDetailDto(Board entity) {
            return BoardDetailRes.builder()
                    .idx(entity.getIdx())
                    .title(entity.getTitle())
                    .contents(entity.getContents())
                    .build();
        }
    }
}
