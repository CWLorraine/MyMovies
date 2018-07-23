package sg.edu.rp.c346.mymovies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 16039013 on 23/7/2018.
 */

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<MovieList> alMovies;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<MovieList> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        alMovies = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvTitle = rowView.findViewById(R.id.textViewMovieTitle);
        TextView tvMovie = rowView.findViewById(R.id.textViewMovie);
        ImageView img = rowView.findViewById(R.id.imageViewMovies);

        MovieList currentItem = alMovies.get(position);
        tvTitle.setText(currentItem.getTitle());
        tvMovie.setText(currentItem.getYear() + " - " + currentItem.getGenre());

        if (currentItem.getRated() == "g"){
            img.setImageResource(R.drawable.rating_g);
        }
        else if (currentItem.getRated() == "pg"){
            img.setImageResource(R.drawable.rating_pg);

        }

        else if (currentItem.getRated() == "pg13"){
            img.setImageResource(R.drawable.rating_pg13);

        }

        else  if (currentItem.getRated() == "nc16"){
            img.setImageResource(R.drawable.rating_nc16);

        }

        else if (currentItem.getRated() == "m18"){
            img.setImageResource(R.drawable.rating_m18);

        }

        else{
            img.setImageResource(R.drawable.rating_r21);

        }

        return rowView;
    }
}
