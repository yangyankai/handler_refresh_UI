/*
 * Copyright (c) 2015-2015 by Shanghai shootbox Information Technology Co., Ltd.
 * Create: 2015/9/15 4:56:14
 * Project: T_hander_update_UI
 * File: MainActivity.java
 * Class: MainActivity
 * Module: app
 * Author: yangyankai
 * Version: 1.0
 */

package com.mob.t_hander_update_ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener
{
	private TextView text;
	private Button   changeText;
	public static final int     UPDATE_TEXT = 1;
	private             Handler handler     = new Handler()
	{

		public void handleMessage(Message msg)
		{
			switch (msg.what)
			{

				case UPDATE_TEXT:
					text.setText("NICE TO MEET YOU");
					break;
				default:
					Log.e("aaa", "≤‚ ‘");
					break;
			}
		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		text = (TextView) findViewById(R.id.text);
		changeText = (Button) findViewById(R.id.change_text);
		changeText.setOnClickListener(this);
	}

	@Override
	public void onClick(View v)
	{
		switch (v.getId())
		{
			case R.id.change_text:
				new Thread(new Runnable()
				{
					@Override
					public void run()
					{
						Message message = new Message();
						message.what = UPDATE_TEXT;

						handler.sendMessage(message);
						//						text.setText("Nice to meet you");
					}
				}).start();
				break;
			default:
				break;
		}
	}
}