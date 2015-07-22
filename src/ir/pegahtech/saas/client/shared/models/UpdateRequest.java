package ir.pegahtech.saas.client.shared.models;

/**
 * Created by hamidreza on 3/16/2015.
 */
public class UpdateRequest {

    private ContentUpdateModel[] models;


    public ContentUpdateModel[] getModels() {
        return models;
    }
    public void setModels(ContentUpdateModel[] models) {
        this.models = models;
    }


}
