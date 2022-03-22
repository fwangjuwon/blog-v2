package site.metacoding.blogv2.web.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDto<T> {

    private Integer code; // -1: 실패, 1: 성공
    private String msg;
    private T data;
}
