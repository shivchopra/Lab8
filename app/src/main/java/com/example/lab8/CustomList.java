package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.content, parent, false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    /**
     * this gets size of the list
     *
     * @return
     */
    public int getCount() {
        return cities.size();
    }

    /**
     * this adds a city object to the list
     * the second phase, you can add the city
     *
     * @param city
     */
    public void addCity(City city) {
        cities.add(city);
    }


    /**
     * Returns whether given city belongs to the list.
     * @param city
     * @return
     *      Returns a boolean
     */
    public Boolean hasCity(City city) {
        if (cities.contains(city)) {
            return true;
        }
        return false;
    }

    /**
     * This deletes the city provided. If city provided is not in the list, throws exception.
     * @param city
     */
    public void deleteCity(City city) {
        if (this.hasCity(city)) {
            cities.remove(city);
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Returns how many cities are in the list.
     *
     * @return
     *      The number of cities in the list.
     */
    public int countCities() {
        return cities.size();
    }
}
