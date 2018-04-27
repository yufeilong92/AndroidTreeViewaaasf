package com.example.customtreeviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.customtreeviewdemo.bean.MyNodeBean;
import com.example.customtreeviewdemo.tree.Node;
import com.example.customtreeviewdemo.tree.TreeListViewAdapter.OnTreeNodeClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

	private ListView treeLv;
	private Button checkSwitchBtn;
	private MyTreeListViewAdapter<MyNodeBean> adapter;
	private List<MyNodeBean> mDatas = new ArrayList<MyNodeBean>();
	//标记是显示Checkbox还是隐藏
	private boolean isHide = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initDatas();
		treeLv = (ListView) this.findViewById(R.id.tree_lv);
		checkSwitchBtn = (Button)this.findViewById(R.id.check_switch_btn);
		
		checkSwitchBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				if(isHide){
					isHide = false;
				}else{
					isHide = true;
				}
				
				adapter.updateView(isHide);
			}
			
		});
		try {
			adapter = new MyTreeListViewAdapter<MyNodeBean>(treeLv, this,
					mDatas, 10, isHide);
			adapter.setOnTreeNodeClickListener(new OnTreeNodeClickListener() {
				@Override
				public void onClick(Node node, int position) {
					if (node.isLeaf()) {
						Toast.makeText(getApplicationContext(), node.getName(),
								Toast.LENGTH_SHORT).show();
					}else {
						treeLv.setSelectionFromTop(position,0);
						Toast.makeText(MainActivity .this,"2222",Toast.LENGTH_SHORT).show();
					}
				}

				@Override
				public void onCheckChange(Node node, int position,
						List<Node> checkedNodes) {
					// TODO Auto-generated method stub

					StringBuffer sb = new StringBuffer();
					for (Node n : checkedNodes) {
						int pos = n.getId() - 1;
						sb.append(mDatas.get(pos).getName()).append("---")
								.append(pos + 1).append(";");

					}

					Toast.makeText(getApplicationContext(), sb.toString(),
							Toast.LENGTH_SHORT).show();
				}

			});
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		treeLv.setAdapter(adapter);

	}

	private void initDatas() {
		mDatas.add(new MyNodeBean(1, 0, "中国古代"));
		mDatas.add(new MyNodeBean(2, 1, "唐朝唐朝唐朝唐朝"));
		mDatas.add(new MyNodeBean(3, 1, "宋朝"));
		mDatas.add(new MyNodeBean(4, 1, "明朝"));
		mDatas.add(new MyNodeBean(5, 3, "李世民"));
		mDatas.add(new MyNodeBean(6, 3, "李白"));
		mDatas.add(new MyNodeBean(5, 3, "李世民"));
		mDatas.add(new MyNodeBean(6, 3, "李白"));mDatas.add(new MyNodeBean(5, 3, "李世民"));
		mDatas.add(new MyNodeBean(6, 3, "李白"));mDatas.add(new MyNodeBean(5, 3, "李世民"));
		mDatas.add(new MyNodeBean(6, 3, "李白"));mDatas.add(new MyNodeBean(5, 3, "李世民"));
		mDatas.add(new MyNodeBean(6, 3, "李白"));mDatas.add(new MyNodeBean(5, 3, "李世民"));
		mDatas.add(new MyNodeBean(6, 3, "李白"));mDatas.add(new MyNodeBean(5, 3, "李世民"));
		mDatas.add(new MyNodeBean(6, 3, "李白"));mDatas.add(new MyNodeBean(5, 3, "李世民"));
		mDatas.add(new MyNodeBean(6, 3, "李白"));mDatas.add(new MyNodeBean(5, 3, "李世民"));
		mDatas.add(new MyNodeBean(6, 3, "李白"));mDatas.add(new MyNodeBean(5, 3, "李世民"));
		mDatas.add(new MyNodeBean(6, 3, "李白"));mDatas.add(new MyNodeBean(5, 3, "李世民"));
		mDatas.add(new MyNodeBean(6, 3, "李白"));mDatas.add(new MyNodeBean(5, 3, "李世民"));
		mDatas.add(new MyNodeBean(6, 3, "李白"));mDatas.add(new MyNodeBean(5, 3, "李世民"));
		mDatas.add(new MyNodeBean(6, 3, "李白"));mDatas.add(new MyNodeBean(5, 3, "李世民"));
		mDatas.add(new MyNodeBean(6, 3, "李白"));mDatas.add(new MyNodeBean(5, 3, "李世民"));
		mDatas.add(new MyNodeBean(6, 3, "李白"));mDatas.add(new MyNodeBean(5, 3, "李世民"));
		mDatas.add(new MyNodeBean(6, 3, "李白"));mDatas.add(new MyNodeBean(5, 3, "李世民"));
		mDatas.add(new MyNodeBean(6, 3, "李白"));mDatas.add(new MyNodeBean(5, 3, "李世民"));
		mDatas.add(new MyNodeBean(6, 3, "李白"));mDatas.add(new MyNodeBean(5, 3, "李世民"));
		mDatas.add(new MyNodeBean(6, 3, "李白"));mDatas.add(new MyNodeBean(5, 3, "李世民"));
		mDatas.add(new MyNodeBean(6, 3, "李白"));mDatas.add(new MyNodeBean(5, 3, "李世民"));
		mDatas.add(new MyNodeBean(6, 3, "李白"));
		mDatas.add(new MyNodeBean(7, 4, "赵匡胤"));
		mDatas.add(new MyNodeBean(8, 4, "苏轼"));

		mDatas.add(new MyNodeBean(9, 5, "朱元璋"));
		mDatas.add(new MyNodeBean(10, 5, "唐伯虎"));
		mDatas.add(new MyNodeBean(11, 4, "文征明"));
		mDatas.add(new MyNodeBean(12, 6, "赵建立"));
		mDatas.add(new MyNodeBean(13, 6, "苏东东"));
		mDatas.add(new MyNodeBean(14, 18, "秋香"));
	}
}
