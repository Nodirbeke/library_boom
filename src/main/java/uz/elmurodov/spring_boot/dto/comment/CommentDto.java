package uz.elmurodov.spring_boot.dto.comment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.dto.GenericDto;
import uz.elmurodov.spring_boot.utils.enums.CommentType;

@Getter
@Setter
public class CommentDto extends GenericDto {

    private String comment;
    private Long task_id;
    private CommentType commentType;

    @Builder(builderMethodName = "childBuilder")
    public CommentDto(Long id, String comment, Long task_id, CommentType commentType) {
        super(id);
        this.comment = comment;
        this.task_id = task_id;
        this.commentType = commentType;
    }
}
