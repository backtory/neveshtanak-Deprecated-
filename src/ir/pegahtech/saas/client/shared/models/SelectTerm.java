package ir.pegahtech.saas.client.shared.models;

public class SelectTerm {

    public SelectTerm(FilterNode node, String alias) {
        this.node = node;
        this.alias = alias;
    }

    private FilterNode node;
    private String alias;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public FilterNode getNode() {
        return node;
    }

    public void setNode(FilterNode node) {
        this.node = node;
    }
}
