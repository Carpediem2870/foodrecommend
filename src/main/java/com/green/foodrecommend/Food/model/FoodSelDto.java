package com.green.foodrecommend.Food.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.green.foodrecommend.common.Const;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class FoodSelDto {
    private int page;
    @Schema(required=false)
    private String tag;
    @JsonIgnore
    private int startIdx;
    @JsonIgnore
    private int rowCount= Const.FOOD_ROWCOUNT;

    public void setPage(int page){
        this.startIdx= (page-1)*rowCount;
    }
}
