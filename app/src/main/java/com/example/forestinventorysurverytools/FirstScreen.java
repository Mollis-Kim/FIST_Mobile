package com.example.forestinventorysurverytools;

import android.Manifest;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.forestinventorysurverytools.ui.userguide.UserGuide;
import com.google.ar.core.ArCoreApk;
import com.google.ar.core.Session;
import com.google.ar.core.exceptions.UnavailableApkTooOldException;
import com.google.ar.core.exceptions.UnavailableArcoreNotInstalledException;
import com.google.ar.core.exceptions.UnavailableDeviceNotCompatibleException;
import com.google.ar.core.exceptions.UnavailableSdkTooOldException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;

import java.util.Objects;

public class FirstScreen extends AppCompatActivity implements View.OnClickListener {

    //TextView
    TextView mTitle;
    TextView mSub_title;
    TextView mContent;

    public EditText mInputUserID;
    public EditText mDate;
    public EditText mPlace;


    //Values
    public String userDefaultID = "홍길동";
    public String defaultDate = "20201026";
    public String defaultPlace = "한라산";


    //ImageView
    ImageView mKfs_mark;
    ImageView mKnu_mark;
    ImageView mNotice;


    //Permission
    boolean mCamPerm;
    boolean mWritePerm;
    boolean mReadPerm;
    boolean mLocatePerm;


    //Button
    Button mGuide_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstscreen);

        //TextView
        mTitle = (TextView) findViewById(R.id.title);
        mSub_title = (TextView) findViewById(R.id.sub_title);
        mContent = (TextView) findViewById(R.id.content);
        //mInputUserID = (EditText) findViewById(R.id.userID);
        //mDate = (EditText) findViewById(R.id.date);
        //mPlace = (EditText) findViewById(R.id.place);

        //EditText default values
        //date
//        mDate.setText(defaultDate);
//        mDate.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (mDate.getText().toString().equals(defaultDate)) {
//                    mDate.setText("");
//                }
//                return false;
//            }
//        });

//        mDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (!hasFocus && TextUtils.isEmpty(mDate.getText().toString())) {
//                    mDate.setText(defaultDate);
//                } else if (hasFocus && mDate.getText().toString().equals(defaultDate)) {
//                    mDate.setText("");
//                }
//            }
//        });


        //place
//        mPlace.setText(defaultPlace);
//        mPlace.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (mPlace.getText().toString().equals(defaultPlace)) {
//                    mPlace.setText("");
//                }
//                return false;
//            }
//        });

//        mPlace.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (!hasFocus && TextUtils.isEmpty(mPlace.getText().toString())) {
//                    mPlace.setText(defaultPlace);
//                } else if (hasFocus && mPlace.getText().toString().equals(defaultPlace)) {
//                    mPlace.setText("");
//                }
//            }
//        });
//
//        mPlace.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//
//                if ((event.getAction() == KeyEvent.ACTION_DOWN) && keyCode == KeyEvent.KEYCODE_ENTER) {
//                    mInputUserID.requestFocus();
//                    return true;
//                }
//                return false;
//            }
//        });


        //userID
//        mInputUserID.setText(userDefaultID);
//        mInputUserID.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (mInputUserID.getText().toString().equals(userDefaultID)) {
//                    mInputUserID.setText("");
//                }
//                return false;
//            }
//        });
//
//        mInputUserID.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (!hasFocus && TextUtils.isEmpty(mInputUserID.getText().toString())) {
//                    mInputUserID.setText(userDefaultID);
//                } else if (hasFocus && mInputUserID.getText().toString().equals(userDefaultID)) {
//                    mInputUserID.setText("");
//                }
//            }
//        });
//
//        mInputUserID.setImeOptions(EditorInfo.IME_ACTION_DONE);
//        mInputUserID.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//
//                if (actionId == EditorInfo.IME_ACTION_DONE || event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
//                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                    inputMethodManager.hideSoftInputFromWindow(mInputUserID.getWindowToken(), 0);
//                    return true;
//                }
//                return false;
//            }
//        });


        //ImageView
        //mKfs_mark = (ImageView) findViewById(R.id.kfs_mark);
        //mKnu_mark = (ImageView) findViewById(R.id.knu_mark);
        mNotice = (ImageView) findViewById(R.id.notice);


        //Button
        mGuide_btn = (Button) findViewById(R.id.guide_btn);
        mGuide_btn.setOnClickListener(this);


        //Permission
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED) {
            mCamPerm = true;
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            mWritePerm = true;
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            mReadPerm = true;
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mLocatePerm = true;
        }

        if (!mCamPerm || mWritePerm || mReadPerm || mLocatePerm) {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.CAMERA,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }
    }


    @Override
    public void onClick(View v) {
        if (v == mGuide_btn) {

            Intent intent = new Intent(getApplicationContext(), UserGuide.class);
            startActivity(intent);
        }
    }

    public void onRequestPermissionsResults(int requsetCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requsetCode, permissions, grantResults);
        if (requsetCode == 1 && grantResults.length > 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                mCamPerm = true;
            if (grantResults[1] == PackageManager.PERMISSION_GRANTED)
                mWritePerm = true;
            if (grantResults[2] == PackageManager.PERMISSION_GRANTED)
                mLocatePerm = true;
        }
    }
}
