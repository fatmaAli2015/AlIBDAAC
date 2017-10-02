package com.example.fatmaali.alibdaac;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Locale;

public class GalleryPestControl extends AppCompatActivity {
    ListView listViewHome;
    TextView titleHome;
    int[] image = {R.drawable.super2000, R.drawable.minifoggerkb100, R.drawable.bf200};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_pest_control);
        titleHome = (TextView) findViewById(R.id.textItemtitle);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img1);
        titleHome.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));

        listViewHome = (ListView) findViewById(R.id.listHomeGalleryPest);
        final String[] indexHome = getResources().getStringArray(R.array.indexPestGallery);
        ArrayList<listitem> listImages = new ArrayList<>();
        for (int k = 0; k < indexHome.length; k++) {
            listImages.add(new listitem(k, image[k], indexHome[k]));
        }
        ListAdapter1 listAdapter = new ListAdapter1(listImages);
        listViewHome.setAdapter(listAdapter);

        listViewHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for (int l = 0; l < indexHome.length; l++) {
                    if (l == 0) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(GalleryPestControl.this);
                        builder.setMessage("Do you want to use the device ?");
                        builder.setTitle("AlIBDAA-CC");
                        builder.setIcon(R.drawable.ic_ac_unit_black_24dp);
                        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                try {
                                    String txt = " this is my required ";
                                    Intent emailshare = new Intent(Intent.ACTION_SEND);
                                    emailshare.setData(Uri.parse("mailto"));
                                    emailshare.setType("message/rfc822");
                                    String[] email = {"info@alibdaapcc.com"};
                                    emailshare.putExtra(Intent.EXTRA_EMAIL, email);
                                    emailshare.putExtra(Intent.EXTRA_SUBJECT, "Required for using Super-2000");
                                    emailshare.putExtra(Intent.EXTRA_TEXT, txt);
                                    Intent chooser = Intent.createChooser(emailshare, "launch Email");
                                    startActivity(chooser);
                                    startActivity(emailshare);
                                } catch (Exception e) {
                                    Toast.makeText(getApplicationContext(), "No found this app", Toast.LENGTH_LONG).show();
                                }
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                Intent intent = new Intent(getApplicationContext(), GalleryPestControl.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                            }
                        }).show();
                    }
                  else   if (l == 1) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(GalleryPestControl.this);
                        builder.setMessage("Do you want to use the device ?");
                        builder.setTitle("AlIBDAA-CC");
                        builder.setIcon(R.drawable.ic_ac_unit_black_24dp);
                        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                try {
                                    String txt = " this is my required ";
                                    Intent emailshare = new Intent(Intent.ACTION_SEND);
                                    emailshare.setData(Uri.parse("mailto"));
                                    emailshare.setType("message/rfc822");
                                    String[] email = {"info@alibdaapcc.com"};
                                    emailshare.putExtra(Intent.EXTRA_EMAIL, email);
                                    emailshare.putExtra(Intent.EXTRA_SUBJECT, "Required for using MINI Mist Fogger");
                                    emailshare.putExtra(Intent.EXTRA_TEXT, txt);
                                    Intent chooser = Intent.createChooser(emailshare, "launch Email");
                                    startActivity(chooser);
                                    startActivity(emailshare);
                                } catch (Exception e) {
                                    Toast.makeText(getApplicationContext(), "No found this app", Toast.LENGTH_LONG).show();
                                }
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                Intent intent = new Intent(getApplicationContext(), GalleryPestControl.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                            }
                        }).show();
                    } else if (l == 2) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(GalleryPestControl.this);
                        builder.setMessage("Do you want to use the device ?");
                        builder.setTitle("AlIBDAA-CC");
                        builder.setIcon(R.drawable.ic_ac_unit_black_24dp);
                        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                try {
                                    String txt = " this is my required ";
                                    Intent emailshare = new Intent(Intent.ACTION_SEND);
                                    emailshare.setData(Uri.parse("mailto"));
                                    emailshare.setType("message/rfc822");
                                    String[] email = {"info@alibdaapcc.com"};
                                    emailshare.putExtra(Intent.EXTRA_EMAIL, email);
                                    emailshare.putExtra(Intent.EXTRA_SUBJECT, "Required for using Best Fogger");
                                    emailshare.putExtra(Intent.EXTRA_TEXT, txt);
                                    Intent chooser = Intent.createChooser(emailshare, "launch Email");
                                    startActivity(chooser);
                                    startActivity(emailshare);
                                } catch (Exception e) {
                                    Toast.makeText(getApplicationContext(), "No found this app", Toast.LENGTH_LONG).show();
                                }
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                Intent intent = new Intent(getApplicationContext(), GalleryPestControl.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                            }
                        }).show();
                    }
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        GalleryPestControl.this.finish();
        Intent intent = new Intent(getApplicationContext(), PestControl.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
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
            View view1 = layoutInflater.inflate(R.layout.single_griditem, null);
            TextView id = (TextView) view1.findViewById(R.id.textItemId);
            TextView title = (TextView) view1.findViewById(R.id.textItem);
            ImageView img = (ImageView) view1.findViewById(R.id.imageView_RowItem);
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img1);
            title.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
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
        Intent intent = new Intent(getApplicationContext(), GalleryPestControl.class);
        startActivity(intent);

    }

    public void English(View view) {
        setLocal("en");
    }

    public void Arabic(View view) {
        setLocal("ar");
    }

}


