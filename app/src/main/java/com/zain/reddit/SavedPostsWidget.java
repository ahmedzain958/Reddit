package com.zain.reddit;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.zain.reddit.activities.HomeActivity;
import com.zain.reddit.service.FillSavedPostsWidgetService;

import static com.zain.reddit.service.FillSavedPostsWidgetService.startActionFillSavedPosts;

/**
 * Implementation of App Widget functionality.
 */
public class SavedPostsWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {
        startActionFillSavedPosts(context, appWidgetId);
    }
//SavedPosts
    public static void updateSavedPostsWidgets(Context context, AppWidgetManager appWidgetManager, int widgetId) {
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.saved_posts_widget);
        Intent intent = new Intent(context, RedditWidgetServiceAdapter.class);
        views.setRemoteAdapter(R.id.lv, intent);

        Intent savedPostClicked = new Intent(context, HomeActivity.class);
        savedPostClicked.putExtra(FillSavedPostsWidgetService.EXTRA_SAVEDPOST_WIDGET_ID, widgetId);
        PendingIntent pendingIntent = PendingIntent.getService(context, 0, savedPostClicked,
                PendingIntent.FLAG_UPDATE_CURRENT);

        views.setPendingIntentTemplate(R.id.lv, pendingIntent);
        appWidgetManager.updateAppWidget(widgetId, views);
    }



    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }
    public static void updateAllWidgets(Context context, AppWidgetManager appWidgetManager, int[] ids) {
        for (int appWidgetId : ids) {
            appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetId, R.id.lv);
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
    }

    @Override
    public void onDisabled(Context context) {
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {

        super.onDeleted(context, appWidgetIds);
    }
}

