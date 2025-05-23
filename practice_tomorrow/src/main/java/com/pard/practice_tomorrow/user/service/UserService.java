package com.pard.practice_tomorrow.user.service;

import com.pard.practice_tomorrow.post.dto.PostResDto;
import com.pard.practice_tomorrow.post.entity.Post;
import com.pard.practice_tomorrow.post.repo.PostRepo;
import com.pard.practice_tomorrow.user.dto.UserReqDto;
import com.pard.practice_tomorrow.user.dto.UserResDto;
import com.pard.practice_tomorrow.user.entity.User;
import com.pard.practice_tomorrow.user.repo.UserRepo;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Builder
public class UserService {
    private final UserRepo userRepo;
    private final PostRepo postRepo;

    public void createUser(UserReqDto.UserCreateUpdate req){
        User user = User.builder()
                .userName(req.getUserName())
                .build();
        userRepo.save(user);
    }
    public List<UserResDto.ReadPostByUserId> readPostByUserId(@PathVariable Long Id){

        User user = userRepo.findById(Id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. ID: " + Id));

        UserResDto.ReadPostByUserId result = UserResDto.ReadPostByUserId.from(user);

        return List.of(result); // 단일 사용자 기준

    }
    public List<UserResDto.ReadUser> readUsers(){
        //List<User>로 받기
        List<User> users = userRepo.findAll();
        // 2. User → ReadUser로 변환
        List<UserResDto.ReadUser> result = users.stream()
                .map(UserResDto.ReadUser::from)
                .toList();

        return result;
    }
    @Transactional
    public void updateById(Long id, UserReqDto.UserCreateUpdate req){
        User user = userRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 순서의 사용자를 찾을 수 없습니다. ID: " + id));

        user.update(req);
        userRepo.save(user); // 이게 없으면 DB에 저장 안됨!!!
    }

    @Transactional
    public void deleteById(Long id) {
        userRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 순서의 사용자를 찾을 수 없습니다. ID: " + id));

        userRepo.deleteById(id);
    }
}
