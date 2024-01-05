package com.ld.model.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SelectContent {
    @Override
    public String toString() {
        return "SelectContent{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    @SerializedName("success")
    private Boolean success;
    @SerializedName("code")
    private Integer code;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private DataDTO data;

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

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public static class DataDTO {
        @Override
        public String toString() {
            return "DataDTO{" +
                    "tbkUatmFavoritesItemGetResponse=" + tbkUatmFavoritesItemGetResponse +
                    '}';
        }

        @SerializedName("tbk_uatm_favorites_item_get_response")
        private TbkUatmFavoritesItemGetResponseDTO tbkUatmFavoritesItemGetResponse;

        public TbkUatmFavoritesItemGetResponseDTO getTbkUatmFavoritesItemGetResponse() {
            return tbkUatmFavoritesItemGetResponse;
        }

        public void setTbkUatmFavoritesItemGetResponse(TbkUatmFavoritesItemGetResponseDTO tbkUatmFavoritesItemGetResponse) {
            this.tbkUatmFavoritesItemGetResponse = tbkUatmFavoritesItemGetResponse;
        }

        public static class TbkUatmFavoritesItemGetResponseDTO {
            @SerializedName("results")
            private ResultsDTO results;

            @Override
            public String toString() {
                return "TbkUatmFavoritesItemGetResponseDTO{" +
                        "results=" + results +
                        ", totalResults=" + totalResults +
                        ", requestId='" + requestId + '\'' +
                        '}';
            }

            @SerializedName("total_results")
            private Integer totalResults;
            @SerializedName("request_id")
            private String requestId;

            public ResultsDTO getResults() {
                return results;
            }

            public void setResults(ResultsDTO results) {
                this.results = results;
            }

            public Integer getTotalResults() {
                return totalResults;
            }

            public void setTotalResults(Integer totalResults) {
                this.totalResults = totalResults;
            }

            public String getRequestId() {
                return requestId;
            }

            public void setRequestId(String requestId) {
                this.requestId = requestId;
            }

            public static class ResultsDTO {
                @Override
                public String toString() {
                    return "ResultsDTO{" +
                            "favoriteId=" + favoriteId +
                            ", uatmTbkItem=" + uatmTbkItem +
                            '}';
                }

                @SerializedName("favoriteId")
                private Integer favoriteId;
                @SerializedName("uatm_tbk_item")
                private List<UatmTbkItemDTO> uatmTbkItem;

                public Integer getFavoriteId() {
                    return favoriteId;
                }

                public void setFavoriteId(Integer favoriteId) {
                    this.favoriteId = favoriteId;
                }

                public List<UatmTbkItemDTO> getUatmTbkItem() {
                    return uatmTbkItem;
                }

                public void setUatmTbkItem(List<UatmTbkItemDTO> uatmTbkItem) {
                    this.uatmTbkItem = uatmTbkItem;
                }

                public static class UatmTbkItemDTO {
                    @Override
                    public String toString() {
                        return "UatmTbkItemDTO{" +
                                "clickUrl='" + clickUrl + '\'' +
                                ", couponClickUrl='" + couponClickUrl + '\'' +
                                ", couponEndTime='" + couponEndTime + '\'' +
                                ", couponInfo='" + couponInfo + '\'' +
                                ", couponRemainCount=" + couponRemainCount +
                                ", couponStartTime='" + couponStartTime + '\'' +
                                ", couponTotalCount=" + couponTotalCount +
                                ", eventEndTime='" + eventEndTime + '\'' +
                                ", eventStartTime='" + eventStartTime + '\'' +
                                ", itemUrl='" + itemUrl + '\'' +
                                ", numIid=" + numIid +
                                ", pictUrl='" + pictUrl + '\'' +
                                ", reservePrice='" + reservePrice + '\'' +
                                ", status=" + status +
                                ", title='" + title + '\'' +
                                ", tkRate='" + tkRate + '\'' +
                                ", type=" + type +
                                ", userType=" + userType +
                                ", volume=" + volume +
                                ", zkFinalPrice='" + zkFinalPrice + '\'' +
                                ", zkFinalPriceWap='" + zkFinalPriceWap + '\'' +
                                '}';
                    }

                    @SerializedName("click_url")
                    private String clickUrl;
                    @SerializedName("coupon_click_url")
                    private String couponClickUrl;
                    @SerializedName("coupon_end_time")
                    private String couponEndTime;
                    @SerializedName("coupon_info")
                    private String couponInfo;
                    @SerializedName("coupon_remain_count")
                    private Integer couponRemainCount;
                    @SerializedName("coupon_start_time")
                    private String couponStartTime;
                    @SerializedName("coupon_total_count")
                    private Integer couponTotalCount;
                    @SerializedName("event_end_time")
                    private String eventEndTime;
                    @SerializedName("event_start_time")
                    private String eventStartTime;
                    @SerializedName("item_url")
                    private String itemUrl;
                    @SerializedName("num_iid")
                    private Long numIid;
                    @SerializedName("pict_url")
                    private String pictUrl;
                    @SerializedName("reserve_price")
                    private String reservePrice;
                    @SerializedName("status")
                    private Integer status;
                    @SerializedName("title")
                    private String title;
                    @SerializedName("tk_rate")
                    private String tkRate;
                    @SerializedName("type")
                    private Integer type;
                    @SerializedName("user_type")
                    private Integer userType;
                    @SerializedName("volume")
                    private Integer volume;
                    @SerializedName("zk_final_price")
                    private String zkFinalPrice;
                    @SerializedName("zk_final_price_wap")
                    private String zkFinalPriceWap;

                    public String getClickUrl() {
                        return clickUrl;
                    }

                    public void setClickUrl(String clickUrl) {
                        this.clickUrl = clickUrl;
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

                    public String getCouponInfo() {
                        return couponInfo;
                    }

                    public void setCouponInfo(String couponInfo) {
                        this.couponInfo = couponInfo;
                    }

                    public Integer getCouponRemainCount() {
                        return couponRemainCount;
                    }

                    public void setCouponRemainCount(Integer couponRemainCount) {
                        this.couponRemainCount = couponRemainCount;
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

                    public String getEventEndTime() {
                        return eventEndTime;
                    }

                    public void setEventEndTime(String eventEndTime) {
                        this.eventEndTime = eventEndTime;
                    }

                    public String getEventStartTime() {
                        return eventStartTime;
                    }

                    public void setEventStartTime(String eventStartTime) {
                        this.eventStartTime = eventStartTime;
                    }

                    public String getItemUrl() {
                        return itemUrl;
                    }

                    public void setItemUrl(String itemUrl) {
                        this.itemUrl = itemUrl;
                    }

                    public Long getNumIid() {
                        return numIid;
                    }

                    public void setNumIid(Long numIid) {
                        this.numIid = numIid;
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

                    public Integer getStatus() {
                        return status;
                    }

                    public void setStatus(Integer status) {
                        this.status = status;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getTkRate() {
                        return tkRate;
                    }

                    public void setTkRate(String tkRate) {
                        this.tkRate = tkRate;
                    }

                    public Integer getType() {
                        return type;
                    }

                    public void setType(Integer type) {
                        this.type = type;
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

                    public String getZkFinalPriceWap() {
                        return zkFinalPriceWap;
                    }

                    public void setZkFinalPriceWap(String zkFinalPriceWap) {
                        this.zkFinalPriceWap = zkFinalPriceWap;
                    }
                }
            }
        }
    }
}
