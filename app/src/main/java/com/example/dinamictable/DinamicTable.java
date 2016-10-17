package com.example.dinamictable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class DinamicTable extends AppCompatActivity {
    private TableLayout tblHeader;
    private TableLayout tblBody;
    private TableRow.LayoutParams tbrLayoutid;
    private TableRow.LayoutParams tbrLayoutName;
    private TableRow.LayoutParams tbrLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinamic_table);

        tblHeader = (TableLayout) findViewById(R.id.tblHeader);
        tblBody = (TableLayout) findViewById(R.id.tblBody);

        tbrLayoutid = new TableRow.LayoutParams(130, TableRow.LayoutParams.WRAP_CONTENT);
        tbrLayoutid.setMargins(0,10,0,10);
        tbrLayoutName = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        tbrLayoutName.setMargins(0,10,0,10);
        tbrLayout = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);

        createHeader();
        createBody();

    }

    private void createBody() {

        TableRow tbrBody;
        TextView txvId;
        TextView txvName;

        String[] listName = getResources().getStringArray(R.array.listName);
        for (int i =0 ; i < listName.length; i++){

            tbrBody = new TableRow(this);
            tbrBody.setLayoutParams(tbrLayout);
            txvId = new TextView(this);
            txvId.setText(" "+(i+1)+" ");
            txvId.setLayoutParams(tbrLayoutid);
            txvId.setBackgroundResource(R.drawable.shape_body);

            txvName = new TextView(this);
            txvName.setText(listName[i]);
            txvName.setLayoutParams(tbrLayoutName);
            txvName.setBackgroundResource(R.drawable.shape_body);

            tbrBody.addView(txvId);
            tbrBody.addView(txvName);

            tblBody.addView(tbrBody);
        }
    }

    private void createHeader() {
        TableRow tbrHeader = new TableRow(this);
        tbrHeader.setLayoutParams(tbrLayout);
        TextView txvId = new TextView(this);
        txvId.setText(R.string.txvId);
        txvId.setLayoutParams(tbrLayoutid);
        txvId.setBackgroundResource(R.drawable.shape_header);
        tbrHeader.addView(txvId);

        TextView txvName = new TextView(this);
        txvName.setText(R.string.txvName);
        txvName.setLayoutParams(tbrLayoutid);
        txvName.setBackgroundResource(R.drawable.shape_header);
        tbrHeader.addView(txvName);

        tblHeader.addView(tbrHeader);

    }
}
