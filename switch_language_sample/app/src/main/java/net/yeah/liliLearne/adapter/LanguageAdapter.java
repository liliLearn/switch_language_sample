package net.yeah.liliLearne.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import net.yeah.liliLearne.R;
import net.yeah.liliLearne.model.LanguageBean;

import java.util.List;

public class LanguageAdapter extends BaseAdapter {
    private Context mContext;
    private List<LanguageBean> languageList;

    public LanguageAdapter(Context mContext, List<LanguageBean> languageList) {
        this.mContext = mContext;
        this.languageList = languageList;
    }

    @Override

    public int getCount() {
        return languageList.size();
    }

    @Override
    public Object getItem(int position) {
        return languageList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(mContext, R.layout.adapter_switch_language, null);
            viewHolder.selectedImage = convertView.findViewById(R.id.selected_img);
            viewHolder.languageFullName = convertView.findViewById(R.id.language_full_name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        LanguageBean languageBean = languageList.get(position);
        viewHolder.languageFullName.setText(languageBean.getFullName());
        if (languageBean.isSelected()) {
            viewHolder.selectedImage.setVisibility(View.VISIBLE);
        } else {
            viewHolder.selectedImage.setVisibility(View.GONE);
        }
        return convertView;
    }


    private class ViewHolder {
        ImageView selectedImage;
        TextView languageFullName;
    }
}
