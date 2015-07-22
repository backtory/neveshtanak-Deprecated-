package ir.pegahtech.saas.client.shared.models;

import java.util.List;

/**
 * Created by hamidreza on 3/16/2015.
 */
public class DeleteResponse {

    private List<QueryOutput> deleteIDOutputList;


    public List<QueryOutput> getDeleteIDOutputList() {
        return deleteIDOutputList;
    }
    public void setDeleteIDOutputList(List<QueryOutput> deleteIDOutputList) {
        this.deleteIDOutputList = deleteIDOutputList;
    }

}
