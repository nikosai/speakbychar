# SpeakByChar
一文字ずつ標準出力に送るJavaプログラム。

## コンパイル＆テスト
コンパイル方法は以下の通り。
```bash
javac SpeakByChar.java
```

コンパイル後、最も簡単なテストの方法は次の通り。
```bash
java SpeakByChar < SpeakByChar.java
```
これを実行すると、SpeakByCharのソースコードが1文字ずつ標準出力に送られる。

また、適当なテキストを書いた`in.txt`を同ディレクトリ内に置き、
```bash
java SpeakByChar < in.txt
```
として実行すれば、そのファイルを1文字ずつ標準出力に送る。

句点や読点、改行では少し間を開けるよう設定されている。