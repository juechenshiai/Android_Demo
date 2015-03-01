package com.example.listbuttontest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends ActionBarActivity
{
	private List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	private List<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();
	
	private ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		String[] aa = new String[]{"111","222","333","444","555","666","777","888","999"};
		for(int i = 0; i < aa.length; i++)
		{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("num", aa[i]);
			list1.add(map);
			list.addAll(list1);
		}
		
		System.out.println(list);
		listView = (ListView)findViewById(R.id.listView1);
//		getinfomation();
		MySimpleAdapter adapter = new MySimpleAdapter(MainActivity.this, list, R.layout.list_item, new String[]{"num"}, new int[]{R.id.textView1});
		listView.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if(id == R.id.action_settings)
		{
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	private void getinfomation()
	{

		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				Message msg = new Message();
				msg.what = 0;
				mHandler.sendMessage(msg); // 向Handler发送消息,更新UI
			}
		}).start();

	}
	private Handler mHandler = new Handler()
	{
		public void handleMessage(Message msg)
		{
			switch (msg.what)
			{
			case 0:
				MySimpleAdapter adapter = new MySimpleAdapter(MainActivity.this, list, R.layout.list_item, new String[]{"num"}, new int[]{R.id.textView1});
				listView.setAdapter(adapter);
			}
		};
	};
}
