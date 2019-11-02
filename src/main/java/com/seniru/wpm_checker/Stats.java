/*
 * Copyright 2019 Pradeep.
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

import java.util.ArrayList;
import javax.swing.JFrame;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

/**
 *
 * @author Pradeep
 */
public class Stats {
    
    public static void getSpeedChart(ArrayList<Double> data) {
        var chart = new XYChart(800, 400);
        chart.addSeries("WPM", data);
        var frame = new SwingWrapper(chart).displayChart();
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
