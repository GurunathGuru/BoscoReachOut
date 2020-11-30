package com.integro.boscoreachout.activities;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.integro.boscoreachout.R;
import com.integro.boscoreachout.adapters.SlidePageAdapter;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    FragmentManager fragmentManager;

    LinearLayout llCall, llMail, llFacebook,llYoutube,llTwitter,llDirectorMsg;
    TextView tvDonate,TvGallery,tvContactUs;
     ImageView ivDbi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        llFacebook=findViewById(R.id.ll_facebbok);
        llTwitter=findViewById(R.id.ll_twitter);
        llYoutube=findViewById(R.id.ll_youtube);
        llDirectorMsg=findViewById(R.id.ll_DirectirMsg);
        tvDonate=findViewById(R.id.tv_Donaten);
        tvContactUs=findViewById(R.id.tv_ContactUs);
        ivDbi=findViewById(R.id.iv_Dbi);

        fragmentManager = getSupportFragmentManager();
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.vpSlide);
        viewPager.setAdapter(new SlidePageAdapter(fragmentManager));

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.newsletter2);
        tabLayout.getTabAt(2).setIcon(R.drawable.announcements);
        tabLayout.getTabAt(3).setIcon(R.drawable.web2);

        final int selectedColor = ContextCompat.getColor(getApplicationContext(), R.color.colorYellow);
        final int unSelectedColor = ContextCompat.getColor(getApplicationContext(), R.color.colorWhite);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(selectedColor, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(unSelectedColor, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(unSelectedColor, PorterDuff.Mode.SRC_IN);
            }
        });
       /* llCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                final CharSequence[] phone = new CharSequence[]{"8156956995"};
                String phone1 = "8156956995";
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone1, null));
                startActivity(intentCall);
            }
        });

        llMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mailintent = new Intent(Intent.ACTION_VIEW);
                Uri data = Uri.parse("mailto:?subject" + " " + "&body" + " " + "&to=" + "1User@domain.com");
                mailintent.setData(data);
                startActivity(mailintent);
            }*
        });*/
        llFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFacebbok = new Intent(Intent.ACTION_VIEW);
                Uri data = Uri.parse("https://www.facebook.com/boscoreachout.fb/");
                intentFacebbok.setData(data);
                startActivity(intentFacebbok);
            }
        });
       /* llTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTwitter = new Intent(Intent.ACTION_VIEW);
                Uri data = Uri.parse("https://www.facebook.com/Good-Shepherd-Bangalore-425035744745798/");
                intentTwitter.setData(data);
                startActivity(intentTwitter);
            }
        });*/
       ivDbi.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intentDbi = new Intent(Intent.ACTION_VIEW);
               Uri data = Uri.parse("http://donboscointernational.eu/");
               intentDbi.setData(data);
               startActivity(intentDbi);
           }
       });
        llYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentYoutube = new Intent(Intent.ACTION_VIEW);
                Uri data = Uri.parse("https://www.youtube.com/channel/UCIjauv2AWtS3h01g6hPH_ww/videos");
                intentYoutube.setData(data);
                startActivity(intentYoutube);
            }
        });
        llDirectorMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDirectorMsg =new Intent(MainActivity.this,DirectorMsgActivity.class);
                startActivity(intentDirectorMsg);
            }
        });
        tvContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContactUs();
            }
        });
    }
    public void getContactUs() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        View view = getLayoutInflater().inflate(R.layout.dilouge_contact_us, null);
        alertDialogBuilder.setView(view);
        final AlertDialog alertDialog = alertDialogBuilder.create();
        TextView tvAddress=view.findViewById(R.id.tv_Address);
        TextView tvPhone = view.findViewById(R.id.tvPhone);
        TextView tvEmail = view.findViewById(R.id.tvEmail);
        TextView tvMap = view.findViewById(R.id.tvMap);


        tvPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                final CharSequence[] phone = new CharSequence[]{"0134024567"};
                String phone1 = "0134024567";
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone1, null));
                startActivity(intentCall);
            }
        });

        tvEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mailintent = new Intent(Intent.ACTION_VIEW);
                Uri data = Uri.parse("mailto:?subject" + " " + "&body" + " " + "&to=" + "User@domain.com");
                mailintent.setData(data);
                startActivity(mailintent);
            }
        });

        tvMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Map = "Bosco Seva Kendra";
                String uri = "https://www.google.com/maps/dir//Bosco+Reach+Out,+Dr+BK+KAkati+Road,+Ulubari,+Guwahati,+Assam+781007/@26.1716349,91.7551786,15z/data=!4m8!4m7!1m0!1m5!1m1!1s0x375a597f931fe96b:0x26cb3959cfb69105!2m2!1d91.7551786!2d26.1716349" + Map;
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });
        alertDialog.show();
    }

 /*   @SuppressLint({"LongLogTag", "IntentReset"})
    public void sendEmail() {
        Intent mailIntent = new Intent(Intent.ACTION_VIEW);
        Uri data = Uri.parse("mailto:?subject=" + " " + "&body=" + " " + "&to=" + "info@bosconet.in");
        mailIntent.setData(data);
        startActivity(Intent.createChooser(mailIntent, "Send mail..."));
*/




    public void onBackPressed () {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            alertDialogBuilder.setTitle("Exit");
            AlertDialog.Builder builder = alertDialogBuilder.setMessage("Do you really want to exit?").setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //System.exit(0);
                            finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
            //super.onBackPressed();
        }

    }
