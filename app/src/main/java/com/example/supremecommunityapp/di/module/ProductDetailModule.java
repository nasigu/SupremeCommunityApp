package com.example.supremecommunityapp.di.module;

import com.example.supremecommunityapp.di.scopes.ProductDetailScope;
import com.example.supremecommunityapp.di.scopes.ProductListScope;
import com.example.supremecommunityapp.domain.SupremeCommunityApi;
import com.example.supremecommunityapp.ui.product_detail.ProductDetailContract;
import com.example.supremecommunityapp.ui.product_detail.ProductDetailPresenter;
import com.example.supremecommunityapp.ui.product_detail.adapter.ProductDetailStylePreviewAdapter;
import com.example.supremecommunityapp.ui.product_detail.adapter.ProductDetailStylePreviewViewHolder;
import com.example.supremecommunityapp.ui.product_detail.adapter.ProductDetailStylePreviewViewHolderFactory;
import com.example.supremecommunityapp.ui.product_detail.adapter.factory.ProductDetailStylePreviewViewHolderNormalFactory;
import com.example.supremecommunityapp.ui.product_list.ProductListContract;
import com.example.supremecommunityapp.ui.product_list.adapter.ProductListAdapter;
import com.example.supremecommunityapp.ui.product_list.adapter.ProductListViewHolderFactory;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

@Module
public class ProductDetailModule {
    private final ProductDetailContract.View view;

    public ProductDetailModule(ProductDetailContract.View view){
        this.view = view;
    }

    @Provides
    @ProductDetailScope
    ProductDetailContract.View provideView(){
        return view;
    }

    @Provides
    @ProductDetailScope
    ProductDetailContract.Presenter provideProductDetailPresenter(SupremeCommunityApi supremeCommunityApi, ProductDetailContract.View productDetailContract){
        return new ProductDetailPresenter(supremeCommunityApi, productDetailContract);
    }

    @Provides
    @ProductDetailScope
    ProductDetailStylePreviewAdapter provideProductDetailStylePreviewAdapter(ProductDetailContract.View productDetailContract, ProductDetailStylePreviewViewHolderFactory productDetailStylePreviewViewHolder, Picasso picasso) {
        return new ProductDetailStylePreviewAdapter(productDetailContract, productDetailStylePreviewViewHolder, picasso);
    }

    @Provides
    @ProductDetailScope
    ProductDetailStylePreviewViewHolderFactory provideViewHolderNormal() {
        return new ProductDetailStylePreviewViewHolderNormalFactory();
    }

}
