#!/usr/bin/env python3
# coding=utf-8
# -*- coding: UTF-8 -*-
from fastapi import FastAPI, Form
from fastapi.responses import HTMLResponse
import MySQLdb

app = FastAPI()


@app.get('/', response_class=HTMLResponse)
def index():
    form = """
    <form method="post" action="/action" >
        文字輸出欄位：<input name="my_head">
        <input type="submit" value="送出">
    </form>
    """
    return form


@app.post('/action', response_class=HTMLResponse)
def action(my_head: str = Form(default='')):
    # 建立資料庫連線
    conn = MySQLdb.connect(host="127.0.0.1",
                           user="hj",
                           passwd="test1234",
                           db="testdb")
    # 欲查詢的 query 指令
    query = "SELECT description FROM people where name LIKE '{}%';".format(
        my_head)
    # 執行查詢
    cursor = conn.cursor()
    cursor.execute(query)

    results = """
    <p><a href="/">Back to Query Interface</a></p>
    """
    # 取得並列出所有查詢結果
    for (description, ) in cursor.fetchall():
        results += "<p>{}</p>".format(description)
    return results
