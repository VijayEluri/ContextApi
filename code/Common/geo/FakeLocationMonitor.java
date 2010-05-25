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

package uk.co.md87.android.common.geo;

/**
 * A dummy location monitor for use in emulator testing.
 * 
 * @author chris
 */
public class FakeLocationMonitor implements LocationMonitor {

    private static final int REPEATS = 5;
    
    private int count = 0;
    private double[][] points = new double[][] {
        {51.481386d, -0.084667d},
        {51.517676d, -0.07997d},
        {51.498725d, -0.17950d},
    };

    public float getAccuracy() {
        return 0f;
    }

    public double getLat() {
        return points[(count++ / REPEATS) % points.length][0];
    }

    public double getLon() {
        return points[(count / REPEATS) % points.length][1];
    }

}
