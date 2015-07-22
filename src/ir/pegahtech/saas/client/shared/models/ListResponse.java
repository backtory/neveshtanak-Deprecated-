package ir.pegahtech.saas.client.shared.models;

import java.util.List;

/**
 * Created by root on 5/30/15.
 */
public class ListResponse<T> {
    private Integer totalCount;
    private List<T> data;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
