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

/**
 *
 * @author Seniru
 */

public class WPM {
    
    public static double getSpeed(String chunk, int secs) {
        return getWords(chunk).length / ((secs == 0 ? getMinutes(1) : getMinutes(secs)));
    }
    
    public static String[] getWords(String chunk) {
        return chunk.replaceAll("(\\s+|\\n)", " ").split(" ");
    }
    
    public static double getMinutes(int seconds) {
        return seconds / 60.0;
    }
    
}
