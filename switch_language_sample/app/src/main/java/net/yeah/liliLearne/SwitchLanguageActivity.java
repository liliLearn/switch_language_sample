package net.yeah.liliLearne;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import net.yeah.liliLearne.adapter.LanguageAdapter;
import net.yeah.liliLearne.model.LanguageBean;

import java.util.ArrayList;
import java.util.List;

public class SwitchLanguageActivity extends BaseActivity {
    private ListView mLanguageList;
    private LanguageAdapter adapter;
    private List<LanguageBean> languageList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_language);
        initView();
        initData();
        setEvent();
    }

    private void initView() {
        mLanguageList = (ListView) findViewById(R.id.language_list);
    }

    private void initData() {
        languageList = new ArrayList<>();
        languageList.add(new LanguageBean(0, "Auto", "", false));
        languageList.add(new LanguageBean(1, "简体中文", "zh", false));
        languageList.add(new LanguageBean(2, "繁体中文(台湾)", "zh-hant", false));
        languageList.add(new LanguageBean(3, "English", "en", false));
        languageList.add(new LanguageBean(4, "日本語", "ja", false));
        languageList.add(new LanguageBean(5, "意大利语", "it", false));
        languageList.add(new LanguageBean(5, "德语", "de", false));
        adapter = new LanguageAdapter(this, languageList);
        mLanguageList.setAdapter(adapter);
    }

    private void setEvent() {
        mLanguageList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                languageList.get(position).setSelected(true);
                adapter.notifyDataSetChanged();
                SharedPreferences preferences = getSharedPreferences("language", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("language", languageList.get(position).getShortName());
                editor.apply();
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}
