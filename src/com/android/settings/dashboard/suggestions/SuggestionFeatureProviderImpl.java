/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.dashboard.suggestions;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.android.settings.Settings.NightDisplaySuggestionActivity;
import com.android.settings.biometrics.fingerprint.FingerprintEnrollSuggestionActivity;
import com.android.settings.biometrics.fingerprint.FingerprintSuggestionActivity;
import com.android.settings.display.NightDisplayPreferenceController;
import com.android.settings.notification.zen.ZenOnboardingActivity;
import com.android.settings.notification.zen.ZenSuggestionActivity;
import com.android.settings.overlay.FeatureFactory;
import com.android.settings.password.ScreenLockSuggestionActivity;
import com.android.settings.wallpaper.StyleSuggestionActivity;
import com.android.settings.wallpaper.WallpaperSuggestionActivity;
import com.android.settings.wifi.calling.WifiCallingSuggestionActivity;
import com.android.settingslib.core.instrumentation.MetricsFeatureProvider;

public class SuggestionFeatureProviderImpl implements SuggestionFeatureProvider {

    private static final String TAG = "SuggestionFeature";

    private static final String SHARED_PREF_FILENAME = "suggestions";

    private final MetricsFeatureProvider mMetricsFeatureProvider;

    @Override
    public boolean isSuggestionEnabled(Context context) {
        return false;
    }

    @Override
    public ComponentName getSuggestionServiceComponent() {
        return new ComponentName(
                "com.android.settings.intelligence",
                "com.android.settings.intelligence.suggestions.SuggestionService");
    }

    @Override
    public boolean isSuggestionComplete(Context context, @NonNull ComponentName component) {
        return true;
    }

    @Override
    public SharedPreferences getSharedPrefs(Context context) {
        return context.getSharedPreferences(SHARED_PREF_FILENAME, Context.MODE_PRIVATE);
    }

    @Override
    public Class<? extends Fragment> getContextualSuggestionFragment() {
        return null;
    }

    public SuggestionFeatureProviderImpl(Context context) {
        final Context appContext = context.getApplicationContext();
        mMetricsFeatureProvider = FeatureFactory.getFactory(appContext)
                .getMetricsFeatureProvider();
    }
}
