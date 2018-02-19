package com.zain.reddit.service;

/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

import android.app.IntentService;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;

import static com.zain.reddit.SavedPostsWidget.updateSavedPostsWidgets;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 */
public class FillSavedPostsWidgetService extends IntentService {

    public static final String ACTION_FILL_SAVED_POSTS = "com.zain.reddit.action.fillrecipe";
    public static final String EXTRA_SAVEDPOST_WIDGET_ID = "com.example.android.mygarden.extra.SAVED_WIDGET_ID";

    public FillSavedPostsWidgetService() {
        super("FillSavedPose");
    }

    public static void startActionFillSavedPosts(Context context, int appWidgetId) {
        Intent intent = new Intent(context, FillSavedPostsWidgetService.class);
        intent.setAction(ACTION_FILL_SAVED_POSTS);
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
             if (ACTION_FILL_SAVED_POSTS.equals(action)) {
                int widgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
                handleActionfillRecipe(widgetId);
            }
        }
    }
    private void handleActionfillRecipe(int widgetId) {

        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
        updateSavedPostsWidgets(this, appWidgetManager, widgetId);
    }


}
