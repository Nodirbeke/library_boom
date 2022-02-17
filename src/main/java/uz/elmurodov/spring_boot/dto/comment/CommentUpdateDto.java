package uz.elmurodov.spring_boot.dto.comment;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.elmurodov.spring_boot.dto.GenericDto;
import uz.elmurodov.spring_boot.utils.enums.CommentType;

@Getter
@Setter
@NoArgsConstructor
public class CommentUpdateDto extends GenericDto {
    private String comment;
    private CommentType commentType;

    @Builder(builderMethodName = "childBuilder")
    public CommentUpdateDto(Long id, String comment, CommentType commentType) {
        super(id);
        this.comment = comment;
        this.commentType = commentType;
    }
}
