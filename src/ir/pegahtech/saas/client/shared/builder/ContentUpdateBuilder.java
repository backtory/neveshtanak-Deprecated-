package ir.pegahtech.saas.client.shared.builder;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ir.pegahtech.saas.client.shared.models.BaseModel;
import ir.pegahtech.saas.client.shared.models.ContentCreateModel;
import ir.pegahtech.saas.client.shared.models.ContentUpdateModel;
import ir.pegahtech.saas.client.shared.models.InsertUpdateListResponse;
import ir.pegahtech.saas.client.shared.models.InsertUpdateResponse;
import ir.pegahtech.saas.client.shared.models.StringPair;


/**
 * Created by hamidreza on 2/23/2015.
 */
public class ContentUpdateBuilder<T extends BaseModel> {

    public ContentUpdateModel build(BaseModel model) {
        ContentUpdateModel updateModel = new ContentUpdateModel();
        if(model == null)
            throw new RuntimeException("Model is null");

        try {
            Map<String, String> changes = model.__changes();
            String guid = (String) model.getClass().getMethod("getGuid", new Class[0])
                    .invoke(model, new Object[0]);
            updateModel.setEntityId(guid);
            updateModel.setFieldMap(new ArrayList<StringPair>());

            for (String key: changes.keySet())
                updateModel.getFieldMap().add(new StringPair(key, changes.get(key)));

            return updateModel;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public List<ContentUpdateModel> buildList(List<T> ts) {
        List<ContentUpdateModel> result = new ArrayList<ContentUpdateModel>();
        if (ts == null)
            return result;

        for (T item: ts)
            result.add(build(item));

        return result;
    }

    public void update(BaseModel request, InsertUpdateResponse object) {
        if (request == null)
            return;

        Class cls = request.getClass();
        try {
            cls.getMethod("setGuid", new Class[] { String.class })
                    .invoke(request, new Object[] {object.getGuid()});
            if (object.getCreationDate() != null) {
                cls.getMethod("setCreationDate", new Class[]{Date.class})
                        .invoke(request, new Object[]{object.getCreationDate()});
            }
            cls.getMethod("setLastModifiedDate", new Class[] { Date.class })
                    .invoke(request, new Object[] {object.getLastModifiedDate()});

            if (object.getOwnerId() != null) {
                cls.getMethod("setOwner_ID", new Class[]{String.class})
                        .invoke(request, new Object[]{object.getOwnerId()});
            }
            if (object.getIsDeleted() != null) {
                cls.getMethod("setIsDeleted", new Class[]{Boolean.class})
                        .invoke(request, new Object[]{object.getIsDeleted()});
            }

            Field field = cls.getSuperclass().getDeclaredField("fieldsMap");
            field.setAccessible(true);
            field.set(request, new HashMap<String, String>());
            field.setAccessible(false);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateAll(List<BaseModel> request, InsertUpdateListResponse object) {
        if (request == null && object == null)
            return;
        if (request == null || object == null || object.getResults() == null
                || request.size() != object.getResults().size())
            throw new RuntimeException("Request or Object are null or not equal size");

        for (int i = 0; i < request.size(); i++)
            update(request.get(i), object.getResults().get(i));
    }


}