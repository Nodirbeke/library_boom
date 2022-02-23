package uz.elmurodov.spring_boot.dto.task;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.dto.Dto;
import java.time.LocalDateTime;

/**
 * @Author Aziza Tojiboyeva
 */

@Setter
@Getter
@Builder
public class TaskCreateDto implements Dto {

    private String name;
    private String description;
    private Long level;
    private Long priority;
    private LocalDateTime deadline;
    private Long projectId;
    private Long columnId;

}