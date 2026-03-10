package uz.pdp.springboot_swagger_mapstruct_.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Post {
    private String id;
    private String p_title;
    private String p_content;
    private String order;
}
