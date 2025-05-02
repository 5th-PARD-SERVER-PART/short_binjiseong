package com.pard.hw4.user.service;

import com.pard.hw4.post.dto.ResponsePostDto;
import com.pard.hw4.post.entity.Post;
import com.pard.hw4.user.dto.RequestUserDto;
import com.pard.hw4.user.dto.ResponseUserDto;
import com.pard.hw4.user.entity.User;
import com.pard.hw4.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<ResponseUserDto.ReadAllUser> readAll() {
        List<User> users = userRepository.findAll();
        List<ResponseUserDto.ReadAllUser> p = users.stream().map(
                user -> ResponseUserDto.ReadAllUser.builder()
                        .userId(user.getUserId())
                        .userName(user.getUserName())
                        .build()).toList();
        return p;
    }

    public ResponseUserDto.ReadUser readUser(Long userId){

        Optional<User> u = userRepository.findById(userId);
        if(u.isPresent()){
            User user = u.get();
            ResponseUserDto.ReadUser ret = ResponseUserDto.ReadUser.from(user);
            return ret;
        }
        else{
            throw new IllegalArgumentException("User is not existed");
        }
    }
    public void createUser(RequestUserDto.UserCreateRequest req){
        User user = new User(null,req.getUserName(),new ArrayList<>());
        userRepository.save(user);
    }
    public void deleteUser(Long userId){
        User user = userRepository.findById(userId).orElseThrow(IllegalAccessError::new);
        userRepository.delete(user);
    }
}
