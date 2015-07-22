package ir.pegahtech.saas.client.shared.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hamidreza on 3/16/2015.
 */
public class ListRequest {
    private Integer start;
    private Integer pageSize;
    private Boolean includeDeleted;
    private Boolean includeUndeleted;
    private QueryObject queryObject;

    public ListRequest() {
        queryObject = new QueryObject();
    }

    public ListRequest(Integer start, Integer pageSize, Boolean includeDeleted,
                       Boolean includeUndeleted, QueryObject queryObject) {
        this.start = start;
        this.pageSize = pageSize;
        this.includeDeleted = includeDeleted;
        this.includeUndeleted = includeUndeleted;
        this.queryObject = queryObject;
    }

    public ListRequest and(FilterNode filter) {
        queryObject.and(filter);
        return this;
    }

    public ListRequest includeObject(String joinPath) {
        queryObject.include(joinPath);
        return this;
    }

    /****** Auxiliary methods *****/
    public ListRequest setStartIndex(Integer start) {
        this.start = start;
        return this;
    }

    public ListRequest setMaxResult(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public ListRequest includeDeleted() {
        this.includeDeleted = true;
        return this;
    }

    public ListRequest excludeDeleted() {
        this.includeDeleted = false;
        return this;
    }

    public ListRequest includeUndeleted() {
        this.includeUndeleted = true;
        return this;
    }

    public ListRequest excludeUndeleted() {
        this.includeUndeleted = false;
        return this;
    }

    public ListRequest setQuery(QueryObject query) {
        this.queryObject = query;
        return this;
    }

    public ListRequest select(SelectTerm... terms) {
        if (terms == null || terms.length == 0) {
            queryObject.setSelectClause(null);
            return this;
        }
        List<SelectTerm> lst = new ArrayList<SelectTerm>();
        for (int i = 0; i < terms.length; i++)
            lst.add(terms[i]);
        return select(lst);
    }

    private ListRequest select(List<SelectTerm> lst) {
        queryObject.setSelectClause(lst);
        return this;
    }

    public ListRequest groupBy(String... groupByTerms) {
        if (groupByTerms == null || groupByTerms.length == 0) {
            queryObject.setGroupByTermList(null);
            return this;
        }

        List<String> lst = new ArrayList<String>();
        for (int i = 0; i < groupByTerms.length; i++)
            lst.add(groupByTerms[i]);
        return groupBy(lst);
    }

    public ListRequest groupBy(List<String> groupByTerms) {
        queryObject.setGroupByTermList(groupByTerms);
        return this;
    }

    public ListRequest addOrderBy(FilterNode node, boolean isAsc) {
        if (queryObject.getOrderByTermList() == null)
            queryObject.setOrderByTermList(new ArrayList<OrderNode>());

        queryObject.getOrderByTermList().add(
                new OrderNode(node, isAsc ? OrderTerm.ASC : OrderTerm.DESC));

        return this;
    }

    public Integer getStart() {
        return start;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Boolean getIncludeDeleted() {
        return includeDeleted;
    }

    public Boolean getIncludeUndeleted() {
        return includeUndeleted;
    }

    public QueryObject getQueryObject() {
        return queryObject;
    }

}