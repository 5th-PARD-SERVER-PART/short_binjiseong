package com.pard.hw4.post.service;

import com.pard.hw4.post.dto.RequestPostDto;
import com.pard.hw4.post.dto.ResponsePostDto;
import com.pard.hw4.post.entity.Post;
import com.pard.hw4.post.repo.PostRepository;
import com.pard.hw4.user.dto.ResponseUserDto;
import com.pard.hw4.user.entity.User;
import com.pard.hw4.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public void createPost(Long userId,RequestPostDto.PostCreateRequest req){
        Optional<User> u = userRepository.findById(userId);
        if(u.isPresent()){
            User user = u.get();
            Post post = Post.from(req.getTitle(),req.getContent(),req.getDate(),user);
            postRepository.save(post);
        }
    }
    public ResponsePostDto.PostingReadResponse readPost(Long postId) {
        Optional<Post> p = postRepository.findById(postId);
        if (p.isPresent()) {
            Post post = p.get();
            return new ResponsePostDto.PostingReadResponse(postId, post.getTitle(),post.getContent(), post.getDate());
        }
        else{
            throw new IllegalArgumentException("postId가 존재하지 않음");
        }
    }
    public List <ResponsePostDto.PostingReadResponse> findByUserId(Long userId){
        List<Post> posts = postRepository.findByUser_UserId(userId);
        List<ResponsePostDto.PostingReadResponse> postDtos = posts.stream().map(
                post -> ResponsePostDto.PostingReadResponse.builder()
                        .postId(post.getPostId())
                        .content(post.getContent())
                        .Title(post.getTitle())
                        .date(post.getDate())
                        .build()).toList();
        return postDtos;
    }
    @Transactional
    public void update(Long postId,RequestPostDto.PostCreateRequest postDto){
        Optional<Post> p = postRepository.findById(postId);
        if(p.isPresent()){
            Post post = p.get();
            post.updateTitle(postDto.getTitle());
            post.updateContent(postDto.getContent());
            postRepository.save(post);
        }
        else{
            throw new IllegalArgumentException("postId가 존재하지 않음");
        }
    }

    public void delete(Long postId){
        postRepository.deleteById(postId);
    }
    }

