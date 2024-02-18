  package com.example.hopitalmanagment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

  public class DoctorDetailsActivity extends AppCompatActivity {
      private String[][] doctor_details1 =
              {
                      {"Doctor name : Ajit Saste", "Hospital Address : Pimpri","Exp : 5yrs","Mobile no:9898989323","600"},
                      {"Doctor name : Prasad Pawar","Hospital Address : Nigdi","Exp : 15yrs","Mobile no:9456787643","900"},
                      {"Doctor name : Swapnil Kale", "Hospital Address : Pune","Exp : 8yrs","Mobile no:7987645673","300"},
                      {"Doctor name : Deepak Deshmuk", "Hospital Address : Chinchwad","Exp : 6yrs","Mobile no:9899078672","500"},
                      {"Doctor name : Ashok Panda", "Hospital Address : Katraj","Exp : 7yrs","Mobile no:9876345621","800"}
              };

      private String[][] doctor_details2 =
              {
                      {"Doctor name : Neelam Patil", "Hospital Address : Pimpri","Exp : 5yrs","Mobile no:98989898323","600"},
                      {"Doctor name : Swati Pawar","Hospital Address : Nigdi","Exp : 5yrs","Mobile no:9456787003","900"},
                      {"Doctor name : Swapnil Kale", "Hospital Address : Pune","Exp : 7yrs","Mobile no:7987645783","300"},
                      {"Doctor name : Deepak Deshmuk", "Hospital Address : Chinchwad","Exp : 6yrs","Mobile no:9699078672","500"},
                      {"Doctor name : Ashok Panda", "Hospital Address : Katraj","Exp : 7yrs","Mobile no:9876349821","800"}
              };

      private String[][] doctor_details3 =
              {
                      {"Doctor name : Seema Patil", "Hospital Address : Pimpri","Exp : 5yrs","Mobile no:8988989323","600"},
                      {"Doctor name : Ram Pawar","Hospital Address : Nigdi","Exp : 15yrs","Mobile no:9450007643","900"},
                      {"Doctor name : Arjun Kale", "Hospital Address : Pune","Exp : 8yrs","Mobile no:7987645909","300"},
                      {"Doctor name : Daya Deshmuk", "Hospital Address : Chinchwad","Exp : 6yrs","Mobile no:9879078672","500"},
                      {"Doctor name : Alok Panda", "Hospital Address : Katraj","Exp : 7yrs","Mobile no:9876345009","800"}
              };

      private String[][] doctor_details4 =
              {
                      {"Doctor name : Amol Gawade", "Hospital Address : Pimpri","Exp : 5yrs","Mobile no:7778989323","600"},
                      {"Doctor name : Prasad Pawar","Hospital Address : Nigdi","Exp : 15yrs","Mobile no:9096787643","900"},
                      {"Doctor name : Nilesh Kale", "Hospital Address : Pune","Exp : 8yrs","Mobile no:7987648783","300"},
                      {"Doctor name : Deepak Deshpande", "Hospital Address : Chinchwad","Exp : 6yrs","Mobile no:6769078672","500"},
                      {"Doctor name : Ashok Singh", "Hospital Address : Katraj","Exp : 7yrs","Mobile no:9877875621","800"}
              };

      private String[][] doctor_details5 =
              {
                      {"Doctor name : Nilesh Borate", "Hospital Address : Pimpri","Exp : 5yrs","Mobile no:9898988973","1800"},
                      {"Doctor name : Pankaj Pawar","Hospital Address : Nigdi","Exp : 15yrs","Mobile no:8976587643","1900"},
                      {"Doctor name : Swapnil Lele", "Hospital Address : Pune","Exp : 8yrs","Mobile no:7987640098","1300"},
                      {"Doctor name : Deepak Kumar", "Hospital Address : Chinchwad","Exp : 6yrs","Mobile no:8889078672","1500"},
                      {"Doctor name : Ankul Panda", "Hospital Address : Katraj","Exp : 7yrs","Mobile no:9876345999","1800"}
              };
      TextView tv;
      Button btn;
      String[][]  doctor_details = {};
      HashMap<String,String> item;
      ArrayList list;
      SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);

        Intent it = getIntent();
        String title = it.getStringExtra(name:"title");
        tv.setText(title);

        if (title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if (title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if (title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if (title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;


            btn.setOnCliclListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(packageContext: DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        List = new ArrayList();
        for(int i =0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Cons Fee:"+doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(context: this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        ListView lst = findViewById(R.id.ListViewDD);
        lst.setAdapter(sa);
    }
}