package example.chen.com.customview;

import android.support.v7.app.AppCompatActivity;

public class ActivityItem {
    private String activityClass;
    private String title;


    public ActivityItem(String activityClass, String title) {
        this.activityClass = activityClass;
        this.title = title;
    }

    public String getActivityClass() {
        return activityClass;
    }

    public void setActivityClass(String activityClass) {
        this.activityClass = activityClass;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
