package com.shotinleg.smartchoice;

import java.util.ArrayList;

/**
 * Created by shotinleg on 26.11.15.
 */
public class SetRestaurant
{
    public static ArrayList<SetRestaurant> listSetRestaurant;

    final static public class ObjectRestaurant
    {
        private int id;
        private String name;
        private String price;
        private String calories;
        private String type;

        public void setId( int _id ) { id = _id; }
        public void setName( String _name) { name = _name; }
        public void setPrice( String _price ) { price = _price; }
        public void setCalories( String _colories ) { calories = _colories; }
        public void setType( String _type ) { type = _type; }

        public int    getId() { return id; }
        public String getName() { return name; }
        public String getPrice() { return price; }
        public String getCalories()
        {
            return calories;
        }
        public String getType() { return type; }
    }

    private String price;
    private String calories;
    private ArrayList< ObjectRestaurant > objects;

    public void setPrice( String _price )
    {
        price = _price;
    }
    public void setCalories( String _colories )
    {
        calories = _colories;
    }
    public void setObjects( ArrayList< ObjectRestaurant > _objects )
    {
        objects = _objects;
    }
    public String getPrice()
    {
        return price;
    }
    public String getCalories()
    {
        return calories;
    }
    public ArrayList< ObjectRestaurant > getObjects()
    {
        return  objects;
    }

    public static int getIconFormId( int idItem )
    {
        if( idItem == 2 ) return R.mipmap.sandwich2;
        if( idItem == 3 ) return R.mipmap.sandwich3;
        if( idItem == 4 ) return R.mipmap.sandwich4;
        if( idItem == 5 ) return R.mipmap.sandwich5;
        if( idItem == 9 ) return R.mipmap.sandwich9;
        if( idItem == 11 ) return R.mipmap.sandwich11;
        if( idItem == 12 ) return R.mipmap.sandwich12;
        if( idItem == 13 ) return R.mipmap.sandwich13;
        if( idItem == 14 ) return R.mipmap.sandwich14;
        if( idItem == 15 ) return R.mipmap.sandwich15;
        if( idItem == 16 ) return R.mipmap.sandwich16;

        if( idItem == 52 || idItem == 60 ) return R.mipmap.cdrink03;
        if( idItem == 53 || idItem == 61 ) return R.mipmap.cdrink04;
        if( idItem == 54 ) return R.mipmap.cdrink05;
        if( idItem == 55 || idItem == 62 ) return R.mipmap.cdrink08;

        if( idItem >= 64 && idItem <= 65 ) return R.mipmap.tea;
        if( idItem >= 66 && idItem <= 67 ) return R.mipmap.coffeeblack;
        if( idItem == 68 ) return R.mipmap.coffeeessp;
        if( idItem >= 69 && idItem <= 73 ) return R.mipmap.coffeemilk;

        if( idItem == 36 ) return R.mipmap.sfrie;
        if( idItem == 37 ) return R.mipmap.mfrie;
        if( idItem == 38 ) return R.mipmap.bfrie;
        if( idItem == 38 ) return R.mipmap.vfrie;

        if( idItem >= 57 && idItem <= 59 ) return R.mipmap.cdrinkbottle;

        if( idItem == 43 ) return R.mipmap.souse;

        return R.mipmap.ic_launcher;
    }
}
