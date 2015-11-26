package com.shotinleg.smartchoice;

import java.util.ArrayList;

/**
 * Created by shotinleg on 26.11.15.
 */
public class SetRestaurant
{
    final static public class ObjectRestaurant
    {
        private String name;
        private String price;
        private String calories;

        public void setName( String _name) { name = _name; }
        public void setPrice( String _price )
        {
            price = _price;
        }
        public void setCalories( String _colories ) { calories = _colories; }

        public String getName() { return name; }
        public String getPrice()
        {
            return price;
        }
        public String getCalories()
        {
            return calories;
        }
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
}
