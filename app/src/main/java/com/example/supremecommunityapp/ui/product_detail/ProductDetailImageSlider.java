package com.example.supremecommunityapp.ui.product_detail;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.supremecommunityapp.R;
import com.example.supremecommunityapp.model.supreme.product_detail.ProductStyle;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class ProductDetailImageSlider extends PagerAdapter{

    private Context context;
    private List<ProductStyle> productStyles;


    public ProductDetailImageSlider(Context context, List<ProductStyle> productStyles) {
        this.context = context;
        this.productStyles = productStyles;

    }

    @Override
    public int getCount() {
        return productStyles.size();
    }


    @Override
    public boolean isViewFromObject(@NotNull View view, @NotNull Object object) {

        return view == object;
    }

    @Override
    public Object instantiateItem(@NotNull ViewGroup container, int position) {

        ImageView imageView;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.slider_image,container,false);

        imageView = itemView.findViewById(R.id.slider_image_view);

        if(!productStyles.get(position).getImageUrl().equals("")){
            Picasso.with(imageView.getContext())
                    .load(productStyles.get(position).getSwatchUrl()) // thumbnail url goes here
//                    .into(imageView);
                    .into(imageView, new Callback() {
                        @Override
                        public void onSuccess() {
                            Picasso.with(imageView.getContext())
                                    .load(productStyles.get(position).getImageUrlHi()) // image url goes here
                                    //.placeholder(imageView.getDrawable())
                                    .into(imageView);
                        }
                        @Override
                        public void onError() {

                        }
                    });
        }

        container.addView(itemView);

        return itemView;

    }

    @Override
    public void destroyItem(@NotNull ViewGroup container, int position, @NotNull Object object) {
        container.removeView((LinearLayout) object);
    }
}