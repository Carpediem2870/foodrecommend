package com.green.foodrecommend.Food.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class FoodInsDto {
    @JsonIgnore
    private int ifood;
    private String title;
    private String ingredient;
    private String recipe;
    private String comment;
    private List<String> pics;
    private List<String> tags;
}
