package com.green.foodrecommend.Food;

import com.green.foodrecommend.Food.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FoodMapper {
    int insFood(FoodInsDto dto);
    int insFoodPics(FoodInsDto dto);
    int insFoodTags(FoodInsDto dto);
    List<FoodSelVo> selFood(FoodSelDto dto);
    List<FoodPicSelVo> selPicsByIfood(List<Integer> ifoodList);
    List<FoodTagSelVo> selTagsByIfood(List<Integer> ifoodList);
    int updFood(FoodUpdDto dto);
    int updFoodPic(FoodPicUpdDto dto);
    int updFoodTag(FoodTagUpdDto dto);
    int delFood(int ifood);
    int delFoodPic(int ipic);
    int delFoodPicsByIfood(int ifood);
    int delFoodTag(int itag);
    int delFoodTagsByIfood(int ifood);

}
