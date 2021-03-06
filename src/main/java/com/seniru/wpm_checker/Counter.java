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

import static com.seniru.wpm_checker.CheckerGUI.*;

/**
 *
 * @author Seniru
 */
public class Counter extends Thread {

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(1000);
                secs++;
                wpmsec.add(WPM.getSpeed(txtArea.getText(), secs));
                time.setText("Elapsed time: " + Formatter.formatTime(secs));
                words.setText("Word count: " + WPM.getWords(txtArea.getText()).length);
                wpmScore.setText("WPM: " + Formatter.formatDoubles(WPM.getSpeed(txtArea.getText(), secs)) + " WPM");
                addedIndex = txtArea.getText().length();
            } catch (InterruptedException ex) {
                // ignore
            }
        } while (isCounting);
    }

}
