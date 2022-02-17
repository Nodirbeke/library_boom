package uz.elmurodov.spring_boot.entity.comment;

import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.entity.Auditable;
import uz.elmurodov.spring_boot.utils.enums.CommentType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Getter
@Setter
@Entity
@Table(name = "comment", schema = "etm_b4")
public class Comment extends Auditable {

    @Column(nullable = false)
    private String comment;

    @Column(name = "task_id", nullable = false)
    private Long task_id;

    @Column(name = "commentType")
    private CommentType commentType;

}
