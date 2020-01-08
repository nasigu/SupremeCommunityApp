package com.example.supremecommunityapp.ui.product_list.adapter;

import android.support.v7.recyclerview.extensions.AsyncListDiffer;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.supremecommunityapp.R;
import com.example.supremecommunityapp.model.supreme.Product;
import com.example.supremecommunityapp.ui.product_list.ProductListContract;
import com.squareup.picasso.Picasso;

import java.util.List;


public class ProductListAdapter extends RecyclerView.Adapter {

    private AsyncListDiffer<Product> products = new AsyncListDiffer<Product>(this, new ProductListDiffUtil());

    private Picasso picasso;

    public Boolean preload = false;

    private ProductListContract.View productListView;
    private ProductListViewHolderFactory productListViewHolderFactory;

    public ProductListAdapter(ProductListContract.View productListView, ProductListViewHolderFactory productListViewHolderFactory, Picasso picasso) {
        this.productListView = productListView;
        this.productListViewHolderFactory = productListViewHolderFactory;
        this.picasso = picasso;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final RecyclerView.ViewHolder viewHolder = productListViewHolderFactory.createViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_list_item, parent, false), picasso);
        viewHolder.itemView.setOnClickListener(v -> onProductClicked(viewHolder.getAdapterPosition()));
        return viewHolder;
    }

    private void onProductClicked(int adapterPosition) {
        productListView.onProductDetailClick(products.getCurrentList().get(adapterPosition));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (preload) {
            ((ProductListViewHolder) holder).showLoading();
        } else {
            ((ProductListViewHolder) holder).showLoaded();
        }
        ((ProductListViewHolder) holder).bind(products.getCurrentList().get(position));

    }

    @Override
    public int getItemCount() {
        if (products != null) {
            return products.getCurrentList().size();
        }
        return 0;
    }

    public void updateRepositoriesList(List<Product> products) {
        this.products.submitList(products);
    }


//    public static final DiffUtil.ItemCallback<Product> DIFF_CALLBACK
//            = new DiffUtil.ItemCallback<Product>() {
//
//        @Override
//        public boolean areItemsTheSame(
//                @NonNull Product oldProducts, @NonNull Product newProducts) {
//            // User properties may have changed if reloaded from the DB, but ID is fixed
//            return oldProducts.getId().equals(newProducts.getId());
//        }
//
//        @Override
//        public boolean areContentsTheSame(
//                @NonNull Product oldProducts, @NonNull Product newProducts) {
//            // NOTE: if you use equals, your object must properly override Object#equals()
//            // Incorrectly returning false here will result in too many animations.
//            return oldProducts.getName().equals(newProducts.getName())
//                    && oldProducts.getImageUrl().equals(newProducts.getImageUrl());
//        }
//    };

    public void showSuccess() {

    }

}
