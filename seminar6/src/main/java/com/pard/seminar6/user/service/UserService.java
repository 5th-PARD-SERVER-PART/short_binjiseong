package com.pard.seminar6.user.service;

import com.pard.seminar6.user.dto.UserReqDto;
import com.pard.seminar6.user.dto.UserResDto;
import com.pard.seminar6.user.entity.User;
import com.pard.seminar6.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public void save(UserReqDto userReqDto){
        User user = User.builder()
                .name(userReqDto.getName())
                .age(userReqDto.getAge())
                .part(userReqDto.getPart())
                .build();
        userRepo.save(user);
    }
//    public List<UserResDto> readAll(){
//        List<User> users = userRepo.findAll();
//        List<UserResDto> userResDto = users.stream().map(user ->
//                UserResDto.builder()
//                        .id(user.getId())
//                        .name(user.getName())
//                        .age(user.getAge())
//                        .part(user.getPart())
//                        .build()).toList();
//        return userResDto;
//    }

    public List<UserResDto> readByPart(String part) {
        if(part.equals("all")){
            List<User> users = userRepo.findAll();
            List<UserResDto> userResDto = users.stream().map(user ->
                    UserResDto.builder()
                            .id(user.getId())
                            .name(user.getName())
                            .age(user.getAge())
                            .part(user.getPart())
                            .build()).toList();
            return userResDto;
        }
        else {
            List<User> users = userRepo.findByPart(part);
            List<UserResDto> userResDto = users.stream().map(user ->
                    UserResDto.builder()
                            .id(user.getId())
                            .name(user.getName())
                            .age(user.getAge())
                            .part(user.getPart())
                            .build()).toList();
            return userResDto;
        }

    }
    @Transactional
    public void updateById(int id, UserReqDto userReqDto){
        User user = userRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 순서의 사용자를 찾을 수 없습니다. ID: " + id));

        user.update(userReqDto);
        userRepo.save(user); // 이게 없으면 DB에 저장 안됨!!!
    }
    @Transactional
    public void deleteById(int id) {
        userRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 순서의 사용자를 찾을 수 없습니다. ID: " + id));

        userRepo.deleteById(id);
    }


}
