package com.example.fatmaali.alibdaac;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class PestControl extends AppCompatActivity {
    ListView listViewPest;
    int images[]={R.drawable.ic_info_24dp,R.drawable.ic_menu_gallery};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pest_control);
        listViewPest=(ListView)findViewById(R.id.listViewPest);
        final String[] AboutUs =getResources().getStringArray(R.array.indexPest);
        ArrayList<listitem>listImages = new ArrayList<>();
        for (int i = 0; i <AboutUs.length ; i++) {
            listImages.add(new listitem(i,images[i],AboutUs[i]) );
        }
        ListAdapter1 listAdapter = new ListAdapter1(listImages);
        listViewPest.setAdapter(listAdapter);
        listViewPest.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,final int i, long l) {
                for (int j = 0; j <AboutUs.length ; j++) {
                    if(i==0){
                        Intent InfoPest =new Intent(getApplicationContext(),InfoPestControl.class);
                        startActivity(InfoPest);
                    }
                    else if(i==1){
                        Intent GalleryPest =new Intent(getApplicationContext(),GalleryPestControl.class);
                        startActivity(GalleryPest);
                    }
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        PestControl.this.finish();
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    class ListAdapter1 extends BaseAdapter {
        ArrayList<listitem> list1 = new ArrayList<>();

        public ListAdapter1(ArrayList<listitem> list1) {
            this.list1 = list1;
        }

        @Override
        public int getCount() {
            return list1.size();
        }

        @Override
        public Object getItem(int i) {
            return list1.get(i).title;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater ly = getLayoutInflater();
            View view1 = ly.inflate(R.layout.row_item, null);
            TextView id = (TextView) view1.findViewById(R.id.textItemId);
            TextView title = (TextView) view1.findViewById(R.id.textItem);
            ImageView img = (ImageView) view1.findViewById(R.id.imageView_RowItem);
            id.setText(String.valueOf(list1.get(i).id));
            title.setText(list1.get(i).title);
            img.setImageResource(list1.get(i).img);
            return view1;
        }
    }

    private void setLocal(String language) {
        Locale myLocale = new Locale(language);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        SharedPreferences preferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("lang", language);
        editor.commit();
        editor.putBoolean("isChooseLang", true);
        Intent intent = new Intent(getApplicationContext(), PestControl.class);
        startActivity(intent);

    }

    public void English(View view) {
        setLocal("en");
    }

    public void Arabic(View view) {
        setLocal("ar");
    }
}
