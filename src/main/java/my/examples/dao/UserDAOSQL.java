package my.examples.dao;

public class UserDAOSQL {

    public static final String INSERT = "INSERT INTO user (name, nickname, email, passwd) VALUES (?, ?, ?, ?)";
    public static final String SELECT_BY_EMAIL = "SELECT passwd FROM user WHERE email = ?";
}
