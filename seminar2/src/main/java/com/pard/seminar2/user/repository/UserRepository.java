package com.pard.seminar2.user.repository;

import com.pard.seminar2.user.dto.UserDto;
import com.pard.seminar2.user.entity.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
        private static final Map<Long,User> handong = new HashMap<>();//db를 안써서 지금 저장할려고 넣었음

        public void save(UserDto userDto){
            User user = User.builder()// 객체 자동 생성
                    .studentID(userDto.getStudentID())
                    .studentName(userDto.getStudentName())
                    .build();
            handong.put(userDto.getStudentID(),user);

    }
    public UserDto findByID(Long studentID){

            User user = handong.get(studentID);//ID가 있는지 확인
            //option 없으면 error
            return UserDto.builder()
                    .studentID(user.getStudentID())
                    .studentName(user.getStudentName())
                    .build();
    }
    public void updateByID(Long studentID, UserDto userDto) {
            User user = handong.get(studentID);

            user.setStudentID(userDto.getStudentID());//entitiy에서는 setter 쓰면 안됨
            user.setStudentName(userDto.getStudentName());//만약에 postman으로 돌리면 실제로는 바뀌지 않지만 화면은 바뀐걸로 나옴
        //만약에 실제로

    }
    public void delete(Long studentID) {
            handong.remove(studentID);
    }
    public List<UserDto> findAll(){
            return handong.values().stream()//string 값을 잘라서 db 넣어야 함
                    .map(user -> UserDto.builder()//lamda 하나씩 잘라서 넣음
                            .studentID(user.getStudentID())
                            .studentName(user.getStudentName())
                            .build()).toList();
    }
}
