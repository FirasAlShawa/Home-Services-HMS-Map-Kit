package com.wz.android.mapdemo;
        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.TextView;


        import java.util.ArrayList;

public class Adapter_Category extends BaseAdapter {

    private Context context;
    private ArrayList<Category> categoryArrayList;

    public Adapter_Category(Context context, ArrayList<Category> categoryArrayList) {
        this.context = context;
        this.categoryArrayList = categoryArrayList;
    }

    @Override
    public int getCount() {
        return categoryArrayList.size();
    }

    @Override
    public Category getItem(int position) {
        return categoryArrayList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.rounded_gridview_item,viewGroup,false);
        }

        TextView Title = view.findViewById(R.id.CategoryTitle);

        Title.setText(categoryArrayList.get(position).getTitle());

        return view;
    }
}
