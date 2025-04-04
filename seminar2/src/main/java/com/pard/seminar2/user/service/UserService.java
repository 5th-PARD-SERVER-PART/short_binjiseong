package com.pard.seminar2.user.service;

import com.pard.seminar2.user.dto.UserDto;
import com.pard.seminar2.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // final 생성자
public class UserService {
    private final UserRepository userRepository;

    public void saveUser(UserDto userDto) {
        userRepository.save(userDto);
    }
    public UserDto findByID(Long studentID) {
        return userRepository.findByID(studentID);
    }
    public void updateByID(Long studentID, UserDto userDto) {//바꿀 정보들 userDto 로 받음
        userRepository.updateByID(studentID,userDto);
    }
    public void delete(Long studentID) {
        userRepository.delete(studentID);
    }
    public List<UserDto> findAll(){
        return userRepository.findAll();
    }
}
