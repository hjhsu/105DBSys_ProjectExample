# 105DBSys_ProjectExample
105-1 IECS.FCU DBSys Project Example

## 環境準備
1. 下載 [XAMPP](https://www.apachefriends.org/zh_tw/index.html)，並安裝
2. 以系統管理員身分執行「XAMPP Control Panel」
3. 按下「Apache」和「MySQL」的「Start」
4. 按下「MySQL」的「Admin」開啟 phpMyAdmin 介面
5. 建立資料庫 `testdb`
6. 建立使用者
    - 帳號：`hj`
    - 主機名稱：`localhost`
    - 密碼：`test1234`
7. 賦予使用者 `hj` 資料庫 `testdb` 的完整權限
8. 進入資料庫 `testdb` 並匯入 `db/init.sql`

## db_example
1. 編譯 `.java` 檔
    ```bash
    javac -cp ".;.\mysql-connector-java-5.1.40-bin.jar" .\db_example\*.java
    ```
2. 執行「MyAppServer」或「MyEchoServer」
    ```bash
    java -cp ".;.\mysql-connector-java-5.1.40-bin.jar" db_example.MyAppServer
    java db_example.MyEchoServer
    ```
3. 執行「MyC1Client」或「MyCCClient」
    ```bash
    java db_example.MyC1Client
    java db_example.MyC1Client
    ```
4. 於 Client 輸入文字內容，將可得到由 Server 回傳的回應
    - 若連到 MyAppServer，會自資料庫查詢該名稱，若該名稱存在，會印出描述
    - 若連到 MyEchoServer，會直接回傳輸入內容

## jsp_example
1. 以系統管理員身分執行「XAMPP Control Panel」
2. 按下「Explorer」
3. 將 `jsp_example` 資料夾放置於 `Tomcat/webapps` 資料夾中
4. 於 [Download Connector/J](https://dev.mysql.com/downloads/connector/j/) 頁面下載「JDBC Driver for MySQL (Connector/J)」
    - 選擇「Platform Independent」，並點擊「Download」下載壓縮檔
5. 將壓縮檔中的 `mysql-connector-java-8.X.XX.jar` 放置於 `Tomcat/lib`
6. 按下「Tomcat」的「Start」
7. 使用瀏覽器訪問 [http://localhost:8080/jsp_example/](http://localhost:8080/jsp_example/)
8. 於「文字輸出欄位」輸入欲查詢的名稱，並按下「送出」
9. 若該名稱存在於資料庫，將於頁面上列出描述

## php_example
1. 以系統管理員身分執行「XAMPP Control Panel」
2. 按下「Explorer」
3. 將 `php_example` 資料夾放置於 `htdocs` 資料夾中
4. 使用瀏覽器訪問 [http://localhost/php_example/](http://localhost/php_example/)
5. 於「文字輸出欄位」輸入欲查詢的名稱，並按下「送出」
6. 若該名稱存在於資料庫，將於頁面上列出名稱