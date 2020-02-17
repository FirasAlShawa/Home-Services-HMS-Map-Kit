package com.wz.android.mapdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;


import java.util.ArrayList;
public class Categories extends AppCompatActivity {

    private GridView GridviewCategory;
    private ArrayList<Category> categoriesArrayList;
    private Adapter_Category adapterCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        GridviewCategory = findViewById(R.id.GridviewCategory);

        categoriesArrayList = new ArrayList<>();

        Category Default1 = new Category("Maintenance");
        Default1.AddLocation(24.760986, 46.681589,R.drawable.icon1,"0506104963");
        Default1.AddLocation(24.752724, 46.683649,R.drawable.icon1,"0506104963");
        Default1.AddLocation(24.755374, 46.660987,R.drawable.icon1,"0506104963");
        Default1.AddLocation(32.003185,35.877276,R.drawable.icon1,"0795819228");
        Default1.AddLocation(32.004582,35.892908,R.drawable.icon1,"0795815984");
        Default1.AddLocation(31.946919,35.896339,R.drawable.icon1,"0795819855");
        Category Default2 = new Category("Drivers");
        Default2.AddLocation(24.767844, 46.706483,R.drawable.icon2,"0506104963");
        Default2.AddLocation(24.748603, 46.705621,R.drawable.icon2,"0506104963");
        Default2.AddLocation(24.742466, 46.766745,R.drawable.icon2,"0506104963");
        Default2.AddLocation(31.995265,35.953985,R.drawable.icon2,"0795819228");
        Default2.AddLocation(32.030781,35.845555,R.drawable.icon2,"0789878158");
        Default2.AddLocation(32.013898,35.851045,R.drawable.icon2,"0795555528");
        Category Default3 = new Category("Nurse");
        Default3.AddLocation(24.713215, 46.689844,R.drawable.icon3,"0506104963");
        Default3.AddLocation(24.752506, 46.645206,R.drawable.icon3,"0506104963");
        Default3.AddLocation(24.691382, 46.739631,R.drawable.icon3,"0506104963");
        Default3.AddLocation(32.046497,35.958789,R.drawable.icon3,"0799563228");
        Default3.AddLocation(32.019138,35.991730,R.drawable.icon3,"0789658741");
        Default3.AddLocation(32.025542,36.047318,R.drawable.icon3,"0789621542");
        Category Default4 = new Category("Carpenter");
        Default4.AddLocation(24.757837, 46.782657,R.drawable.icon4,"0506104963");
        Default4.AddLocation(24.746769, 46.794503,R.drawable.icon4,"0506104963");
        Default4.AddLocation(24.770619, 46.811671,R.drawable.icon4,"0506104963");
        Default4.AddLocation(32.075593,35.926535,R.drawable.icon4,"0785698422");
        Default4.AddLocation(32.013564,35.861301,R.drawable.icon4,"0785496135");
        Default4.AddLocation(32.019604,35.877342,R.drawable.icon4,"0785491635");
        Category Default5 = new Category("Babysitting");
        Default5.AddLocation(24.780376, 46.763824,R.drawable.icon5,"0506104963");
        Default5.AddLocation(24.777976, 46.719828,R.drawable.icon5,"0506104963");
        Default5.AddLocation(24.761973, 46.701469,R.drawable.icon5,"0506104963");
        Default5.AddLocation(32.021496,35.848605,R.drawable.icon5,"0789465312");
        Default5.AddLocation(32.015208,35.850700,R.drawable.icon5,"0785196438");
        Default5.AddLocation(32.010769,35.852501,R.drawable.icon5,"0794518297");

        Category Default6 = new Category("All Categories");
        Default6.AddLocation(24.760986, 46.681589,R.drawable.icon1,"0506104963");
        Default6.AddLocation(24.752724, 46.683649,R.drawable.icon1,"0506104963");
        Default6.AddLocation(24.755374, 46.660987,R.drawable.icon1,"0506104963");
        Default6.AddLocation(24.767844, 46.706483,R.drawable.icon2,"0506104963");
        Default6.AddLocation(24.748603, 46.705621,R.drawable.icon2,"0506104963");
        Default6.AddLocation(24.742466, 46.766745,R.drawable.icon2,"0506104963");
        Default6.AddLocation(24.713215, 46.689844,R.drawable.icon3,"0506104963");
        Default6.AddLocation(24.752506, 46.645206,R.drawable.icon3,"0506104963");
        Default6.AddLocation(24.691382, 46.739631,R.drawable.icon3,"0506104963");
        Default6.AddLocation(24.757837, 46.782657,R.drawable.icon4,"0506104963");
        Default6.AddLocation(24.746769, 46.794503,R.drawable.icon4,"0506104963");
        Default6.AddLocation(24.770619, 46.811671,R.drawable.icon4,"0506104963");
        Default6.AddLocation(24.780376, 46.763824,R.drawable.icon5,"0506104963");
        Default6.AddLocation(24.777976, 46.719828,R.drawable.icon5,"0506104963");
        Default6.AddLocation(24.761973, 46.701469,R.drawable.icon5,"0506104963");
        Default6.AddLocation(32.027507,35.848727,R.drawable.icon1,"0795819228");
        Default6.AddLocation(32.001351,35.887504,R.drawable.icon2,"0795819228");
        Default6.AddLocation(31.995819,35.913754,R.drawable.icon3,"0795819228");
        Default6.AddLocation(32.003185,35.877276,R.drawable.icon1,"0795819228");
        Default6.AddLocation(32.004582,35.892908,R.drawable.icon1,"0795815984");
        Default6.AddLocation(31.946919,35.896339,R.drawable.icon1,"0795819855");
        Default6.AddLocation(31.995265,35.953985,R.drawable.icon2,"0795819228");
        Default6.AddLocation(32.030781,35.845555,R.drawable.icon2,"0789878158");
        Default6.AddLocation(32.013898,35.851045,R.drawable.icon2,"0795555528");
        Default6.AddLocation(32.046497,35.958789,R.drawable.icon3,"0799563228");
        Default6.AddLocation(32.019138,35.991730,R.drawable.icon3,"0789658741");
        Default6.AddLocation(32.025542,36.047318,R.drawable.icon3,"0789621542");
        Default6.AddLocation(32.075593,35.926535,R.drawable.icon4,"0785698422");
        Default6.AddLocation(32.013564,35.861301,R.drawable.icon4,"0785496135");
        Default6.AddLocation(32.019604,35.877342,R.drawable.icon4,"0785491635");
        Default6.AddLocation(32.021496,35.848605,R.drawable.icon5,"0789465312");
        Default6.AddLocation(32.015208,35.850700,R.drawable.icon5,"0785196438");
        Default6.AddLocation(32.010769,35.852501,R.drawable.icon5,"0794518297");
        categoriesArrayList.add(Default1);
        categoriesArrayList.add(Default2);
        categoriesArrayList.add(Default3);
        categoriesArrayList.add(Default4);
        categoriesArrayList.add(Default5);
        categoriesArrayList.add(Default6);

        adapterCategory = new Adapter_Category(getApplicationContext(),categoriesArrayList);
        GridviewCategory.setAdapter(adapterCategory);

        System.out.println("Done!");

        GridviewCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Categories.this,MainActivity.class);
                intent.putExtra("Category",categoriesArrayList.get(i));
                System.out.println(categoriesArrayList.get(i));
                startActivity(intent);
            }
        });

    }
}
