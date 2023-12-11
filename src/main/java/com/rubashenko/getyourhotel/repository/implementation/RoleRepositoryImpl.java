package com.rubashenko.getyourhotel.repository.implementation;

import com.rubashenko.getyourhotel.domain.Roles;
import com.rubashenko.getyourhotel.exception.ApiException;
import com.rubashenko.getyourhotel.repository.RoleRepository;
import com.rubashenko.getyourhotel.rowmapper.RoleRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static com.rubashenko.getyourhotel.enumeration.RoleType.ROLE_USER;
import static com.rubashenko.getyourhotel.query.RoleQuery.*;
import static java.util.Map.of;
import static java.util.Objects.requireNonNull;

@Repository
@RequiredArgsConstructor
@Slf4j
public class RoleRepositoryImpl implements RoleRepository {
    private final NamedParameterJdbcTemplate jdbc;

    @Override
    public void addRoleToUser(Long userId, String roleName) {
        log.info("Adding role {} to user id: {}", roleName, userId);
        try {
            Roles role = jdbc.queryForObject(SELECT_ROLE_BY_NAME_QUERY, of("name", roleName), new RoleRowMapper());
            jdbc.update(INSERT_ROLE_TO_USER_QUERY, of("userId", userId, "roleId", requireNonNull(role).getId()));
        } catch (EmptyResultDataAccessException exception) {
            throw new ApiException("No role found by name: " + ROLE_USER.name());

        } catch (Exception exception) {
            log.error(exception.getMessage());
            throw new ApiException("An error occurred. Please try again.");
        }
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Roles> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Roles> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Roles> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Roles getOne(Long aLong) {
        return null;
    }

    @Override
    public Roles getById(Long aLong) {
        return null;
    }

    @Override
    public Roles getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Roles> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Roles> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Roles> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Roles> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Roles> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Roles> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Roles, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Roles> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Roles> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Roles> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Roles> findAll() {
        return null;
    }

    @Override
    public List<Roles> findAllById(Iterable<Long> longs) {
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
    public void delete(Roles entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Roles> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Roles> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Roles> findAll(Pageable pageable) {
        return null;
    }
}
