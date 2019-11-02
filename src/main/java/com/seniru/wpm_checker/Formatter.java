/*
 * Copyright 2019 Seniru.
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
package com.seniru.wpm_checker;

import java.text.NumberFormat;
import java.time.Duration;


/**
 *
 * @author Seniru
 */
public class Formatter {
    
    private static NumberFormat formatter;
    
    private static boolean hasInit = false;
    
    public static void init() {
        if (!hasInit) {
            formatter = NumberFormat.getNumberInstance();
            formatter.setMaximumFractionDigits(1);
            hasInit = true;
        }
    }
        
    public static String formatTime(int secs) {
        var dur = Duration.ofSeconds(secs);
                
        if (secs < 60) {
            return secs + "s";
        } else if (secs < 3600) {
            return dur.toMinutes() +  "m : " + (secs - dur.toMinutes() * 60) + "s";
        } else if (secs >= 3600) {
            return dur.toHours() + "h : " + (dur.toMinutes() - dur.toHours() * 60) + "m";
        }
        throw new IllegalArgumentException("Cannot format the given time format");     
    }
    
    public static String formatDoubles(double in) {
        if (!hasInit) throw new IllegalStateException("Formatter has not been initialized");     
        return formatter.format(in);
    }
}
