package com.rubashenko.getyourhotel.repository.implementation;

import com.rubashenko.getyourhotel.domain.Roles;
import com.rubashenko.getyourhotel.domain.Users;
import com.rubashenko.getyourhotel.exception.ApiException;
import com.rubashenko.getyourhotel.repository.RoleRepository;
import com.rubashenko.getyourhotel.repository.UserRepository;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

import static com.rubashenko.getyourhotel.enumeration.RoleType.ROLE_USER;
import static com.rubashenko.getyourhotel.enumeration.VerificationType.ACCOUNT;
import static com.rubashenko.getyourhotel.query.UserQuery.*;
import static java.util.Map.of;
import static java.util.Objects.requireNonNull;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserRepositoryImpl implements UserRepository {
    private final NamedParameterJdbcTemplate jdbc;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder encoder;

    @Override
    public <S extends Users> S save(S user) {
        // check the email is unique
        if (getEmailCount(user.getEmail().trim().toLowerCase()) > 0) throw new ApiException("Email already in use. Please use a different email and try again");
        // save new user
        try {
            KeyHolder holder = new GeneratedKeyHolder();
            SqlParameterSource parameters = getSqlParameterSource(user);
            jdbc.update(INSERT_USER_QUERY, parameters, holder);
            user.setId(requireNonNull(holder.getKey().longValue()));
            // add role to the user
            roleRepository.addRoleToUser(user.getId(), ROLE_USER.name());
            // send verification URL
            String verificationUrl = getVerificationUrl(UUID.randomUUID().toString(), ACCOUNT.getType());
            // save URL in verification table
            jdbc.update(INSERT_ACCOUNT_VERIFICATION_URL_QUERY, of("user_id", user.getId(), "url", verificationUrl));
            // send email to user with verification URL
            //emailService.sendVerificationUrl(user.getFirstName(), user.getEmail(), verificationUrl, ACCOUNT);
            user.setEnabled(false);
            user.setNonLocked(true);
            // return the newly created user
            return user;
            // if any errors, throw exception with proper message
        } catch (Exception exception) {
            log.error(exception.getMessage());
            throw new ApiException("An error occurred. Please try again.");
        }
    }

    public Users findUserByEmail(Users user) {
        if (getEmailCount(user.getEmail().trim().toLowerCase()) == 0) throw new ApiException("You are not registered. To continue register your account");
        if (!comparePasswords(user.getEmail(), user.getPassword())) throw new ApiException("Email or password are incorrect");

        try {
            Users returnUser = new Users();
            returnUser.setEmail(user.getEmail());
            return returnUser;
        } catch (Exception exception) {
            log.error(exception.getMessage());
            throw new ApiException("An error occurred. Please try again.");
        }
    }

    private Integer getEmailCount(String email) {
        return jdbc.queryForObject(COUNT_USER_EMAIL_QUERY, of("email", email), Integer.class);
    }

    private Boolean comparePasswords(String email, String password) {
        String userPassword = jdbc.queryForObject(SELECT_PASSWORD_CORRESPOND_EMAIL_QUERY, of("email", email), String.class);
        return encoder.matches(password, userPassword);
    }

    private SqlParameterSource getSqlParameterSource(Users user) {
        return new MapSqlParameterSource()
                .addValue("firstName", user.getFirstName())
                .addValue("lastName", user.getLastName())
                .addValue("email", user.getEmail())
                .addValue("password", encoder.encode(user.getPassword()));
    }

    private String getVerificationUrl(String key, String type) {
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/verify" + type + "/" + key).toUriString();
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Users> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Users> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Users> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Users getOne(Long aLong) {
        return null;
    }

    @Override
    public Users getById(Long aLong) {
        return null;
    }

    @Override
    public Users getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Users> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Users> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Users> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Users> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Users> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Users> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Users, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Users> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Users> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Users> findAll() {
        return null;
    }

    @Override
    public List<Users> findAllById(Iterable<Long> longs) {
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
    public void delete(Users entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Users> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Users> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Users> findAll(Pageable pageable) {
        return null;
    }
}
