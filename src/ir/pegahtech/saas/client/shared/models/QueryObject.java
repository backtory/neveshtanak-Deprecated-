package ir.pegahtech.saas.client.shared.models;

import ir.pegahtech.saas.client.shared.builder.Operator;

import java.util.ArrayList;
import java.util.List;

public class QueryObject {

//	public static final String GROUPBYTERMLIST = "groupByTermList";
//	public static final String SELECTCLAUSE = "selectClause";
//	public static final String WHERECLAUSE = "whereClause";
//	public static final String ORDERBYTERMLIST = "orderByTermList";

	private List<String> groupByTermList;
	private List<SelectTerm> selectClause;
	private FilterNode whereClause;
	private List<OrderNode> orderByTermList;
    private List<String> joinAppendix;


    public QueryObject and(FilterNode filterNode) {
        if (whereClause == null)
            whereClause = filterNode;
        else
            whereClause = new FilterNode(whereClause, Operator.AND.toString(), filterNode);

        return this;
    }

    public QueryObject include(String joinPath) {
        if (joinAppendix == null)
            joinAppendix = new ArrayList<String>();
        joinAppendix.add(joinPath);

        return this;
    }
	
	
	public List<String> getGroupByTermList() {
		return groupByTermList;
	}
	public void setGroupByTermList(List<String> groupByTermList) {
		this.groupByTermList = groupByTermList;
	}
	public List<SelectTerm> getSelectClause() {
		return selectClause;
	}
	public void setSelectClause(List<SelectTerm> selectClause) {
		this.selectClause = selectClause;
	}
	public FilterNode getWhereClause() {
		return whereClause;
	}
	public void setWhereClause(FilterNode whereClause) {
		this.whereClause = whereClause;
	}
	public List<OrderNode> getOrderByTermList() {
		return orderByTermList;
	}
	public void setOrderByTermList(List<OrderNode> orderByTermList) {
		this.orderByTermList = orderByTermList;
	}

}
