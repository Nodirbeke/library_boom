package uz.elmurodov.spring_boot.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.elmurodov.spring_boot.entity.comment.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>, AbstractRepository {

}
