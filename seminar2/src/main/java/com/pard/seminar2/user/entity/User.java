package com.pard.seminar2.user.entity;

import lombok.*;

@Getter//public이 아니라 studentID이런 거 못 가져오는데 이거는 알아서 해줌 이런 거
@Setter//class 외부에서 데이터 접근할 수 있게 해줌, 수정
@NoArgsConstructor//아무것도 없어도 되는 생성자
@AllArgsConstructor//변수 받는 생성자
@Builder

public class User {
    //db 그자체로 생각 이거 실행하면 User table 생성됨
    private long studentID;
    private String studentName;

}
//따로 업데이트 함수 써서 업데이트시킴,setter를 쓰지는 않음