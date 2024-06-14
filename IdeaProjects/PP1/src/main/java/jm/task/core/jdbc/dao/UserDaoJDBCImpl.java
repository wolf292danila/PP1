//package jm.task.core.jdbc.dao;
//
//import jm.task.core.jdbc.model.User;
//import jm.task.core.jdbc.util.Util;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserDaoJDBCImpl implements UserDao {
//        private static final Connection connection;
//        static {
//                try {
//                        connection = Util.getConnectToDatabase();
//                } catch (SQLException | ClassNotFoundException e) {
//                        throw new RuntimeException(e);
//                }
//        }
//
//        public UserDaoJDBCImpl() {
//        }
//
//        public void createUsersTable() {
//                try (Statement statement = connection.createStatement()) {
//                        statement.executeUpdate("CREATE TABLE IF NOT EXISTS users " +
//                                "(id SERIAL, name VARCHAR(150), last_name VARCHAR(150), age INT)");
//
//                } catch (SQLException e) {
//                        e.printStackTrace();
//                }
//        }
//
//        public void dropUsersTable() {
//                try (Statement statement = connection.createStatement()) {
//                        statement.executeUpdate("DROP TABLE IF EXISTS users");
//                } catch (SQLException e) {
//                        e.printStackTrace();
//                }
//        }
//
//        public void saveUser(String name, String lastName, byte age) {
//                try (PreparedStatement ppst = connection.prepareStatement("INSERT INTO users (name, last_name, age) " + "VALUES (?, ?, ?) ")) {
//                        ppst.setString(1, name);
//                        ppst.setString(2, lastName);
//                        ppst.setByte(3, age);
//                        ppst.executeUpdate();
//                } catch (SQLException e) {
//                        e.printStackTrace();
//                }
//        }
//
//        public void removeUserById(long id) {
//                try (PreparedStatement ppst = connection.prepareStatement("DELETE FROM users WHERE id = ?")) {
//                        ppst.setLong(1, id);
//                        ppst.executeUpdate();
//                } catch (SQLException e) {
//                        e.printStackTrace();
//                }
//        }
//
//        public List<User> getAllUsers() {
//                List<User> users = new ArrayList<>();
//                try (ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM users")) {
//                        while (resultSet.next()) {
//                                User user = new User(resultSet.getString("name"), resultSet.getString("last_name"), resultSet.getByte("age"));
//                                user.setId(resultSet.getLong("id"));
//                                users.add(user);
//                        }
//
//                } catch (SQLException e) {
//                        e.printStackTrace();
//                }
//                return users;
//        }
//
//        public void cleanUsersTable() {
//                try (Statement statement = connection.createStatement()) {
//                        statement.executeUpdate("TRUNCATE TABLE users");
//                } catch (SQLException e) {
//                        e.printStackTrace();
//                }
//        }
//}