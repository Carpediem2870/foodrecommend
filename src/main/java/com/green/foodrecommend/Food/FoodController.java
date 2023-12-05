package com.green.foodrecommend.Food;

import com.green.foodrecommend.Food.model.*;
import com.green.foodrecommend.common.Const;
import com.green.foodrecommend.common.ResVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/food")
public class FoodController {
    private final FoodService service;
    @PostMapping
    public ResVo postFood(@RequestBody FoodInsDto dto){
       return service.postFood(dto);
    }
    @GetMapping
    public List<FoodSelVo> getFoodList(FoodSelDto dto){
        return service.getFoodList(dto);
    }
    @PutMapping
    public ResVo updFood(@RequestBody FoodUpdDto dto){
        return service.updFood(dto);
    }
    @PutMapping("/pic")
    public ResVo updFoodPic(@RequestBody FoodPicUpdDto dto){
       return service.updFoodPic(dto);
    }
    @PutMapping("/tag")
    public ResVo updFoodTag(@RequestBody FoodTagUpdDto dto){
        return service.updFoodTag(dto);
    }
    @DeleteMapping
    public ResVo delFood(int ifood){
        return service.delFood(ifood);
    }
    @DeleteMapping("/pic")
    public ResVo delFoodPic(int ipic){
        return service.delFoodPic(ipic);
    }
    @DeleteMapping("/tag")
    public ResVo delFoodTag(int itag){
        return service.delFoodTag(itag);
    }
}
