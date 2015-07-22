package ir.pegahtech.saas.client.shared.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hamidreza on 3/16/2015.
 */
public class DeleteRequest {
    private List<String> contentIds;
    public DeleteRequest() { }
    public DeleteRequest(List<String> contentIds) {
        this.contentIds = contentIds;
    }
    public DeleteRequest(String... contentIds) {
        setContentIds(new ArrayList<String>());
        for (String id: contentIds)
            getContentIds().add(id);
    }

    public List<String> getContentIds() {
        return contentIds;
    }
    public void setContentIds(List<String> contentIds) {
        this.contentIds = contentIds;
    }


}
