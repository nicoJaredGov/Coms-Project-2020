/*package com.example.newproject2020.orders;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.newproject2020.PHPRequest;
import com.example.newproject2020.RegSharedPrefs;
import com.example.newproject2020.RequestHandler;
import com.example.project2020.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TestActivity2 extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    String employeeID, employeeName, restaurant;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    OrderAdapter adapter;
    View listItemsView;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);

        sharedPreferences = getSharedPreferences(RegSharedPrefs.SHARED_PREFS, Context.MODE_PRIVATE);
        employeeID = sharedPreferences.getString(RegSharedPrefs.ID_NUM, "");
        employeeName = sharedPreferences.getString(RegSharedPrefs.FNAME, "")
                + sharedPreferences.getString(RegSharedPrefs.LNAME, "");
        restaurant = sharedPreferences.getString(RegSharedPrefs.RESTAURANT, "");

        loadOrders();
    }
    public void loadOrders(){
        PHPRequest request = new PHPRequest("https://lamp.ms.wits.ac.za/home/s2067058/");
        ContentValues cv = new ContentValues();
        cv.put("empID",1);
        cv.put("choice",1);

        request.doRequest(this, "fetchOrders.php", cv, new RequestHandler() {
            @Override
            public void processResponse(String response) throws JSONException {

            }
        });
    }

    public ArrayList<Order> processJSON(String response) throws JSONException {
}
}
 */