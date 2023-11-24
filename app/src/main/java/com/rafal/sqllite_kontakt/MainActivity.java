package com.rafal.sqllite_kontakt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txt = (TextView) findViewById(R.id.textView);
        DatabaseHandler db = new DatabaseHandler(this);

        db.addContact(new Contact("Rafal", "123456789"));
        db.addContact(new Contact("Kasia", "987654321"));
        db.addContact(new Contact("Tomek", "123123123"));
        db.addContact(new Contact("Ania", "456456456"));
        db.addContact(new Contact("Krzysiek", "789789789"));
        db.addContact(new Contact("Marek", "321321321"));

        txt.setText("Odczytanie wszystkich kontaktów");
        List<Contact> contacts = db.getAllContacts();
        for (Contact cn : contacts) {
            String log = "ID: " + cn.getId() + ", Name: " + cn.getName() + ", Phone: " + cn.getPhone() + "\n\r";
            txt.setText(txt.getText() + "\nkontakty: "  + log);
        }

    }
}