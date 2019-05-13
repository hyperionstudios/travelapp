package au.com.hyperionstudios.travelapp.datasupplier;

import java.util.ArrayList;
import java.util.List;

import au.com.hyperionstudios.travelapp.R;
import au.com.hyperionstudios.travelapp.model.OnBoardingModel;

public class OnBoardingSupplier {

    public OnBoardingSupplier() {
    }

    public static List<OnBoardingModel> getOnBoardingObjects() {
        ArrayList<OnBoardingModel> objects = new ArrayList<OnBoardingModel>();
        objects.add(new OnBoardingModel(R.drawable.airplane, "Easy Planes", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua"));
        objects.add(new OnBoardingModel(R.drawable.bags, "Ready your Bags", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua"));
        objects.add(new OnBoardingModel(R.drawable.camera, "Take Pictures", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua"));
        objects.add(new OnBoardingModel(R.drawable.location, "Nice Locations", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua"));
        return objects;
    }

}
