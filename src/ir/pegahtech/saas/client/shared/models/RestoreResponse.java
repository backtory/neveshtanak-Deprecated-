package ir.pegahtech.saas.client.shared.models;

/**
 * Created by hamidreza on 3/16/2015.
 */
public class RestoreResponse {

    private Integer total;
    private QueryOutputNumber numberOfRestores;


    public Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }
    public QueryOutputNumber getNumberOfRestores() {
        return numberOfRestores;
    }
    public void setNumberOfRestores(QueryOutputNumber numberOfRestores) {
        this.numberOfRestores = numberOfRestores;
    }


}
