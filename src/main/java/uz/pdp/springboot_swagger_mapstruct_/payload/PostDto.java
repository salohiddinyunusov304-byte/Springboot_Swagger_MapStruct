package uz.pdp.springboot_swagger_mapstruct_.payload;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PostDto {
    private String title;
    private String content;
    private Integer order;
}
