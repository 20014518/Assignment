// Toh Yong Jie 20014518
package sg.edu.rp.c346.id20014518.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collections;

public class ItemListActivity extends AppCompatActivity {
    EditText etText,etIndex;
    Button btnAdd,btnUpdate,btnDelete;
    ListView lvProducts;
    ArrayList<String> alProducts;
    ArrayAdapter<String> aaProducts;
    Spinner spnMonth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        etText = findViewById(R.id.editTextText);
        etIndex = findViewById(R.id.editTextIndex);
        btnAdd = findViewById(R.id.buttonAdd);
        btnUpdate = findViewById(R.id.buttonUpdate);
        btnDelete = findViewById(R.id.buttonDelete);
        lvProducts = findViewById(R.id.listView);
        spnMonth = findViewById(R.id.spinner);

        alProducts = new ArrayList<String>();
        alProducts.add("Expires 2021-7-11 Samsung Galaxy S21");
        alProducts.add("Expires 2021-9-11 iPhone 12");
        alProducts.add("Expires 2021-12-11 Huawei Mate 40 Pro");
        alProducts.add("Expires 2021-7-11 OnePlus 9");
        alProducts.add("Expires 2021-9-11 Pixel 4a");

        aaProducts = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alProducts);
        lvProducts.setAdapter(aaProducts);

        lvProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String newText = alProducts.get(position);
                etIndex.setText("" + (position + 1));
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newText = etText.getText().toString();
                int pos = Integer.parseInt(etIndex.getText().toString());
                alProducts.add(newText);
                aaProducts.notifyDataSetChanged();
                etText.setText(null);
                etIndex.setText(null);
                Collections.sort(alProducts);
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newText = etText.getText().toString();
                int pos = Integer.parseInt(etIndex.getText().toString());
                alProducts.set(pos -1, newText);
                aaProducts.notifyDataSetChanged();
                etText.setText(null);
                etIndex.setText(null);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt(etText.getText().toString());
                alProducts.remove(pos);
                aaProducts.notifyDataSetChanged();
                etText.setText(null);
                etIndex.setText(null);
            }
        });

        spnMonth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:

                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}