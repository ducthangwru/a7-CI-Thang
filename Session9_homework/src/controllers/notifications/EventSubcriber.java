package controllers.notifications;

/**
 * Created by DUC THANG on 12/28/2016.
 */
public interface EventSubcriber {
    boolean onEvent(EventType eventType, Object params);
}
