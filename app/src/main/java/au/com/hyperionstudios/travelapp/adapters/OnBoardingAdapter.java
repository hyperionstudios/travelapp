package au.com.hyperionstudios.travelapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import au.com.hyperionstudios.travelapp.R;
import au.com.hyperionstudios.travelapp.model.OnBoardingModel;

public class OnBoardingAdapter extends PagerAdapter {

    List<OnBoardingModel> pagesModel;
    Context context;
    LayoutInflater layoutInflater;


    public OnBoardingAdapter(List<OnBoardingModel> pagesModel, Context context) {
        this.pagesModel = pagesModel;
        this.context = context;
    }


    @Override
    public int getCount() {
        return pagesModel.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );

        View view = layoutInflater.inflate(R.layout.onboarding , container , false );

        ImageView imageView = view.findViewById( R.id.page_image );
        TextView titleTextView = view.findViewById( R.id.page_title );
        TextView descriptionTextView = view.findViewById( R.id.page_description );

        OnBoardingModel onBoardingModel = pagesModel.get( position );

        imageView.setImageResource( onBoardingModel.getImage() );
        titleTextView.setText( onBoardingModel.getTitle() );
        descriptionTextView.setText( onBoardingModel.getDescription() );
        container.addView( view );
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView( (View) object);
    }
}
