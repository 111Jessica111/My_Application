package com.example.myapplication.entity;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {

    public static List<Productinfo> getProductData(int position){
        List<Productinfo> list = new ArrayList<>();
        if (position == 0){
            list.add(new Productinfo(1001, R.mipmap.book_0,"书籍出售",5,"是否可以配送：是","书籍状态：九成新","书籍名称:《微积分教程》","本书是微积分的基础教程，适合初学者和需要复习的学生。书中详细介绍了微积分的基本概念、定理及其应用，包括极限、导数、积分等内容。","品相：良好，书页无破损，封面有轻微磨损。","封面：完整，色彩鲜艳。","页码：所有页码齐全，无缺页。"));
            list.add(new Productinfo(1002, R.mipmap.book_1,"书籍出售",10,"是否可以配送：否","书籍状态：全新","书籍名称:《微积分教程》","本书是微积分的基础教程，适合初学者和需要复习的学生。书中详细介绍了微积分的基本概念、定理及其应用，包括极限、导数、积分等内容。","品相：良好，书页无破损，封面有轻微磨损。","封面：完整，色彩鲜艳。","页码：所有页码齐全，无缺页。"));
            list.add(new Productinfo(1003, R.mipmap.book_2,"书籍出售",2,"是否可以配送：是","书籍状态：全新","书籍名称:《微积分教程》","本书是微积分的基础教程，适合初学者和需要复习的学生。书中详细介绍了微积分的基本概念、定理及其应用，包括极限、导数、积分等内容。","品相：良好，书页无破损，封面有轻微磨损。","封面：完整，色彩鲜艳。","页码：所有页码齐全，无缺页。"));
            list.add(new Productinfo(1004, R.mipmap.book_3,"书籍出售",6,"是否可以配送：否","书籍状态：九成新","书籍名称:《微积分教程》","本书是微积分的基础教程，适合初学者和需要复习的学生。书中详细介绍了微积分的基本概念、定理及其应用，包括极限、导数、积分等内容。","品相：良好，书页无破损，封面有轻微磨损。","封面：完整，色彩鲜艳。","页码：所有页码齐全，无缺页。"));
            list.add(new Productinfo(1005, R.mipmap.book_4,"书籍出售",8,"是否可以配送：否","书籍状态：七成新","书籍名称:《微积分教程》","本书是微积分的基础教程，适合初学者和需要复习的学生。书中详细介绍了微积分的基本概念、定理及其应用，包括极限、导数、积分等内容。","品相：良好，书页无破损，封面有轻微磨损。","封面：完整，色彩鲜艳。","页码：所有页码齐全，无缺页。"));
            list.add(new Productinfo(1006, R.mipmap.book_5,"书籍出售",4,"是否可以配送：是","书籍状态：七成新","书籍名称:《微积分教程》","本书是微积分的基础教程，适合初学者和需要复习的学生。书中详细介绍了微积分的基本概念、定理及其应用，包括极限、导数、积分等内容。","品相：良好，书页无破损，封面有轻微磨损。","封面：完整，色彩鲜艳。","页码：所有页码齐全，无缺页。"));
            list.add(new Productinfo(1007, R.mipmap.book_6,"书籍出售",5,"是否可以配送：否","书籍状态：五成新","书籍名称:《微积分教程》","本书是微积分的基础教程，适合初学者和需要复习的学生。书中详细介绍了微积分的基本概念、定理及其应用，包括极限、导数、积分等内容。","品相：良好，书页无破损，封面有轻微磨损。","封面：完整，色彩鲜艳。","页码：所有页码齐全，无缺页。"));
        } else if (position == 1) {
            list.add(new Productinfo(1008, R.mipmap.life_0,"化妆品出售",300,"是否可以配送：否","商品状态：未拆封","书籍名称:《微积分教程》","本书是微积分的基础教程，适合初学者和需要复习的学生。书中详细介绍了微积分的基本概念、定理及其应用，包括极限、导数、积分等内容。","品相：良好，书页无破损，封面有轻微磨损。","封面：完整，色彩鲜艳。","页码：所有页码齐全，无缺页。"));
            list.add(new Productinfo(1009, R.mipmap.life_1,"化妆品出售",100,"是否可以配送：是","商品状态：未拆封","书籍名称:《微积分教程》","本书是微积分的基础教程，适合初学者和需要复习的学生。书中详细介绍了微积分的基本概念、定理及其应用，包括极限、导数、积分等内容。","品相：良好，书页无破损，封面有轻微磨损。","封面：完整，色彩鲜艳。","页码：所有页码齐全，无缺页。"));
            list.add(new Productinfo(1010, R.mipmap.life_2,"卫生纸出售",8,"是否可以配送：否","商品状态：完好","书籍名称:《微积分教程》","本书是微积分的基础教程，适合初学者和需要复习的学生。书中详细介绍了微积分的基本概念、定理及其应用，包括极限、导数、积分等内容。","品相：良好，书页无破损，封面有轻微磨损。","封面：完整，色彩鲜艳。","页码：所有页码齐全，无缺页。"));
        } else if (position == 2) {
            list.add(new Productinfo(1011, R.mipmap.elec_0,"显示屏出售",450,"是否可以配送：否","商品状态：功能完好","书籍名称:《微积分教程》","本书是微积分的基础教程，适合初学者和需要复习的学生。书中详细介绍了微积分的基本概念、定理及其应用，包括极限、导数、积分等内容。","品相：良好，书页无破损，封面有轻微磨损。","封面：完整，色彩鲜艳。","页码：所有页码齐全，无缺页。"));
            list.add(new Productinfo(1012, R.mipmap.elec_1,"游戏出售",50,"是否可以配送：是","商品状态：完好","书籍名称:《微积分教程》","本书是微积分的基础教程，适合初学者和需要复习的学生。书中详细介绍了微积分的基本概念、定理及其应用，包括极限、导数、积分等内容。","品相：良好，书页无破损，封面有轻微磨损。","封面：完整，色彩鲜艳。","页码：所有页码齐全，无缺页。"));
        }else {
            list.add(new Productinfo(1013, R.mipmap.other_0,"电动车出售",800,"是否可以配送：否","商品状态：七成新","书籍名称:《微积分教程》","本书是微积分的基础教程，适合初学者和需要复习的学生。书中详细介绍了微积分的基本概念、定理及其应用，包括极限、导数、积分等内容。","品相：良好，书页无破损，封面有轻微磨损。","封面：完整，色彩鲜艳。","页码：所有页码齐全，无缺页。"));
        }
        return list;
    }
}
