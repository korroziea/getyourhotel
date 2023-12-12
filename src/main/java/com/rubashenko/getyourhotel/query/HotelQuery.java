package com.rubashenko.getyourhotel.query;

public class HotelQuery {
    public static final String INSERT_HOTEL_QUERY = "INSERT INTO Hotel (user_id, title, rating, country, city, distance_to_sea, wifi, conditioner) VALUES (:user_id, :title, :rating, :country, :city, :distance_to_sea, :wifi, :conditioner)";
    public static final String COUNT_HOTEL_TITLE_QUERY = "SELECT COUNT(*) FROM Hotel WHERE title = :title";
}
