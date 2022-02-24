package uz.elmurodov.spring_boot.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.dto.base.GenericDto;

/**
 * @Author Aziza Tojiboyeva
 */
@Setter
@Getter
@Builder(builderMethodName = "childBuilder")
public class ProjectColumnDto extends GenericDto {
    private String name;
    private Long project_id;
}
