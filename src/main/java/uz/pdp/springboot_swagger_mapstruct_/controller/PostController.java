package uz.pdp.springboot_swagger_mapstruct_.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.springboot_swagger_mapstruct_.entity.Post;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @GetMapping("/toEntity")
    public Post toEntity() {
        return Post.builder()
                .id(1)
                .title("First Post")
                .content("Content for first post")
                .build();
    }
}
