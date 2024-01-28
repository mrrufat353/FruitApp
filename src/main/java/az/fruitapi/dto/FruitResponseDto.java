package az.fruitapi.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FruitResponseDto {

    Long id;

    String name;

    Double amount;

    Double price;
}
