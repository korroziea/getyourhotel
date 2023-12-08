package com.rubashenko.getyourhotel.repository;

import com.rubashenko.getyourhotel.domain.Hotel;

import java.util.Collection;

public interface HotelRepository<T extends Hotel> {
    T create(T data);
    Collection<T> list(int page, int pageSize);
    T get(Long id);
    T update(T data);
    Boolean delete(Long id);
}
