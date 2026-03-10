package uz.pdp.springboot_swagger_mapstruct_.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Post {
    private Integer id;
    private String title;
    private String content;
}
