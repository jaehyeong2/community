package jaefactory.community.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class BoardDto<T> {
    int status;
    T data;
}
