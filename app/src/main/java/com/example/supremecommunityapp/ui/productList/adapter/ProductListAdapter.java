package com.example.supremecommunityapp.ui.productList.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.supremecommunityapp.model.supreme.MobileStock;
import com.example.supremecommunityapp.ui.productList.ProductListContract;


public class ProductListAdapter extends RecyclerView.Adapter {

    private MobileStock mobileStock = new MobileStock();

    private ProductListContract.View productListView;
    private ProductListViewHolderFactory productListViewHolderFactory;

    public ProductListAdapter(ProductListContract.View productListView, ProductListViewHolderFactory productListViewHolderFactory){
        this.productListView = productListView;
        this.productListViewHolderFactory = productListViewHolderFactory;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final RecyclerView.ViewHolder viewHolder = productListViewHolderFactory.createViewHolder(parent);
//        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onProductClicked(viewHolder.getAdapterPosition());
//            }
//        });
        return viewHolder;
    }

//    private void onProductClicked(int adapterPosition) {
//        productListView.onRepositoryClick(repositories.get(adapterPosition));
//    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ProductListViewHolder) holder).bind(mobileStock.getProductsAndCategories().convertAllToProducts().get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void updateRepositoriesList(MobileStock mobileStock) {
        this.mobileStock = null;
        this.mobileStock = mobileStock;
        notifyDataSetChanged();
    }
}
