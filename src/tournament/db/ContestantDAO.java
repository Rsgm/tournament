package tournament.db;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface ContestantDAO {
    @SqlUpdate("create table contestants (id int primary key, name varchar(100))")
    void createContestantsTable();

    @SqlUpdate("insert into contestants (id, name) values (:id, :name)")
    void insert(@Bind("id") int id, @Bind("name") String name);

    @SqlQuery("select name from contestants where id = :id")
    String findNameById(@Bind("id") Integer id);

    @SqlQuery("select name from contestants where difficulty = :difficulty")
    int findDifficultyById(@Bind("difficulty") Integer difficulty);

    /**
     * close with no args is used to close the connection
     */
    void close();
}