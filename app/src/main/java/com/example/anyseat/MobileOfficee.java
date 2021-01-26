package com.example.anyseat;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MobileOfficee extends AppCompatActivity{
    SeatInfo[] seatInfos = new SeatInfo[12];
    String[] seatarray= {"L11",""};
    UserInfo user;
    SaveSharedPreference main;

    ArrayList<UserInfo> arrayList = new ArrayList<>();
    DatabaseReference mDatabase;
    private TextView profile_id;

    Button L11 ;
    Button L12 ;
    Button L21 ;
    Button L22 ;
    Button L31 ;
    Button L32 ;
    Button L41 ;
    Button L42 ;
    Button R1 ;
    Button R2 ;
    Button R3 ;
    Button R4 ;
    String Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_officee);
        Password = getIntent().getStringExtra("Password");

        L11 = (Button)findViewById(R.id.L11);
        L12 = (Button)findViewById(R.id.L12);
        L21 = (Button)findViewById(R.id.L21);
        L22 = (Button)findViewById(R.id.L22);
        L31 = (Button)findViewById(R.id.L31);
        L32 = (Button)findViewById(R.id.L32);
        L41 = (Button)findViewById(R.id.L41);
        L42 = (Button)findViewById(R.id.L42);
        R1 = (Button)findViewById(R.id.R1);
        R2 = (Button)findViewById(R.id.R2);
        R3 = (Button)findViewById(R.id.R3);
        R4 = (Button)findViewById(R.id.R4);

        profile_id = (TextView)findViewById(R.id.profile_id);

        final String[] nickName = new String[1];

        L11.setOnClickListener(new buttonlistener(MobileOfficee.this, Password));
        L12.setOnClickListener(new buttonlistener(MobileOfficee.this, Password));
        L21.setOnClickListener(new buttonlistener(MobileOfficee.this, Password));
        L22.setOnClickListener(new buttonlistener(MobileOfficee.this, Password));
        L31.setOnClickListener(new buttonlistener(MobileOfficee.this, Password));
        L32.setOnClickListener(new buttonlistener(MobileOfficee.this, Password));
        L41.setOnClickListener(new buttonlistener(MobileOfficee.this, Password));
        L42.setOnClickListener(new buttonlistener(MobileOfficee.this, Password));
        R1.setOnClickListener(new buttonlistener(MobileOfficee.this, Password));
        R2.setOnClickListener(new buttonlistener(MobileOfficee.this, Password));
        R3.setOnClickListener(new buttonlistener(MobileOfficee.this, Password));
        R4.setOnClickListener(new buttonlistener(MobileOfficee.this, Password));

        final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("SeatInfo").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                /*if(snapshot.exists()){
                    for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                        SeatInfo seatInfo = dataSnapshot.getValue(SeatInfo.class);
                        arrayList.add(seatInfo);
                    }
                }*/

                //L1-1
                int statusnum;
                statusnum = snapshot.child("L1-1").child("statusnum").getValue(Integer.class);
                if(statusnum == 1) L11.setText("사용 중");
                else L11.setText("빈 자리");

                //L1-2
                statusnum = snapshot.child("L1-2").child("statusnum").getValue(Integer.class);
                if(statusnum == 1) L12.setText("사용 중");
                else L12.setText("빈 자리");

                //L2-1
                statusnum = snapshot.child("L2-1").child("statusnum").getValue(Integer.class);
                if(statusnum == 1) L21.setText("사용 중");
                else L21.setText("빈 자리");

                //L2-2
                statusnum = snapshot.child("L2-2").child("statusnum").getValue(Integer.class);
                if(statusnum == 1) L22.setText("사용 중");
                else L22.setText("빈 자리");

                //L3-1
                statusnum = snapshot.child("L3-1").child("statusnum").getValue(Integer.class);
                if(statusnum == 1) L31.setText("사용 중");
                else L31.setText("빈 자리");

                //L3-2
                statusnum = snapshot.child("L3-2").child("statusnum").getValue(Integer.class);
                if(statusnum == 1) L32.setText("사용 중");
                else L32.setText("빈 자리");

                //L4-1
                statusnum = snapshot.child("L4-1").child("statusnum").getValue(Integer.class);
                if(statusnum == 1) L41.setText("사용 중");
                else L41.setText("빈 자리");

                //L4-2
                statusnum = snapshot.child("L4-2").child("statusnum").getValue(Integer.class);
                if(statusnum == 1) L42.setText("사용 중");
                else L42.setText("빈 자리");

                //R1
                statusnum = snapshot.child("R1").child("statusnum").getValue(Integer.class);
                if(statusnum == 1) R1.setText("사용 중");
                else R1.setText("빈 자리");

                //R2
                statusnum = snapshot.child("R2").child("statusnum").getValue(Integer.class);
                if(statusnum == 1) R2.setText("사용 중");
                else R2.setText("빈 자리");

                //R3
                statusnum = snapshot.child("R3").child("statusnum").getValue(Integer.class);
                if(statusnum == 1) R3.setText("사용 중");
                else R3.setText("빈 자리");

                //R4
                statusnum = snapshot.child("R4").child("statusnum").getValue(Integer.class);
                if(statusnum == 1) R4.setText("사용 중");
                else R4.setText("빈 자리");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        databaseReference.child("UserInfo").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                user = snapshot.child(Password).getValue(UserInfo.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //  mDatabase = FirebaseDatabase.getInstance().getReference();

        // 오픈채팅
        Button OpenKakaoButton = (Button)findViewById(R.id.OpenChatButton);
        OpenKakaoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ChatUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://open.kakao.com/o/sULfouRc/"));
                startActivity(ChatUrl);
            }
        });

        // 조직도
        Button Organizatino_Button = (Button)findViewById(R.id.Organization_Button);
        Organizatino_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MobileOfficee.this, Organization.class);
                startActivity(intent);
            }
        });

        // 과사 시간표
        Button OfficeTimeTable_Button = (Button)findViewById(R.id.OfficeTimeTable);
        OfficeTimeTable_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MobileOfficee.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.timetabledialog);
                dialog.show();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_mobileoffice, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.signOutMenu:
                FirebaseAuth.getInstance().signOut();
                SaveSharedPreference.clearUserName(((MainActivity)MainActivity.context));
                finish();
                return true;
            case R.id.userinfoMenu:
                AlertDialog.Builder userinfo = new AlertDialog.Builder(MobileOfficee.this);
                userinfo.setTitle("사용자 정보");
                userinfo.setMessage(user.toString());
                userinfo.show();
                return true;
        }
        return true;
    }
}