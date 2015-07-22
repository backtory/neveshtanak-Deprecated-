package ir.pegahtech.saas.client.shared.models;

import java.util.List;

/**
 * Created by hamidreza on 3/16/2015.
 */
public class UpdateResponse {
    private List<QueryOutput> updateIDOutputList;


    public List<QueryOutput> getUpdateIDOutputList() {
        return updateIDOutputList;
    }
    public void setUpdateIDOutputList(List<QueryOutput> updateIDOutputList) {
        this.updateIDOutputList = updateIDOutputList;
    }


}
