package com.jz.appframe.data.bean;

import com.google.gson.annotations.SerializedName;

public class Data {

        private String title;
        private String pic;
        @SerializedName("food_str")
        private String foodStr;


        public void setTitle(String title) {
            this.title = title;
        }
        public String getTitle() {
            return title;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }
        public String getPic() {
            return pic;
        }

        public void setFoodStr(String foodStr) {
            this.foodStr = foodStr;
        }
        public String getFoodStr() {
            return foodStr;
        }

}
