package com.example.fatmaali.alibdaac;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ListView listViewHome;
    int images[] = {R.drawable.ic_info_24dp, R.drawable.ic_assignment_black_24dp, R.drawable.ic_pest_control1,
            R.drawable.ic_cleaning, R.drawable.ic_video_library_24dp, R.drawable.ic_contacts};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        listViewHome = (ListView) findViewById(R.id.listHome);
        final String[] indexHome = getResources().getStringArray(R.array.indexHome);
        ArrayList<listitem> listImages = new ArrayList<>();
        for (int k = 0; k < indexHome.length; k++) {
            listImages.add(new listitem(k, images[k], indexHome[k]));
        }
        ListAdapter1 listAdapter = new ListAdapter1(listImages);
        listViewHome.setAdapter(listAdapter);
        listViewHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                for (int j = 0; j < indexHome.length; j++) {
                    if (i == 0) {
                        Intent intentAboutUs = new Intent(getApplicationContext(), AboutUS.class);
                        startActivity(intentAboutUs);
                    }
                    if (i == 1) {
                        Intent intentBook = new Intent(getApplicationContext(), BookActivity.class);
                        startActivity(intentBook);                    }
                    if (i == 2) {
                        Intent intentPest = new Intent(getApplicationContext(), PestControl.class);
                        startActivity(intentPest);
                    }
                    if (i == 3) {
                        Toast.makeText(getApplicationContext(), "okey3", Toast.LENGTH_LONG).show();
                    }
                    if (i == 4) {
                        Toast.makeText(getApplicationContext(), "okey4", Toast.LENGTH_LONG).show();
                    }
                    if (i == 5) {
                        Toast.makeText(getApplicationContext(), "okey5", Toast.LENGTH_LONG).show();
                    }
                    if (i == 6) {
                        Toast.makeText(getApplicationContext(), "okey6", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("Do you want to exit ?");
        builder.setTitle("Exit Al-IBDAA");
        builder.setIcon(R.drawable.ic_ac_unit_black_24dp);
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                System.exit(0);
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Home) {
            Intent intentHom = new Intent(this, MainActivity.class);
            startActivity(intentHom);
        } else if (id == R.id.nav_AboutUs) {
            Intent intentAboutUs = new Intent(getApplicationContext(), AboutUS.class);
            startActivity(intentAboutUs);

        } else if (id == R.id.nav_ContactUs) {

        } else if (id == R.id.nav_News) {

        } else if (id == R.id.nav_Language) {
            Intent intentlanguage = new Intent(this, MainActivity.class);
            startActivity(intentlanguage);

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        } else if (id == R.id.nav_FaceBook) {

        } else if (id == R.id.nav_Twitter) {

        } else if (id == R.id.nav_Location) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    class ListAdapter1 extends BaseAdapter {
        ArrayList<listitem> list = new ArrayList<>();

        public ListAdapter1(ArrayList<listitem> listitems) {
            this.list = listitems;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = getLayoutInflater();
            View view1 = layoutInflater.inflate(R.layout.row_item, null);
            TextView id = (TextView) view1.findViewById(R.id.textItemId);
            TextView title = (TextView) view1.findViewById(R.id.textItem);
            ImageView img = (ImageView) view1.findViewById(R.id.imageView_RowItem);
            id.setText(String.valueOf(list.get(i).id));
            title.setText(list.get(i).title);
            img.setImageResource(list.get(i).img);
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
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);

    }

    public void English(View view) {
        setLocal("en");
    }

    public void Arabic(View view) {
        setLocal("ar");
    }

}
