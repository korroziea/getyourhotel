package com.rubashenko.getyourhotel.repository.implementation;

import com.rubashenko.getyourhotel.domain.Hotels;
import com.rubashenko.getyourhotel.exception.ApiException;
import com.rubashenko.getyourhotel.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static com.rubashenko.getyourhotel.query.HotelQuery.COUNT_HOTEL_TITLE_QUERY;
import static com.rubashenko.getyourhotel.query.HotelQuery.INSERT_HOTEL_QUERY;
import static java.util.Map.of;
import static java.util.Objects.requireNonNull;

@Repository
@RequiredArgsConstructor
@Slf4j
public class HotelRepositoryImpl implements HotelRepository {
    private final NamedParameterJdbcTemplate jdbc;

    @Override
    public <S extends Hotels> S save(S hotel) {
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

    private Integer getTitleCount(String title) {
        return jdbc.queryForObject(COUNT_HOTEL_TITLE_QUERY, of("title", title), Integer.class);
    }

    private SqlParameterSource getSqlParameterSource(Hotels hotel) {
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

    @Override
    public Hotels findHotelByTitle(Hotels hotel) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Hotels> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Hotels> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Hotels> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Hotels getOne(Long aLong) {
        return null;
    }

    @Override
    public Hotels getById(Long aLong) {
        return null;
    }

    @Override
    public Hotels getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Hotels> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Hotels> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Hotels> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Hotels> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Hotels> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Hotels> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Hotels, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Hotels> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Hotels> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Hotels> findAll() {
        return null;
    }

    @Override
    public List<Hotels> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Hotels entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Hotels> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Hotels> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Hotels> findAll(Pageable pageable) {
        return null;
    }
}
