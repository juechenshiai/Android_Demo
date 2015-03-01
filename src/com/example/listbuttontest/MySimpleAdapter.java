package com.example.listbuttontest;

import java.util.List;
import java.util.Map;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class MySimpleAdapter extends BaseAdapter {  
    private LayoutInflater mInflater;  
    private List<Map<String, Object>> list;  
    private int layoutID;  
    private String flag[];  
    private int ItemIDs[];  
    private Context context;
    public MySimpleAdapter(Context context, List<Map<String, Object>> list,  
            int layoutID, String flag[], int ItemIDs[]) {  
    	this.context = context;
        this.mInflater = LayoutInflater.from(context);  
        this.list = list;  
        this.layoutID = layoutID;  
        this.flag = flag;  
        this.ItemIDs = ItemIDs;  
    }  
    @Override  
    public int getCount() {  
        // TODO Auto-generated method stub  
        return list.size();  
    }  
    @Override  
    public Object getItem(int arg0) {  
        // TODO Auto-generated method stub  
        return 0;  
    }  
    @Override  
    public long getItemId(int arg0) {  
        // TODO Auto-generated method stub  
        return 0;  
    }  
    @Override  
    public View getView(int position, View convertView, ViewGroup parent) {  
        convertView = mInflater.inflate(layoutID, null);  
        for (int i = 0; i < flag.length; i++) {//备注1  
            if (convertView.findViewById(ItemIDs[i]) instanceof TextView) {  
                TextView tv = (TextView) convertView.findViewById(ItemIDs[i]);  
                tv.setText((String) list.get(position).get(flag[i]));  
            }
        }  
        addListener(convertView, position);  
        return convertView;  
    } 
	public void addListener(View convertView, final int position) {  
        ((Button)convertView.findViewById(R.id.button1)).setOnClickListener(  
                new View.OnClickListener() {  
                    @Override  
                    public void onClick(View v) {  
                        new AlertDialog.Builder(context)  
                        .setTitle("自定义通用SimpleAdapter")  
                        .setMessage(""+position+"")  
                        .show();  
                    }  
                });  
       
    }  

}
