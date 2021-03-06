/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calendarapplication4;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author masatodogu
 */
public class CalendarFrame extends javax.swing.JFrame {
    //カレンダーのボタン配列を定義
    private JButton buttonMatrix[][] = null;
    //コンストラクタで使うカレンダークラスをインスタンス化
    Calendar calendar = Calendar.getInstance();
    //カレンダー計算を行うクラスをインスタンス化
    Monthly m = new Monthly();
    
    /**
     * コンストラクタ
     * ここで、グリッドレイアウトを作る
     */
    public CalendarFrame() {
        initComponents();
        //コンストラクタ用に、今日の情報を取得
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        
        calendarPanel.setLayout( new GridLayout( 6, 7 ) );
        //ボタンの参照を入れる配列を定義
        buttonMatrix = new JButton[6][7];
        //今日のカレンダーを作成し、配列に格納
        int[][] printCalendar = m.getCalender(year, month);
        
        int i = 1;
        for ( int row = 0; row < 6; row++ ) {
            for ( int column = 0; column < 7; column++ ) {
                //ボタンの実体を生成
                buttonMatrix[row][column] = new JButton(Integer.toString(i));
                //パネルに加える
                calendarPanel.add( buttonMatrix[row][column] );
                //もし、カレンダーのテキストが0なら、それは押せないようにenableにする
                
                i++;
            }
        }
        //アクションリスナーを作る
        ActionListener aButtonActionListener = new ButtonActionListener();
        
        int k = printCalendar.length;
        for(int l = 0; l < k; l++){
            for(int j = 0; j < 7; j++){
                buttonMatrix[l][j].setText(Integer.toString(printCalendar[l][j]));
                //それをボタン自身にaddする
                buttonMatrix[l][j].addActionListener(aButtonActionListener);
                if(printCalendar[l][j] == 0){
                    buttonMatrix[l][j].setEnabled(false);
                }
                
            }
        }
        
        pack();
        calendarPanel.repaint();
    }
    
    class ButtonActionListener implements ActionListener {
        // ----------------------------------------
        public void actionPerformed( ActionEvent e ) {
            // ----------------------------------------
            // イベントソースをgetSourceで取れる。そしたら、getTextで何日が押されたかはわかる。
             JButton b = (JButton)e.getSource();
             //押されたのが何日だったのかをコンソールに表示
             System.out.println(b.getText());
             
             //次に、ポップアップウィンドウをnewする。
             JFrame Schedule = new JFrame();
             //そこにJTextAreaをもうけ、何か予定を記入して、今とった数字・日付で保存する。
             //JTextAreaに書き込まれた内容を取ってくる。それをファイルの内容とする。
             
            // ----------------------------------------
            
        }
        // ----------------------------------------
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        displayButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        yearField = new javax.swing.JTextField();
        monthField = new javax.swing.JTextField();
        calendarPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        displayButton.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        displayButton.setText("表示");
        displayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("年");

        jLabel2.setText("月");

        calendarPanel.setBackground(new java.awt.Color(255, 255, 255));
        calendarPanel.setPreferredSize(new java.awt.Dimension(370, 370));
        calendarPanel.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(125, Short.MAX_VALUE)
                .addComponent(yearField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(monthField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(35, 35, 35)
                .addComponent(displayButton)
                .addGap(59, 59, 59))
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(calendarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(displayButton)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(monthField)
                                .addGap(2, 2, 2))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(yearField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(32, 32, 32)
                .addComponent(calendarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void displayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayButtonActionPerformed
        int year = Integer.parseInt(yearField.getText());
        int month = Integer.parseInt(monthField.getText());
        
        
        
        //指定された月の日数を取得
        int endOfTheMonth = m.getDays(year, month);
        
        //カレンダーを配列にget
        int[][] printCalendar = m.getCalender(year, month);
        //配列の長さを印字することで、二次元配列に格納されていることを確認
        int k = printCalendar.length;
        
        
        //ここで、gridlayoutに転写。for文でadd。
        //Labelをadd。そのLabelの文字列がカレンダーの数字
        //ここで、グリッドレイアウトを作る
        //JPanel calendarPanel = new JPanel();
        //calenderPanel.setLayout(new GridLayout(6,7));
        
        for(int i = 0; i < k; i++){
            for(int j = 0; j < 7; j++){
                buttonMatrix[i][j].setText(Integer.toString(printCalendar[i][j]));
                //コンストラクタと処理が重複しているので、メソッドに書き出して、呼んであげる形が良い。
                if(printCalendar[i][j] == 0){
                    buttonMatrix[i][j].setEnabled(false);
                }else{
                    buttonMatrix[i][j].setEnabled(true);
                }
            }
        }
        
        //一日より前のボタンを消すか非表示にしたい！！！
        //for文でまわして、数字を入れているときに、0のものはenabled(false)にしてしまう。
        //
        //for(int j = 0; j < 7; j++){
        //    if(buttonMatrix[0][j].getText().equals("0")){
        //        buttonMatrix[0][j].setEnabled(false);
                /*
                buttonMatrix[0][j].setContentAreaFilled(false);
                buttonMatrix[0][j].setBorderPainted(false);
                
                buttonMatrix[0][j].setVisibility(buttonMatrix.INVISIBLE);
                remove(buttonMatrix[0][j]);
                */
        //        }
        }
        /*
        
        
        calendarPanel.repaint();
        //Container contentPane = getContentPane();
        //add(calendarPanel, BorderLayout.CENTER);       
        //pack();
        
    }//GEN-LAST:event_displayButtonActionPerformed

//今後の方向性
/*
データのハンドリング。データをしまったり、取り出したり。
xmlやJSON。XML形式でファイルに書き込む。
後々はデータベース。
課題は、スケジュール帳作成&年間カレンダーへの拡張。
日付ボタンを押すと、一日分のスケジュールを入れるウィンドウが出てきて、そこに書き込み、ok押すと、記録される。
スケジュールが入っているボタンのみ文字を青くetc
    
これが終わったら、webAPP。
*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel calendarPanel;
    private javax.swing.JButton displayButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField monthField;
    private javax.swing.JTextField yearField;
    // End of variables declaration//GEN-END:variables
}
