package sg.edu.rp.c346.mymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    ListView lvMovies;
    ArrayList<MovieList> alMovies;
    CustomAdapter caMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMovies = findViewById(R.id.ListViewMovie);
        alMovies = new ArrayList<>();

        Calendar date1 = Calendar.getInstance();
        date1.set(2014,12,15);

        Calendar date2 = Calendar.getInstance();
        date2.set(2015,5,15);

        MovieList movie1 = new MovieList("The Avengers", "2012","pg13","Action | Sci-Fi", date1, "Golden Village - Bishan", "Nicky Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army.", 4);
        MovieList movie2 = new MovieList("Planes", "2013","pg","Animation | Comedy", date2, "Cathay - AMK Hub", "A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race",3);

        alMovies.add(movie1);
        alMovies.add(movie2);

        caMovies = new CustomAdapter(this, R.layout.movie_layout, alMovies);

        lvMovies.setAdapter(caMovies);

        lvMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                MovieList getPos = alMovies.get(position);
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);

                intent.putExtra("Title", getPos.getTitle());
                intent.putExtra("Date",getPos.getDateString());
                intent.putExtra("Year",getPos.getYear());
                intent.putExtra("rated",getPos.getRated());
                intent.putExtra("genre",getPos.getGenre());
                intent.putExtra("inTheatre",getPos.getIn_theatre());
                intent.putExtra("description",getPos.getDescription());
                intent.putExtra("rating", getPos.getRating());
                startActivity(intent);
            }
        });


    }
}
