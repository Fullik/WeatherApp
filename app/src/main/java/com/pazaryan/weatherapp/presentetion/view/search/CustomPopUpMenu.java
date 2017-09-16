package com.pazaryan.weatherapp.presentetion.view.search;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.pazaryan.weatherapp.R;
import com.pazaryan.weatherapp.data.entity.autoComplete.AutoComplete;

import java.util.List;

/**
 * Created by Погос Азарян on 14.09.2017.
 */

public class CustomPopUpMenu extends PopupWindow implements CountryAdapter.OnItemClickedListener {
    private CountryAdapter adapter;
    private OnItemClickedListener listener;

    public CustomPopUpMenu(Context context) {
        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.popupmenu_countries, null);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter = new CountryAdapter(this);
        recyclerView.setAdapter(adapter);
        setDialogProperties(view);
    }

    public void setData(List<AutoComplete> list) {
        if (list.size() == 0) {
            dismiss();
            return;
        }
        adapter.setData(list);
    }

    public void setListener(OnItemClickedListener listener) {
        this.listener = listener;
    }

    private void setDialogProperties(View view) {
        setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        setHeight(400);

        setFocusable(false);
        setContentView(view);
        setOutsideTouchable(true);
        setOnDismissListener(() -> adapter.clear());
        setBackgroundDrawable(new BitmapDrawable(null, ""));
    }

    @Override
    public void onItemClicked(AutoComplete autoComplete) {
        if (listener != null) {
            listener.onItemClicked(autoComplete);
            dismiss();
        }
    }

    public interface OnItemClickedListener {
        void onItemClicked(AutoComplete autoComplete);
    }
}
