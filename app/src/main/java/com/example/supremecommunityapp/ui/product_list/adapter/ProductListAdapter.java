package com.example.supremecommunityapp.ui.product_list.adapter;

import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.supremecommunityapp.R;
import com.example.supremecommunityapp.model.supreme.Product;
import com.example.supremecommunityapp.ui.product_list.ProductListContract;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class ProductListAdapter extends RecyclerView.Adapter {

    private List<Product> products;
    private  Picasso picasso;

    public Boolean preload = false;

    private ProductListContract.View productListView;
    private ProductListViewHolderFactory productListViewHolderFactory;

    public ProductListAdapter(ProductListContract.View productListView, ProductListViewHolderFactory productListViewHolderFactory, Picasso picasso){
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
        productListView.onProductDetailClick(products.get(adapterPosition));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(preload){
            ((ProductListViewHolder)holder).showLoading();
        }else{
            ((ProductListViewHolder)holder).showLoaded();
        }
        ((ProductListViewHolder) holder).bind(products.get(position));

    }

    @Override
    public int getItemCount() {
        if(products != null){
            return products.size();
        }
        return 0;
    }

    public void updateRepositoriesList(List<Product> products) {
        this.products = null;
        this.products = products;
//        preload = false;
//        notifyDataSetChanged();
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new ProductListDiffUtil(this.products, products));
        diffResult.dispatchUpdatesTo(this);
    }

    public void updateList(ArrayList<Product> newList) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new ProductListDiffUtil(this.products, newList));
        diffResult.dispatchUpdatesTo(this);
    }

    public void preloadList(List<Product> products) {
        this.products = null;
        this.products = products;
        preload = true;
        notifyDataSetChanged();
    }

    public void showSuccess(){

    }

}
