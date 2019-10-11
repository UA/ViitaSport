package com.vitasport.starlabs.vitasport.views.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;
import com.vitasport.starlabs.vitasport.R;
import com.vitasport.starlabs.vitasport.models.AthletesModel;

import java.util.ArrayList;
import java.util.List;

public class Feadback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feadback);
        EditText message = (EditText) findViewById(R.id.editText);
        Button send =  (Button) findViewById(R.id.send);
        String email = getIntent().getStringExtra("email");



        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ParseQuery<ParseObject> query = ParseQuery.getQuery("Athletes");
                query.whereEqualTo("identifier",email);
                query.findInBackground(new FindCallback<ParseObject>() {
                    public void done(List<ParseObject> list, ParseException e) {
                        if (e == null) {

                            ParseObject suggestion = new ParseObject("Suggestion");
                            suggestion.put("athletesId",list.get(0));
                            suggestion.put("message",message.getText().toString());
                            suggestion.saveInBackground(new SaveCallback() {
                                @Override
                                public void done(ParseException e) {
                                    if(e== null)
                                        onBackPressed();
                                }
                            });

                        } else {

                        }
                    }
                });



            }
        });





    }
}
