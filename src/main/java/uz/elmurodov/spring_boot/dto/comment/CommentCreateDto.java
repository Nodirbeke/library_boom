package uz.elmurodov.spring_boot.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.dto.Dto;
import uz.elmurodov.spring_boot.utils.enums.CommentType;


@Getter
@Setter
@Builder
@AllArgsConstructor
public class CommentCreateDto implements Dto {

    private String comment;
    private Long task_id;
    private CommentType commentType;

}
