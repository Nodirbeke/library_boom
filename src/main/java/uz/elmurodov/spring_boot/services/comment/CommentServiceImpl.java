package uz.elmurodov.spring_boot.services.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.elmurodov.spring_boot.criteria.GenericCriteria;
import uz.elmurodov.spring_boot.dto.comment.CommentCreateDto;
import uz.elmurodov.spring_boot.dto.comment.CommentDto;
import uz.elmurodov.spring_boot.dto.comment.CommentUpdateDto;
import uz.elmurodov.spring_boot.entity.comment.Comment;
import uz.elmurodov.spring_boot.mapper.CommentMapper;
import uz.elmurodov.spring_boot.reposiroty.CommentRepository;
import uz.elmurodov.spring_boot.services.AbstractService;
import uz.elmurodov.spring_boot.utils.BaseUtils;
import uz.elmurodov.spring_boot.utils.validators.comment.CommentValidator;

import java.util.List;


@Service
public class CommentServiceImpl extends AbstractService<CommentRepository, CommentMapper, CommentValidator>
        implements CommentService {

    @Autowired
    protected CommentServiceImpl(CommentRepository repository, CommentMapper mapper, CommentValidator validator, BaseUtils baseUtils) {
        super(repository, mapper, validator, baseUtils);
    }

    @Override
    public Long create(CommentCreateDto createDto) {
        Comment comment = mapper.fromCreateDto(createDto);
        repository.save(comment);
        return comment.getId();
    }

    @Override
    public Void delete(Long id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public Void update(CommentUpdateDto updateDto) {
        Comment comment = mapper.fromUpdateDto(updateDto);
        repository.save(comment);
        return null;
    }

    @Override
    public List<CommentDto> getAll(GenericCriteria criteria) {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public CommentDto get(Long id) {
        Comment comment = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Not Found");
        });
        return mapper.toDto(comment);
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }
}
