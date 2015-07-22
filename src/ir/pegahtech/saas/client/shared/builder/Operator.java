package ir.pegahtech.saas.client.shared.builder;

/**
 * Created by hamidreza on 2/23/2015.
 */
public enum Operator {

    AND,
    OR,
    PLUS,
    MINUS,
    GT,
    GET,
    LT,
    LET,
    EQ,
    NEQ,
    NOT,
    LIKE,
    NotLIKE,
    MULT,
    COUNT,
    SUM,
    MIN,
    MAX,
    AVG,
    COUNTDISTINCT,
    SUMDISTINCT,
    MAXDISTINCT,
    MINDISTINCT,
    AVGDISTINCT;

    public static boolean contains(String test) {

        for (Operator c : Operator.values()) {
            if (c.name().equals(test)) {
                return true;
            }
        }

        return false;
    }

}
