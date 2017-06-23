import java.io.*;
import java.util.*;

/**
 * 一文字ずつ標準出力に送る
 */
public class SpeakByChar{

    /** 文字の表示間隔[ms] */
    private int wait;

    /** 文字とウェイトのマップ */
    private HashMap<Character, Integer> map;

    /**
     * コンストラクタ
     */
    SpeakByChar(){
        this.wait = 40;
        map = new HashMap<Character, Integer>();
    }

    /**
     * コンストラクタ
     * @param wait 文字の表示間隔[ms]
     */
    SpeakByChar(int wait){
        this.wait = wait;
        map = new HashMap<Character, Integer>();
    }

    /**
     * 一文字ずつ表示する（改行しない）
     * @param str 表示する文字列
     */
    public void print(String str){
        for (int i = 0; i < str.length(); i++){
            try {
                char c = str.charAt(i);
                System.out.print(c);
                if (map.get(c)==null){
                    Thread.sleep(wait);
                } else {
                    Thread.sleep(map.get(c));
                }
            } catch (InterruptedException e){
                System.err.println(e);
            }
        }
    }

    /**
     * 一文字ずつ表示する（改行する）
     * @param str 表示する文字列
     */
    public void println(String str){
        print(str + "\n");
    }

    /**
     * 一文字ずつ表示する（改行のみ）
     */
    public void println(){
        print("\n");
    }

    /**
     * マップに新たな値をセットする
     * @param c 対象文字
     * @param wait その文字に対するウェイト
     * @return 以前までその文字にセットされていた値。なければnull。
     */
    public Integer add(char c, int wait){
        return map.put(c, wait);
    }

    /**
     * マップから値を削除する
     * @param c 対象文字
     * @return 以前までその文字にセットされていた値。なければnull。
     */
    public int remove(char c){
        return map.remove(c);
    }

    /**
     * ウェイト値を得る
     * @return 現在のウェイト値
     */
    public int getWait(){ return wait; }

    /**
     * ウェイト値を再設定する
     * @param wait 新しいウェイト値
     */
    public void setWait(int wait){ this.wait = wait; }

    /**
     * テスト用mainメソッド
     * @param args コマンドライン引数
     */
    public static void main(String[] args) throws IOException{
        int wait = 40;
        switch (args.length){
            case 1:
                wait = Integer.parseInt(args[0]);
                break;
            case 0:
                break;
            default:
                System.err.println("Usage: java SpeakByChar 100");
                System.exit(1);
        }
        SpeakByChar s = new SpeakByChar(wait);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        s.add('\n',wait * 6);
        s.add('、',wait * 2);
        s.add('。',wait * 4);
        while ((line = br.readLine()) != null){
            s.println(line);
        }
    }
}