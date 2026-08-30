package online.shop.binary.base.dto;

public abstract class BaseMergeDto<ID> {
    private ID id;

    public ID getId() { return id; }
    public void setId(ID id) { this.id = id; }
}