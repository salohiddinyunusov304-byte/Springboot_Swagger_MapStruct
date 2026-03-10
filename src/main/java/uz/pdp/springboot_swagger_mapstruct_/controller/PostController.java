package uz.pdp.springboot_swagger_mapstruct_.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springboot_swagger_mapstruct_.entity.Post;
import uz.pdp.springboot_swagger_mapstruct_.mapper.PostMapper;
import uz.pdp.springboot_swagger_mapstruct_.payload.PostDto;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostMapper postMapper;

    @PostMapping("/toEntity")
    public Post toEntity(@RequestBody PostDto postDto) {
        return postMapper.toEntity(postDto);
    }

    @PostMapping("/toDto")
    public PostDto toDto(@RequestBody Post post) {
        return postMapper.toDto(post);
    }
}
