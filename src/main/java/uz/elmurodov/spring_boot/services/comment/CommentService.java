package uz.elmurodov.spring_boot.services.comment;

import uz.elmurodov.spring_boot.criteria.GenericCriteria;
import uz.elmurodov.spring_boot.dto.comment.CommentCreateDto;
import uz.elmurodov.spring_boot.dto.comment.CommentDto;
import uz.elmurodov.spring_boot.dto.comment.CommentUpdateDto;
import uz.elmurodov.spring_boot.entity.comment.Comment;
import uz.elmurodov.spring_boot.services.GenericCrudService;


public interface CommentService extends GenericCrudService<
        Comment,
        CommentDto,
        CommentCreateDto,
        CommentUpdateDto,
        GenericCriteria,
        Long> {
}
