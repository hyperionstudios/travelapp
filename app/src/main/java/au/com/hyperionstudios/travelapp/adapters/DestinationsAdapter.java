package au.com.hyperionstudios.travelapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import au.com.hyperionstudios.travelapp.R;
import au.com.hyperionstudios.travelapp.model.Destination;

public class DestinationsAdapter extends RecyclerView.Adapter<DestinationsAdapter.DestinationViewHolder> {

    List<Destination> destinations;
    Context context;
    DestinstionClickListener destinstionClickListener;

    public DestinationsAdapter(List<Destination> destinations, Context context) {
        this.destinations = destinations;
        this.context = context;
    }

    @NonNull
    @Override
    public DestinationViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate( R.layout.destination_item , viewGroup , false );
        return new DestinationViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull DestinationViewHolder destinationViewHolder, int i) {
        Destination destination = destinations.get( i );
        destinationViewHolder.destinationTitle.setText( destination.getTitle() );
        destinationViewHolder.placesCount.setText( String.valueOf( destination.getPlacesCount() ) + " Places" );
        Picasso.get().load( destination.getFeaturedImageUrl() ).fit().into( destinationViewHolder.destinationImage );
    }

    @Override
    public int getItemCount() {
        return destinations.size();
    }

    public class DestinationViewHolder extends RecyclerView.ViewHolder {
        TextView destinationTitle;
        TextView placesCount;
        ImageView destinationImage;
        public DestinationViewHolder(@NonNull View itemView) {
            super(itemView);
            setupElements();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    destinstionClickListener.onDestinationClickListener( position );
                }
            });

        }
        private void setupElements() {
            destinationImage = itemView.findViewById(R.id.destination_image);
            destinationTitle = itemView.findViewById( R.id.destination_title );
            placesCount = itemView.findViewById( R.id.places_count );
        }
    }

    public interface DestinstionClickListener {
        void onDestinationClickListener( int position );
    }

    public void setOnClickItemListener( DestinstionClickListener destinstionClickListener ){
        this.destinstionClickListener = destinstionClickListener;
    }

}
