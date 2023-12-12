package com.rubashenko.getyourhotel.query;

public class UserQuery {
    public static final String INSERT_USER_QUERY = "INSERT INTO User (first_name, last_name, email, password) VALUES (:firstName, :lastName, :email, :password)";
    public static final String COUNT_USER_EMAIL_QUERY = "SELECT COUNT(*) FROM User WHERE email = :email";
    public static final String INSERT_ACCOUNT_VERIFICATION_URL_QUERY = "INSERT INTO AccountVerifications (user_id, url) VALUES (:user_id, :url)";
    public static final String SELECT_PASSWORD_CORRESPOND_EMAIL_QUERY = "SELECT getyourhotel.users.password FROM User WHERE email = :email";
}
