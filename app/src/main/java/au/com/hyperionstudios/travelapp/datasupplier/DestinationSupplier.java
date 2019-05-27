package au.com.hyperionstudios.travelapp.datasupplier;

import java.util.ArrayList;
import java.util.List;

import au.com.hyperionstudios.travelapp.model.Destination;

public class DestinationSupplier {

    public static List<Destination> getDestinations(){
        ArrayList<Destination> destinations = new ArrayList<>();

        destinations.add( new Destination( 1,"Egypt" ,
                "https://media.virtuoso.com/m/cms/VCom/Destination/regions/africa/Egypt/h490/Egypt-Sphinx.jpg" ,
                PlacesSupplier.getPlaces()) );

        destinations.add( new Destination( 2,"Iraq" ,
                "https://media.pri.org/s3fs-public/styles/story_main/public/story/images/RTS1M0N8.jpg?itok=iBvYyFCS" ,
                PlacesSupplier.getPlaces()) );

        return destinations;
    }

}
