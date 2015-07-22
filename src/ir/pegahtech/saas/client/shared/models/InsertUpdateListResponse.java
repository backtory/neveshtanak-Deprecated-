package ir.pegahtech.saas.client.shared.models;

import java.util.List;

/**
 * Created by moh on 5/10/15.
 */
public class InsertUpdateListResponse {
    private List<InsertUpdateResponse> results;

    public List<InsertUpdateResponse> getResults() {
        return results;
    }

    public void setResults(List<InsertUpdateResponse> results) {
        this.results = results;
    }
}
