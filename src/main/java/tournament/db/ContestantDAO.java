package tournament.db;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import tournament.core.Contestant;

import java.util.List;

public interface ContestantDAO {
    @SqlUpdate("create table if not exists contestants (id int primary key, name varchar(100), difficulty int, opponent int)")
    void createContestantsTable();

    @SqlUpdate("insert into contestants (id, name, difficulty) values (:id, :name, :difficulty)")
    void insert(@Bind("id") int id, @Bind("name") String name, @Bind("difficulty") int difficulty);

    @SqlQuery("select * from contestants where id = :id")
    @Mapper(Contestant.ContestantMapper.class)
    Contestant findById(@Bind("id") int id);

    @SqlQuery("select * from contestants")
    @Mapper(Contestant.ContestantMapper.class)
    List<Contestant> findAll();

    @SqlUpdate("update contestants set opponent=:opponent where id=:id")
    void setOpponent(@Bind("id") int id, @Bind("opponent") int opponent);

    /**
     * close with no args is used to close the connection
     */
    void close();
}