package com.pard.seminar3.user.service;

import com.pard.seminar3.user.dto.UserDto;
import com.pard.seminar3.user.entity.User;
import com.pard.seminar3.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public void save(UserDto userDto){
        User user = User.builder()
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build();
        userRepo.save(user);
    }

    public UserDto read(Long userId){
        User user = userRepo.findById(userId).get();
        return UserDto.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
    public Long getUserNum(String email){
        User user = userRepo.findByEmail(email);
        return user.getUserId();
    }
    public List<UserDto> readAll(){
        List<User> users = userRepo.findAll();
        List<UserDto> userDtos = users.stream().map(user -> //자동으로 하나로 잘라줌
                UserDto.builder()
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .build()).toList();
        return userDtos;
    }
    @Transactional // spring으로 하기 증긴에 하다가 끊으면 100%안되면 남아있지 말고 다시 돌아가라,공부해보기
    //너무 큰걸돌리면 과부화고 작게 작게 롤백시키는게 좋음
    public void update(Long userId,UserDto userDto){
        User user= userRepo.findById(userId).get();//get 있을지 없을지 모르잖아
        //ispresent
        //Setter하면 계좌번호 바뀌면 안되는데 바뀔수도 있음
        //그래서 이렇게 따로 Entity에서 public한 함수로 처리를 하는거 필요한거만 할 수 있게
        user.updateEmail(userDto.getEmail());
        user.updatePassword(userDto.getPassword());
        //하나씩 안만들고 null이면 원래대로 넣고 아니면 바꾸는 걸로 함수 하나 만들면 됨(이렇게 많이 함)
        userRepo.save(user);
    }
    //reop.delete()
}
