package com.rubashenko.getyourhotel.repository.implementation;

import com.rubashenko.getyourhotel.domain.Role;
import com.rubashenko.getyourhotel.domain.User;
import com.rubashenko.getyourhotel.exception.ApiException;
import com.rubashenko.getyourhotel.repository.RoleRepository;
import com.rubashenko.getyourhotel.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;

import static com.rubashenko.getyourhotel.enumeration.RoleType.ROLE_USER;
import static com.rubashenko.getyourhotel.repository.UserQuery.*;
import static java.util.Objects.requireNonNull;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserRepositoryImpl implements UserRepository<User> {
    private final NamedParameterJdbcTemplate jdbc;
    private final RoleRepository<Role> roleRepository;

    @Override
    public User create(User user) {
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
            // save URL in verification table
            // send email to user with verification URL
            // return the newly created user
            // if any errors, throw exception with proper message
        } catch (EmptyResultDataAccessException exception) {

        } catch (Exception exception) {

        }
        return null;
    }

    @Override
    public Collection<User> list(int page, int pageSize) {
        return null;
    }

    @Override
    public User get(Long id) {
        return null;
    }

    @Override
    public User update(User data) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    private Integer getEmailCount(String email) {
        return jdbc.queryForObject(COUNT_USER_EMAIL_QUERY, Map.of("email", email), Integer.class);
    }

    private SqlParameterSource getSqlParameterSource(User user) {
    }
}
