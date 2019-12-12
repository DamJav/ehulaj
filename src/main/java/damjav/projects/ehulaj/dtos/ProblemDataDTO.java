package damjav.projects.ehulaj.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ProblemDataDTO {

    @NotBlank
    private String subject;
    @NotBlank
    @Size(min = 10, max = 200)
    private String description;
    private LocalDate reported = LocalDate.now();
    private String status;

}
