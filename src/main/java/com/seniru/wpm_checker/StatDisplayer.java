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

/**
 *
 * @author Pradeep
 */
public class StatDisplayer extends javax.swing.JFrame {

    
    protected ArrayList<Double> spw;
    
    /**
     * Creates new form StatDisplayer
     */
    public StatDisplayer() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chunkLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        chunk = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        wordCount = new javax.swing.JLabel();
        wpmLabel = new javax.swing.JLabel();
        avgLabel = new javax.swing.JLabel();
        showBtn = new javax.swing.JButton();

        chunkLabel.setText("Typed words:");

        chunk.setEditable(false);
        chunk.setColumns(20);
        chunk.setRows(5);
        chunk.setWrapStyleWord(true);
        jScrollPane1.setViewportView(chunk);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("SPEED REPORT");

        timeLabel.setText("Total time: -");

        wordCount.setText("Word count: -");

        wpmLabel.setText("Overall WPM: -");

        avgLabel.setText("Averageg Score: -");

        showBtn.setText("Display Speed Chart");
        showBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(timeLabel)
                    .addComponent(wordCount)
                    .addComponent(wpmLabel)
                    .addComponent(avgLabel)
                    .addComponent(chunkLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showBtn, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(10, 10, 10)
                .addComponent(timeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wordCount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wpmLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(avgLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chunkLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(showBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showBtnActionPerformed
        new Thread(() -> {
            Stats.getSpeedChart(spw);
        }).start();
    }//GEN-LAST:event_showBtnActionPerformed

    public void displayStats(int time, String words, ArrayList<Double> speedPerWord) {
        spw = speedPerWord;
        timeLabel.setText("Total time: " + Formatter.formatTime(time));
        wordCount.setText("Word count: " + WPM.getWords(words).length);
        wpmLabel.setText("Overall WPM: " + Formatter.formatDoubles(WPM.getSpeed(words, time)));
        avgLabel.setText("Average score: " + Formatter.formatDoubles(spw.stream().mapToDouble(Double::new).average().getAsDouble()));
        chunk.setText(words);
        setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avgLabel;
    private javax.swing.JTextArea chunk;
    private javax.swing.JLabel chunkLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton showBtn;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JLabel wordCount;
    private javax.swing.JLabel wpmLabel;
    // End of variables declaration//GEN-END:variables
}
