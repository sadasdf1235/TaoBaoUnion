package com.ld.model.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SelectCategories {

    @SerializedName("success")
    private Boolean success;
    @SerializedName("code")
    private Integer code;

    @Override
    public String toString() {
        return "SelectCategories{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

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
        @Override
        public String toString() {
            return "DataDTO{" +
                    "type=" + type +
                    ", favoritesId=" + favoritesId +
                    ", favoritesTitle='" + favoritesTitle + '\'' +
                    '}';
        }

        @SerializedName("type")
        private Integer type;
        @SerializedName("favorites_id")
        private Integer favoritesId;
        @SerializedName("favorites_title")
        private String favoritesTitle;

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public Integer getFavoritesId() {
            return favoritesId;
        }

        public void setFavoritesId(Integer favoritesId) {
            this.favoritesId = favoritesId;
        }

        public String getFavoritesTitle() {
            return favoritesTitle;
        }

        public void setFavoritesTitle(String favoritesTitle) {
            this.favoritesTitle = favoritesTitle;
        }
    }
}
