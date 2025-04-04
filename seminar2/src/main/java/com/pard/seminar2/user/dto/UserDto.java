package com.pard.seminar2.user.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    //그때그때마다 필요한 Dto 만들어야 해서 많아짐
    //한번에 다 넣어도 되지만 너무 용량이 커짐
    //DTO이름도 명확하게 하는게 나중에 좋음(next schedule,schedule)
    private Long studentID;// 애만 넘기겠다, 그래서 프론트에서 뭐가 필요한 정보들인지 물어봐야 함, 다른 불필요한 것 줄 필요 없으니깐
    private String studentName;
}


//studentName
//
//builder build 사이 넣으면 객체 생성
