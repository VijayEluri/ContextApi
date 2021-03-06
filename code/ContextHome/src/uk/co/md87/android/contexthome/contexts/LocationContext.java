/*
 * Copyright (c) 2009-2010 Chris Smith
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package uk.co.md87.android.contexthome.contexts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import uk.co.md87.android.contextapi.ContextApi;
import uk.co.md87.android.contexthome.ContextType;

/**
 * Provides the user's currently detected location.
 *
 * @author chris
 */
public class LocationContext extends BroadcastReceiver implements ContextType {

    private String value = "-1";

    public LocationContext(final Context context) {
        context.registerReceiver(this, new IntentFilter(ContextApi.Intents.CONTEXT_CHANGED));
    }

    public String getName() {
        return "location";
    }

    public String getValue() {
        return value;
    }

    @Override
    public void onReceive(Context arg0, Intent arg1) {
        value = String.valueOf(arg1.getLongExtra("new", -1));
    }

}
