package tournament.db;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import tournament.core.User;

import java.util.List;

public interface UserDAO {
    @SqlUpdate("create table if not exists users (id int primary key, name varchar(100), password varchar(100), contestant_id int)")
    void createUserTable();

    @SqlUpdate("insert into users (id, name, password) values (:id, :name, :password)")
    void insert(@Bind("id") int id, @Bind("name") String name, @Bind("password") int password);

    @SqlQuery("select * from users where id = :id")
    @Mapper(User.UserMapper.class)
    User findById(@Bind("id") int id);

    @SqlQuery("select * from users")
    @Mapper(User.UserMapper.class)
    List<User> findAll();

    @SqlUpdate("update users set contestant_id=:contestant_id where id=:id")
    void setContestantId(@Bind("id") int id, @Bind("contestant_id") int contestantId);

    /**
     * close with no args is used to close the connection
     */
    void close();
}