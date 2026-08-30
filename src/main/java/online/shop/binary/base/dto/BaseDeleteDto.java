package online.shop.binary.base.dto;

import java.util.List;

public class BaseDeleteDto<ID> {
    private List<ID> ids;

    public List<ID> getIds() { return ids; }
    public void setIds(List<ID> ids) { this.ids = ids; }
}