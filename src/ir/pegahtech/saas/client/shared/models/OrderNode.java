package ir.pegahtech.saas.client.shared.models;

public class OrderNode {

    public OrderNode(FilterNode node, OrderTerm term) {
        this.filterNode = node;
        this.term = term;
    }

    private FilterNode filterNode;
    private OrderTerm term;

    public FilterNode getFilterNode() {
        return filterNode;
    }

    public void setFilterNode(FilterNode filterNode) {
        this.filterNode = filterNode;
    }

    public OrderTerm getTerm() {
        return term;
    }

    public void setTerm(OrderTerm term) {
        this.term = term;
    }
}
