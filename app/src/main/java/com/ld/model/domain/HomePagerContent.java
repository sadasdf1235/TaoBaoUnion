package com.ld.model.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HomePagerContent {

    @SerializedName("success")
    private Boolean success;
    @SerializedName("code")
    private Integer code;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private List<DataDTO> data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataDTO> getData() {
        return data;
    }

    public void setData(List<DataDTO> data) {
        this.data = data;
    }

    public static class DataDTO {
        @SerializedName("category_id")
        private Integer categoryId;
        @SerializedName("click_url")
        private String clickUrl;
        @SerializedName("commission_rate")
        private String commissionRate;
        @SerializedName("coupon_amount")
        private Integer couponAmount;
        @SerializedName("coupon_click_url")
        private String couponClickUrl;
        @SerializedName("coupon_end_time")
        private String couponEndTime;
        @SerializedName("coupon_remain_count")
        private Integer couponRemainCount;
        @SerializedName("coupon_share_url")
        private String couponShareUrl;
        @SerializedName("coupon_start_fee")
        private String couponStartFee;
        @SerializedName("coupon_start_time")
        private String couponStartTime;
        @SerializedName("coupon_total_count")
        private Integer couponTotalCount;
        @SerializedName("item_description")
        private String itemDescription;
        @SerializedName("item_id")
        private String itemId;
        @SerializedName("level_one_category_id")
        private Integer levelOneCategoryId;
        @SerializedName("level_one_category_name")
        private String levelOneCategoryName;
        @SerializedName("pict_url")
        private String pictUrl;
        @SerializedName("reserve_price")
        private String reservePrice;
        @SerializedName("seller_id")
        private Long sellerId;
        @SerializedName("short_title")
        private Object shortTitle;
        @SerializedName("small_images")
        private SmallImagesDTO smallImages;
        @SerializedName("sub_title")
        private String subTitle;
        @SerializedName("title")
        private String title;
        @SerializedName("tmall_play_activity_end_time")
        private Integer tmallPlayActivityEndTime;
        @SerializedName("tmall_play_activity_start_time")
        private Integer tmallPlayActivityStartTime;
        @SerializedName("user_type")
        private Integer userType;
        @SerializedName("volume")
        private Integer volume;
        @SerializedName("zk_final_price")
        private String zkFinalPrice;

        public Integer getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Integer categoryId) {
            this.categoryId = categoryId;
        }

        public String getClickUrl() {
            return clickUrl;
        }

        public void setClickUrl(String clickUrl) {
            this.clickUrl = clickUrl;
        }

        public String getCommissionRate() {
            return commissionRate;
        }

        public void setCommissionRate(String commissionRate) {
            this.commissionRate = commissionRate;
        }

        public Integer getCouponAmount() {
            return couponAmount;
        }

        public void setCouponAmount(Integer couponAmount) {
            this.couponAmount = couponAmount;
        }

        public String getCouponClickUrl() {
            return couponClickUrl;
        }

        public void setCouponClickUrl(String couponClickUrl) {
            this.couponClickUrl = couponClickUrl;
        }

        public String getCouponEndTime() {
            return couponEndTime;
        }

        public void setCouponEndTime(String couponEndTime) {
            this.couponEndTime = couponEndTime;
        }

        public Integer getCouponRemainCount() {
            return couponRemainCount;
        }

        public void setCouponRemainCount(Integer couponRemainCount) {
            this.couponRemainCount = couponRemainCount;
        }

        public String getCouponShareUrl() {
            return couponShareUrl;
        }

        public void setCouponShareUrl(String couponShareUrl) {
            this.couponShareUrl = couponShareUrl;
        }

        public String getCouponStartFee() {
            return couponStartFee;
        }

        public void setCouponStartFee(String couponStartFee) {
            this.couponStartFee = couponStartFee;
        }

        public String getCouponStartTime() {
            return couponStartTime;
        }

        public void setCouponStartTime(String couponStartTime) {
            this.couponStartTime = couponStartTime;
        }

        public Integer getCouponTotalCount() {
            return couponTotalCount;
        }

        public void setCouponTotalCount(Integer couponTotalCount) {
            this.couponTotalCount = couponTotalCount;
        }

        public String getItemDescription() {
            return itemDescription;
        }

        public void setItemDescription(String itemDescription) {
            this.itemDescription = itemDescription;
        }

        public String getItemId() {
            return itemId;
        }

        public void setItemId(String itemId) {
            this.itemId = itemId;
        }

        public Integer getLevelOneCategoryId() {
            return levelOneCategoryId;
        }

        public void setLevelOneCategoryId(Integer levelOneCategoryId) {
            this.levelOneCategoryId = levelOneCategoryId;
        }

        public String getLevelOneCategoryName() {
            return levelOneCategoryName;
        }

        public void setLevelOneCategoryName(String levelOneCategoryName) {
            this.levelOneCategoryName = levelOneCategoryName;
        }

        public String getPictUrl() {
            return pictUrl;
        }

        public void setPictUrl(String pictUrl) {
            this.pictUrl = pictUrl;
        }

        public String getReservePrice() {
            return reservePrice;
        }

        public void setReservePrice(String reservePrice) {
            this.reservePrice = reservePrice;
        }

        public Long getSellerId() {
            return sellerId;
        }

        public void setSellerId(Long sellerId) {
            this.sellerId = sellerId;
        }

        public Object getShortTitle() {
            return shortTitle;
        }

        public void setShortTitle(Object shortTitle) {
            this.shortTitle = shortTitle;
        }

        public SmallImagesDTO getSmallImages() {
            return smallImages;
        }

        public void setSmallImages(SmallImagesDTO smallImages) {
            this.smallImages = smallImages;
        }

        public String getSubTitle() {
            return subTitle;
        }

        public void setSubTitle(String subTitle) {
            this.subTitle = subTitle;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Integer getTmallPlayActivityEndTime() {
            return tmallPlayActivityEndTime;
        }

        public void setTmallPlayActivityEndTime(Integer tmallPlayActivityEndTime) {
            this.tmallPlayActivityEndTime = tmallPlayActivityEndTime;
        }

        public Integer getTmallPlayActivityStartTime() {
            return tmallPlayActivityStartTime;
        }

        public void setTmallPlayActivityStartTime(Integer tmallPlayActivityStartTime) {
            this.tmallPlayActivityStartTime = tmallPlayActivityStartTime;
        }

        public Integer getUserType() {
            return userType;
        }

        public void setUserType(Integer userType) {
            this.userType = userType;
        }

        public Integer getVolume() {
            return volume;
        }

        public void setVolume(Integer volume) {
            this.volume = volume;
        }

        public String getZkFinalPrice() {
            return zkFinalPrice;
        }

        public void setZkFinalPrice(String zkFinalPrice) {
            this.zkFinalPrice = zkFinalPrice;
        }

        public static class SmallImagesDTO {
            @SerializedName("string")
            private List<String> string;

            public List<String> getString() {
                return string;
            }

            public void setString(List<String> string) {
                this.string = string;
            }
        }
    }
}