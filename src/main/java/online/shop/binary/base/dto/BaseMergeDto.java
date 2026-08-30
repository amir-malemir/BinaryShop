package online.shop.binary.base.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseMergeDto<ID> {
    private ID id;
}