package com.green.foodrecommend.Food;

import com.green.foodrecommend.Food.model.*;
import com.green.foodrecommend.common.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FoodService {
    private final FoodMapper mapper;

    public ResVo postFood(FoodInsDto dto){
        int cnt= mapper.insFood(dto);
        int cnt2= mapper.insFoodPics(dto);
        int cnt3= mapper.insFoodTags(dto);
        return new ResVo(Const.SUCCESS);
    }
    public List<FoodSelVo> getFoodList(FoodSelDto dto){
        List<FoodSelVo> list= mapper.selFood(dto);
        List<Integer> ifoodList= new ArrayList();
        Map<Integer, FoodSelVo> foodMap= new HashMap();
        for(FoodSelVo vo: list){
            ifoodList.add(vo.getIfood());
            foodMap.put(vo.getIfood(), vo);
            vo.setPics(new ArrayList());
            vo.setTags(new ArrayList());
        }
        List<FoodPicSelVo> picList= mapper.selPicsByIfood(ifoodList);
        List<FoodTagSelVo> tagList= mapper.selTagsByIfood(ifoodList);
        for(FoodPicSelVo vo: picList){
            foodMap.get(vo.getIfood()).getPics().add(vo.getPic());
        }
        for(FoodTagSelVo vo: tagList){
            foodMap.get(vo.getIfood()).getTags().add(vo.getTag());
        }
        return list;
    }
    public ResVo updFood(FoodUpdDto dto){
        int cnt= mapper.updFood(dto);
        return new ResVo(Const.SUCCESS);  // 1
    }
    public ResVo updFoodPic(FoodPicUpdDto dto){
        int cnt= mapper.updFoodPic(dto);
        return new ResVo(Const.SUCCESS);
    }
    public ResVo updFoodTag(FoodTagUpdDto dto){
        int cnt= mapper.updFoodTag(dto);
        return new ResVo(Const.SUCCESS);
    }
    public ResVo delFood(int ifood){
        mapper.delFoodPicsByIfood(ifood);
        mapper.delFoodTagsByIfood(ifood);
        mapper.delFood(ifood);
        return new ResVo(Const.SUCCESS);
    }
    public ResVo delFoodPic(int ipic){
        return new ResVo(mapper.delFoodPic(ipic));
    }
    public ResVo delFoodTag(int itag){
        return new ResVo(mapper.delFoodTag(itag));
    }
}
