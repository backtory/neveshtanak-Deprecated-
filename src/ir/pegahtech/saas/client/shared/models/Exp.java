package ir.pegahtech.saas.client.shared.models;

import java.util.logging.Filter;

import ir.pegahtech.saas.client.shared.builder.Operator;

/**
 * Created by root on 4/26/15.
 */
public class Exp {
    public static FilterNode equalsTo(String property, Object value) {
        return new FilterNode(new FilterNode(property),
                Operator.EQ.toString(),
                new FilterNode(value == null ? null : value.toString()));
    }

    public static FilterNode notEqualsTo(String property, Object value) {
        return new FilterNode(new FilterNode(property),
                Operator.NEQ.toString(),
                new FilterNode(value == null ? null : value.toString()));
    }

    public static FilterNode lessThanOrEqual(String property, Object value) {
        return new FilterNode(new FilterNode(property),
                Operator.LET.toString(),
                new FilterNode(value == null ? null : value.toString()));
    }

    public static FilterNode greaterThanOrEqual(String property, Object value) {
        return new FilterNode(new FilterNode(property),
                Operator.GET.toString(),
                new FilterNode(value == null ? null : value.toString()));
    }

    public static FilterNode between(String property, Object lowerBoundInclusive, Object upperBoundInclusive) {
        return and(
                lessThanOrEqual(property, upperBoundInclusive),
                greaterThanOrEqual(property, lowerBoundInclusive)
        );
    }

    public static FilterNode and(FilterNode... filterNodes) {
        if (filterNodes == null || filterNodes.length < 2)
            throw new RuntimeException("At least two operands are needed for AND");

        FilterNode result = null;
        for (FilterNode node: filterNodes) {
            if (result == null) {
                result = node;
            } else {
                FilterNode temp = new FilterNode(result, Operator.AND.toString(), node);
                result = temp;
            }
        }

        return result;
    }

    public static FilterNode or(FilterNode... filterNodes) {
        if (filterNodes == null || filterNodes.length < 2)
            throw new RuntimeException("At least two operands are needed for AND");

        FilterNode result = null;
        for (FilterNode node: filterNodes) {
            if (result == null) {
                result = node;
            } else {
                FilterNode temp = new FilterNode(result, Operator.OR.toString(), node);
                result = temp;
            }
        }

        return result;
    }
    
    public static SelectTerm selectProperty(String propertyName, String alias) {
        return new SelectTerm(property(propertyName), alias);
    }

    public static SelectTerm count(String propertyName, String alias) {
        return aggregate(Operator.COUNT.toString(), propertyName, alias);
    }

    public static SelectTerm max(String propertyName, String alias) {
        return aggregate(Operator.MAX.toString(), propertyName, alias);
    }

    public static SelectTerm min(String propertyName, String alias) {
        return aggregate(Operator.MIN.toString(), propertyName, alias);
    }

    public static SelectTerm average(String propertyName, String alias) {
        return aggregate(Operator.AVG.toString(), propertyName, alias);
    }

    public static SelectTerm aggregate(String function, String propertyName, String alias) {
        return new SelectTerm(new FilterNode(new FilterNode(propertyName), function, null), alias);
    }

    public static FilterNode property(String propertyName) {
        return new FilterNode(propertyName);
    }
}
