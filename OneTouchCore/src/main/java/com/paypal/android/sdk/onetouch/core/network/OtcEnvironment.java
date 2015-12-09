package com.paypal.android.sdk.onetouch.core.network;

import android.text.TextUtils;

import com.paypal.android.sdk.onetouch.core.BuildConfig;
import com.paypal.android.sdk.onetouch.core.base.CoreEnvironment;
import com.paypal.android.sdk.onetouch.core.base.DeviceInspector;

public class OtcEnvironment implements CoreEnvironment {
    @Override
    public String getVersion() {
        return BuildConfig.PRODUCT_VERSION;
    }

    @Override
    public String getPrefsFile() {
        return "PayPalOTC";
    }

    @Override
    public String getUserAgent() {
        String productName = BuildConfig.PRODUCT_NAME;
        String version = BuildConfig.PRODUCT_VERSION;
        String osDetails = DeviceInspector.getOs();
        String deviceName = DeviceInspector.getDeviceName();
        String featuresString = getFeatureString();

        return String.format("PayPalSDK/%s %s (%s; %s; %s)", productName, version, osDetails,
                deviceName, featuresString);
    }

    private String getFeatureString() {
        StringBuilder featureList = new StringBuilder();
        if (BuildConfig.DEBUG) {
            featureList.append("debug; ");
        }
        if (!TextUtils.isEmpty(BuildConfig.PRODUCT_FEATURES)) {
            featureList.append(BuildConfig.PRODUCT_FEATURES).append(" ");
        }

        return featureList.toString().trim();
    }

    @Override
    public String getSha1() {
        return BuildConfig.LATEST_SHA1;
    }

    @Override
    public boolean isDebug() {
        return BuildConfig.DEBUG;
    }

}