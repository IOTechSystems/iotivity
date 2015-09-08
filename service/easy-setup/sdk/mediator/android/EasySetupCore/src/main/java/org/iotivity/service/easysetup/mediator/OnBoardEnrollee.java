/******************************************************************
 *
 * Copyright 2015 Samsung Electronics All Rights Reserved.
 *
 *
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
 *
 ******************************************************************/
package org.iotivity.service.easysetup.mediator;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import org.iotivity.service.easysetup.mediator.ip.WiFiSoftAPManager;

import android.widget.Toast;

public class OnBoardEnrollee {
    WiFiSoftAPManager wifiSoftAPManager;
    IOnBoardingStatus deviceScanListener;

    /**
     * Constructor for OnBoardEnrollee. Constructs a new OnBoardEnrollee.
     */
    public OnBoardEnrollee(Context context) {
        wifiSoftAPManager = new WiFiSoftAPManager(context);
    }

    public void registerOnBoardingStatusHandler(
            IOnBoardingStatus deviceScanListener) {
        this.deviceScanListener = deviceScanListener;
    }

    public void startDeviceScan() {
        wifiSoftAPManager.getClientList(this.deviceScanListener, 300);
    }

    public void enableWiFiAP(WifiConfiguration netConfig, boolean enabled) {
        wifiSoftAPManager.setWifiApEnabled(netConfig, true);
    }

    public void disableWiFiAP() {
        wifiSoftAPManager.setWifiApEnabled(null, false);
    }
}
