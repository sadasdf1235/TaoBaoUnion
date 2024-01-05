package com.ld.model;

import com.ld.model.domain.Categories;
import com.ld.model.domain.HomePagerContent;
import com.ld.model.domain.SelectCategories;
import com.ld.model.domain.SelectContent;
import com.ld.model.domain.TicketParams;
import com.ld.model.domain.TicketResult;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface API {
    @GET("discovery/categories")
    Call<Categories> getCategories();

    @GET
    Call<HomePagerContent> getHomePagerContent(@Url String url);

    @POST("tpwd")
    Call<TicketResult> getTicket(@Body TicketParams ticketParams);

    @GET("recommend/categories")
    Call<SelectCategories>  getSelectCategories();

    @GET
    Call<SelectContent> getContentBySelectCategoryId(@Url String url);
}
