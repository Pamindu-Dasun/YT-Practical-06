package com.example.ytpractical06;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ListView listOfMovies;

    private final String[] movies = {
            "The Shawshank Redemption",
            "The Godfather",
            "The Godfather: Part II",
            "The Dark Knight",
            "12 Angry Men",
            "Schindler's List",
            "The Lord of the Rings: The Return of the King",
            "Pulp Fiction",
            "The Good, the Bad and the Ugly",
            "Fight Club",
            "The Lord of the Rings: The Fellowship of the Ring",
            "Forrest Gump"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listOfMovies = findViewById(R.id.listOfMovies);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, movies);

        listOfMovies.setAdapter(adapter);

        listOfMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, LogendUser.class);
                intent.putExtra("name", movies[position]);
                startActivity(intent);
            }
        });
    }
}