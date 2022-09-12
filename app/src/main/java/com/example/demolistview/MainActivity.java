package com.example.demolistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvNgonNgu;
    ArrayList<String> arrayCourse;
    Button bThem , bCapNhat ,bXoa;
    EditText eNgonNgu;
    int vitri = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        arrayCourse= new ArrayList<>();

        arrayCourse.add("Tieng Anh");
        arrayCourse.add("Tieng Viet");
        arrayCourse.add("Tieng Trung Quoc");
        arrayCourse.add("Tieng Phap");
        arrayCourse.add("Tieng Duc");

        ArrayAdapter adapter= new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrayCourse);

        lvNgonNgu.setAdapter(adapter);

        lvNgonNgu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                eNgonNgu.setText(arrayCourse.get(i));
                vitri = i;
            }
        });

    lvNgonNgu.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                   startActivity(new Intent(MainActivity.this,TiengAnh.class));
               }else if(i==1){
                  startActivity(new Intent(MainActivity.this,TiengViet.class));
               }else{

                }
        return false;
    }
});

        bThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String monhoc = eNgonNgu.getText().toString();
                arrayCourse.add(monhoc);
                adapter.notifyDataSetChanged();

            }
        });
        bCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayCourse.set(vitri, eNgonNgu.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        bXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0; i < arrayCourse.size();i++){
                    String getname = eNgonNgu.getText().toString();
                    if(arrayCourse.get(i).equals(getname)){
                        arrayCourse.remove(i);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Da Xoa", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
            }
        });
    }
    public void AnhXa(){
        lvNgonNgu = (ListView) findViewById(R.id.listviewNgonNgu);
        bThem = (Button) findViewById(R.id.buttonThem);
        bCapNhat = (Button) findViewById(R.id.buttonCapNhat);
        bXoa = (Button) findViewById(R.id.buttonXoa);
        eNgonNgu = (EditText) findViewById(R.id.edittextNgonNgu);
    }
}