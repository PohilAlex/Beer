package com.example.beer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.example.beer.model.BeerStorage;
import com.example.beer.model.BottleType;
import com.example.beer.model.BottleTypeFactory;
import com.example.beer.model.ReportItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    Spinner typeSpinner;
    Button addBtn;
    ListView beerListView;

    BottleType currentType;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        typeSpinner = (Spinner) findViewById(R.id.beer_type_spinner);
        addBtn = (Button) findViewById(R.id.add_btn);
        beerListView = (ListView) findViewById(R.id.beer_list);
        initView();
    }

    private void initView() {
        ArrayList<String> data = new ArrayList<String>();
        for (BottleType type : BottleTypeFactory.getTypeList()) {
            data.add(type.name);
        }
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, data);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(spinnerAdapter);
        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                currentType = BottleTypeFactory.getTypeList().get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final ArrayList<ReportItem> reportList =  BeerStorage.getInstance().getReportList();
        final BeerAdapter beerAdapter = new BeerAdapter(this, reportList);
        beerListView.setAdapter(beerAdapter);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BeerStorage.getInstance().putBear(currentType, 1);
                reportList.clear();
                reportList.addAll(BeerStorage.getInstance().getReportList());
                beerAdapter.notifyDataSetChanged();
            }
        });
    }

    class BeerAdapter extends ArrayAdapter<ReportItem> {

        BeerAdapter(Context context,  List<ReportItem> objects) {
            super(context, 0, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View layout;
            if (convertView == null) {
                layout = getLayoutInflater().inflate(R.layout.beer_item, null, false);
            } else {
                layout = convertView;
            }
            TextView text = (TextView) layout.findViewById(R.id.beer_title);
            TextView count = (TextView) layout.findViewById(R.id.beer_count);
            text.setText(getItem(position).type.name);
            count.setText(getItem(position).count + "");
            return layout;
        }
    }

}
