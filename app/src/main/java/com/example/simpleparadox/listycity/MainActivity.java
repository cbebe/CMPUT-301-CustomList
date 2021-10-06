package com.example.simpleparadox.listycity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    final String TAG = "Sample";
    FirebaseFirestore db;
    private ArrayAdapter<City> cityAdapter;
    private ArrayList<City> cityDataList;
    private EditText addCityEditText;
    private EditText addProvinceEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declare the variables so that you will be able to reference it later.
        final ListView cityList = findViewById(R.id.city_list);
        final Button addCityButton = findViewById(R.id.add_city_button);
        addCityEditText = findViewById(R.id.add_city_field);
        addProvinceEditText = findViewById(R.id.add_province_edit_text);


        cityDataList = new ArrayList<>();
        cityAdapter = new CustomList(this, cityDataList);
        cityList.setAdapter(cityAdapter);

        db = FirebaseFirestore.getInstance();
        final CollectionReference collectionReference = db.collection("Cities");

        addCityButton.setOnClickListener(view -> {
            final String cityName = addCityEditText.getText().toString();
            final String provinceName = addProvinceEditText.getText().toString();
            HashMap<String, String> data = new HashMap<>();

            if (cityName.length() > 0 && provinceName.length() > 0) {
                data.put("Province Name", provinceName);
                collectionReference
                        .document(cityName)
                        .set(data)
                        .addOnSuccessListener(aVoid -> {
                            // These are a method which gets executed when the task is succeeded
                            Log.d(TAG, "Data has been added successfully!");
                        })
                        .addOnFailureListener(e -> {
                            // These are a method which gets executed if there’s any problem
                            Log.d(TAG, "Data could not be added!" + e.toString());
                        });
                addCityEditText.setText("");
                addProvinceEditText.setText("");

            }
        });

        collectionReference.addSnapshotListener((queryDocumentSnapshots, error) -> {
            cityDataList.clear();
            assert queryDocumentSnapshots != null;
            for(QueryDocumentSnapshot doc: queryDocumentSnapshots)
            {
                Log.d(TAG, String.valueOf(doc.getData().get("Province Name")));
                String city = doc.getId();
                String province = (String) doc.getData().get("Province Name");
                cityDataList.add(new City(city, province)); // Adding the cities and provinces from FireStore
            }
            cityAdapter.notifyDataSetChanged(); // Notifying the adapter to render any new data fetched from the cloud
        });
    }
}
