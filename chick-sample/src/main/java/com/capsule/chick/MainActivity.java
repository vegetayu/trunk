package com.capsule.chick;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import capsule.chick.click.ItemClickListener;
import capsule.chick.decor.HeadDecor;
import com.capsule.chick.base.BaseActivity;
import com.capsule.chick.func.anim.AnimActivity;
import com.capsule.chick.func.click.ClickActivity;
import com.capsule.chick.func.divider.DividerActivity;
import com.capsule.chick.func.empty.EmptyActivity;
import com.capsule.chick.func.expand.ExpandActivity;
import com.capsule.chick.func.foot.FootActivity;
import com.capsule.chick.func.head.HeadActivity;
import com.capsule.chick.func.load.LoadActivity;
import com.capsule.chick.func.multi.MultipleActivity;
import com.capsule.chick.repo2.Repository;
import com.facebook.stetho.Stetho;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setTitle("主页");
    initView();
    Repository.init();
    Stetho.initializeWithDefaults(getApplicationContext());
  }

  @Override protected int onGetLayoutId() {
    return R.layout.activity_main;
  }

  private void initView() {
    RecyclerView recyclerView = findViewById(R.id.recycler);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.addOnItemTouchListener(new ItemClickListener() {
      @Override public void onItemClick(RecyclerView.ViewHolder vh, int position, View childView) {
        startByPosition(position);
      }
    });
    recyclerView.addItemDecoration(new HeadDecor(R.layout.layout_head, true));

    MainAdapter adapter = new MainAdapter();
    recyclerView.setAdapter(adapter);

    adapter.setData(mockData());
    adapter.notifyDataSetChanged();
  }

  private List<String> mockData() {
    List<String> list = new ArrayList<>();
    list.add("Animator");
    list.add("ClickListener");
    list.add("Divider");
    list.add("EmptyView");
    list.add("Expand");
    list.add("Footer");
    list.add("Header");
    list.add("Level");
    list.add("LoadMore");
    list.add("MultipleItemType");
    list.add("...");
    list.add("...");
    list.add("...");
    list.add("...");
    list.add("...");
    return list;
  }

  private void startByPosition(int position) {
    Intent intent = null;
    switch (position) {
      case 0:
        intent = new Intent(this, AnimActivity.class);
        break;
      case 1:
        intent = new Intent(this, ClickActivity.class);
        break;
      case 2:
        intent = new Intent(this, DividerActivity.class);
        break;
      case 3:
        intent = new Intent(this, EmptyActivity.class);
        break;
      case 4:
        intent = new Intent(this, ExpandActivity.class);
        break;
      case 5:
        intent = new Intent(this, FootActivity.class);
        break;
      case 6:
        intent = new Intent(this, HeadActivity.class);
        break;
      case 7:
        //intent = new Intent(this, LevelActivity.class);
        break;
      case 8:
        intent = new Intent(this, LoadActivity.class);
        break;
      case 9:
        intent = new Intent(this, MultipleActivity.class);
        break;

      default:
        return;
    }
    startActivity(intent);
  }
}
