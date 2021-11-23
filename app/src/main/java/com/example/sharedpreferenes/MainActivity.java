package com.example.sharedpreferenes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.sharedpreferenes", Context.MODE_PRIVATE);
       ArrayList<String> friends = new ArrayList<String>();
        friends.add("Yashwanth");
        friends.add("Prajwal");
        friends.add("Sujan");
        try {

            sharedPreferences.edit().putString("friends",ObjectSerializer.serialize(friends)).apply();
            Log.i("friends",ObjectSerializer.serialize(friends));
        }catch (Exception e){
            e.printStackTrace();
        }

        ArrayList<String> newFriends = new ArrayList<String>();
        try {
            newFriends = (ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("friends",ObjectSerializer.serialize(new ArrayList<String>())));
        }catch (Exception e){
            e.printStackTrace();
        }Log.i("new Friends",newFriends.toString());
        //sharedPreferences.edit().putString("username","Yashwanth").apply();
        //String userName = sharedPreferences.getString("username","");
        //Log.i("This is The username",userName);
    }
}