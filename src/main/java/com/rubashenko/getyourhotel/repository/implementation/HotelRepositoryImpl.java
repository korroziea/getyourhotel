package com.rubashenko.getyourhotel.repository.implementation;

import com.rubashenko.getyourhotel.domain.Hotel;
import com.rubashenko.getyourhotel.exception.ApiException;
import com.rubashenko.getyourhotel.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Collection;

import static com.rubashenko.getyourhotel.query.HotelQuery.COUNT_HOTEL_TITLE_QUERY;
import static com.rubashenko.getyourhotel.query.HotelQuery.INSERT_HOTEL_QUERY;
import static java.util.Map.of;
import static java.util.Objects.requireNonNull;

@Repository
@RequiredArgsConstructor
@Slf4j
public class HotelRepositoryImpl implements HotelRepository<Hotel> {
    private final NamedParameterJdbcTemplate jdbc;

    @Override
    public Hotel create(Hotel hotel) {
        if (getTitleCount(hotel.getTitle().trim().toLowerCase()) > 0) throw new ApiException("Title already in use. Please use a different title and try again");

        try {
            KeyHolder holder = new GeneratedKeyHolder();
            SqlParameterSource parameters = getSqlParameterSource(hotel);
            jdbc.update(INSERT_HOTEL_QUERY, parameters, holder);
            hotel.setId(requireNonNull(holder.getKey().longValue()));
            return hotel;

//            Hotel returnHotel = new Hotel();
//            returnHotel.setUser_id(hotel.getUser_id());
//            returnHotel.setTitle(hotel.getTitle());
//            returnHotel.setRating(hotel.getRating());
//            returnHotel.setCountry(hotel.getCountry());
//            returnHotel.setCity(hotel.getCity());
//            returnHotel.setDistanceToSea(hotel.getDistanceToSea());
//            returnHotel.setHasWifi(hotel.getHasWifi());
//            returnHotel.setHasConditioner(hotel.getHasConditioner());
//            return returnHotel;
        } catch (Exception exception) {
            log.error(exception.getMessage());
            throw new ApiException("An error occurred. Please try again.");
        }
    }

    @Override
    public Collection<Hotel> list(int page, int pageSize) {
        return null;
    }

    @Override
    public Hotel get(Long id) {
        return null;
    }

    @Override
    public Hotel update(Hotel data) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    private Integer getTitleCount(String title) {
        return jdbc.queryForObject(COUNT_HOTEL_TITLE_QUERY, of("title", title), Integer.class);
    }

    private SqlParameterSource getSqlParameterSource(Hotel hotel) {
        return new MapSqlParameterSource()
                .addValue("user_id", 6)
                .addValue("title", hotel.getTitle())
                .addValue("rating", hotel.getRating())
                .addValue("country", hotel.getCountry())
                .addValue("city", hotel.getCity())
                .addValue("distance_to_sea", hotel.getDistanceToSea())
                .addValue("wifi", hotel.getHasWifi())
                .addValue("conditioner", hotel.getHasConditioner());
    }
}
