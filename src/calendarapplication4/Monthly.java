/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calendarapplication4;

/**
 *
 * @author masatodogu
 */
public class Monthly {
    //カレンダーを入れる文字列を定義
    StringBuilder s = new StringBuilder();
    //カレンダーを入れる二次元配列を定義
    int[][] calendar = new int[6][7]; 
    
    //うるう年の判定メソッド
    public static boolean uruu(int x){
        return (x % 4 == 0 || (x % 100 == 0 && x % 400 != 0));
    }
    
    //指定された西暦年、月の日数を返すメソッド
    public static int getDays(int year, int month){
        int endDays[] = {31,28,31,30,31,30,31,31,30,31,30,31};
        return ( (uruu(year) && month == 2) ? endDays[month-1] +1 : endDays[month - 1]);
        
    }
    
    //月間カレンダー計算（指定した年および月の月間カレンダーを二次元配列CALENDERに返す）
    public void calcCalender(int year, int month){
        //これは一番外枠で宣言してみる
        //StringBuilder s = new StringBuilder();
        int days = getDays(year, month);
        int wd = zellerFirst(year, month);
        s.append(" 日　月　火　水　木　金　土\n");
        //int day = 1;
        //出力のカレンダーの整形はappend(string.format(".."))のメソッドを使うと、%2dのようにそのまま書ける
        //もし文字の幅によって合わなければ、固定フォントを文字フォントを選択
        //これはフォントクラスがあり、そのインスタンスを作るときにイタリックetcを選ぶ。
       
        int row = 0;
        int column = 0;
        
        for (int i = 0; i < wd; i++){
            column = i;
            calendar[row][column] = 0;
        }
        
        for(int i = 1; i <= days; i++){
            column = (i + wd - 1) % 7;
            
            calendar[row][column] = i;
            if ( column == 6 ){
                row++;
            }
            //s.append(String.format(" %2d"));
        }    
    }
   
    
    //どうやって転写するんだ。。。。
    /*gridlayoutを用いて整形していく。
    例えば二次元配列にカレンダーを入れておいて、それを転写
    */
    //カレンダーのgetter
    public int[][] getCalender(int year, int month){
        calcCalender(year, month);
        //System.out.print(calendar);
        return calendar;
    }
    
    //ツェラーの公式を使って，引数で与えられた年月の1日を求めるメソッド
    public static int zellerFirst(int x, int y){
        //1月、2月は前年の13月、14月として計算・
        //つまり、2015年の1月のカレンダーはmonthに13を、yearに2014を入力しなくてはいけない
        if (y == 1 || y == 2) {
            x--;
            if (y == 1){
                y = 13;
            }else{
                y = 14;
            }
        }
        //西暦x年y月の１日の曜日を求める
        int day = (x + x/4 - x/100 + x/400 + (13*y+8)/5 + 1) % 7;
        return day;
    }
    
   //ツェラーの公式を使って，引数で与えられた年月の最終日を求めるメソッド
    public static int zellerFinal(int x, int y, int z){
        //1月、2月は前年の13月、14月として計算・
        //つまり、2015年の1月のカレンダーはmonthに13を、yearに2014を入力しなくてはいけない
        if (y == 1 || y == 2) {
            x--;
            if (y == 1){
                y = 13;
            }else{
                y = 14;
            }
        }
        
        int day = (x + x/4 - x/100 + x/400 + (13*y+8)/5 + z) % 7;
        return day;
    }
   
}
