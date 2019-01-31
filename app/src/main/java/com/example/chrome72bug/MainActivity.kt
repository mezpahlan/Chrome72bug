package com.example.chrome72bug

import android.os.Bundle
import android.util.Base64
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            val data = """
                <!DOCTYPE html

                PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"

                "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>

                <title>Chrome CSS Bug</title>

                <meta name="viewport" content="initial-scale=1.0, maximum-scale=5.0, minimum-scale=1.0" /-->

                <meta name="HandheldFriendly" content="True" />

                <meta name="MobileOptimized" content="width" />



    <style type="text/css">

        html {

            font-family: sans-serif;

            line-height: 1.15;

            -ms-text-size-adjust: 100%;

            -webkit-text-size-adjust: 100%;

        }

        body {

            margin: 0;

            background: #fff;

            color: #15233e;

            font: 16px/1.4 "Effra", arial, sans-serif;

            padding: 10px

        }

        a,

        a:visited {

            background-color: transparent;

            color: #18a9e7;

            text-decoration: none

        }

        a:active,

        a:hover {

            outline-width: 0;

            text-decoration: underline

        }

        p {

            margin: 0 0 0.9em

        }

        h1 {

            font-size: 2em;

            font-weight: bold;

            line-height: 1.2;

            margin: 0 0 0.3em

        }

        h2 {

            font-size: 1.6em;

            font-weight: bold;

            margin: 0 0 0.5em

        }

        h3 {

            font-size: 1.3em;

            font-weight: bold;

            margin: 0 0 0.5em

        }

        img {

            height: auto;

            max-width: 100%

        }

        table {

            border-collapse: collapse;

            border-spacing: 0;

            width: 100%

        }

        table thead {

            background: #edf0f1

        }

        table thead th {

            padding: 0.3em

        }

        table tbody td {

            padding: 0.3em

        }

</style>

</head>

<body>

                <div id="smcWindow">

                                <div>Mr J Smith<br />

123 Ficticious Street<br />

Somewhere<br />

Someplace<br />

SW7 1AC<br />

<br />

</div><div class="pos-1740">Reference number: <strong class="font-tr10b">1234567890</strong></div><div class="pos-1740">31 January 2019</div>

Dear Mr Smith<br />

<div class="bodystart">

Thank you for being awesome! We really appreciate it.

</div>

<br />

<div class="no-break-line">

Last year you were super!

</div><br />

<div class="bodystart">

This year you will be even more awesome!<br /><br />

Thank you for being who you are.

</div>

Yours sincerely<br /><br /><br /><br />

E Windsor<br />

Chrome CSS checking Service

                </div>

</body>

</html>
            """


            val base64 = Base64.encodeToString(data.toByteArray(), Base64.DEFAULT)
            webView.loadData(base64, "text/html; charset=utf-8", "base64")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
