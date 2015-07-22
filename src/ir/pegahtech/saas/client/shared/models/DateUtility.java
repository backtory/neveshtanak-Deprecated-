package ir.pegahtech.saas.client.shared.models;

import java.util.Date;

/**
 * Created by root on 7/1/15.
 */
public class DateUtility {
    public static String getCurrentTime() {
        return new Date().getTime() + "";
    }
}
