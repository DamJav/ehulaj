package damjav.projects.ehulaj.dtos;

import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class AdvertisementDataDTO {


    private Long id;
    @NotBlank
    @Size(min=3 ,max = 50)
    private String title;
    @NotBlank
    @Size(min=5, max= 1000)
    private String description;
    @NotNull
    private Double price;
    private LocalDate added = LocalDate.now();
    private String phone;
    private String city;

}
