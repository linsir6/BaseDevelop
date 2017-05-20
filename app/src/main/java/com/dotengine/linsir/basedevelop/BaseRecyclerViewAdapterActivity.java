package com.dotengine.linsir.basedevelop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *  Created by linSir 
 *  date at 2017/5/20.
 *  describe:      
 */

public class BaseRecyclerViewAdapterActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view) RecyclerView recyclerView;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter);
        ButterKnife.bind(this);
        MultipleItem item1 = new MultipleItem(1, "aaa");
        MultipleItem item2 = new MultipleItem(1, "bbb");
        MultipleItem item3 = new MultipleItem(1, "ccc");
        MultipleItem item4 = new MultipleItem(1, "ddd");

        MultipleItem item5 = new MultipleItem(2, "");
        MultipleItem item6 = new MultipleItem(2, "");


        List<MultipleItem> list = new ArrayList<MultipleItem>();

        list.add(item1);
        list.add(item2);
        list.add(item5);
        list.add(item3);
        list.add(item4);
        list.add(item6);


        MultipleItemQuickAdapter adapter = new MultipleItemQuickAdapter(list);
        adapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                if (position == 2 || position == 5) {
                    return 4;
                } else {
                    return 2;
                }
            }
        });
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        recyclerView.setAdapter(adapter);

        //轻松实现多种布局，点击事件等
        //添加动画等


        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {//item点击事件
            @Override public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(BaseRecyclerViewAdapterActivity.this, "点击了" + position, Toast.LENGTH_SHORT).show();
            }
        });

        //adapter.addHeaderView();添加headerview

        //可以优化Adapter代码
        //添加Item事件
        //添加列表加载动画
        //添加头部、尾部
        //自动加载
        //添加分组
        //自定义不同的item类型
        //设置空布局
        //添加拖拽、滑动删除
        //分组的伸缩栏
        //自定义ViewHolder
    }

    public class MultipleItem implements MultiItemEntity {
        public static final int TEXT = 1;
        public static final int IMG = 2;
        public String text;
        private int itemType;

        public MultipleItem(int itemType, String text) {
            this.itemType = itemType;
            this.text = text;
        }

        @Override
        public int getItemType() {
            return itemType;
        }
    }

    public class MultipleItemQuickAdapter extends BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder> {

        public MultipleItemQuickAdapter(List data) {
            super(data);
            addItemType(MultipleItem.TEXT, R.layout.item_recycler_view);
            addItemType(MultipleItem.IMG, R.layout.item_recycler_view2);
        }

        @Override
        protected void convert(BaseViewHolder helper, MultipleItem item) {
            switch (helper.getItemViewType()) {
                case MultipleItem.TEXT:
                    helper.setText(R.id.text, item.text);
                    break;
                case MultipleItem.IMG:
                    //可以在这里面设置图片，现在默认是背景图片
                    break;
            }
        }

    }

}
