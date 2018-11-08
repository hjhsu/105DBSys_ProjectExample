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

## jsp_example

## php_example
1. 按下「XAMPP Control Panel」的「Explorer」
2. 將 `php_example` 資料夾放置於 `htdocs` 資料夾中
3. 使用瀏覽器訪問 [http://localhost/php_example/](http://localhost/php_example/)
4. 於「文字輸出欄位」輸入欲查詢的名稱，並按下「送出」
5. 若該名稱存在於資料庫，將於頁面上列出