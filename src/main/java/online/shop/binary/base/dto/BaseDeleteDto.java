package online.shop.binary.base.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class BaseDeleteDto<ID> {
    private List<ID> ids;
}