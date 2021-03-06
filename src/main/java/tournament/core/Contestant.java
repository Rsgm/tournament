package tournament.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contestant {
    @Id
    @JsonProperty
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private int difficulty;
    @JsonProperty
    private int opponent;

    static public class ContestantMapper implements ResultSetMapper<Contestant> {
        @Override
        public Contestant map(int index, ResultSet r, StatementContext ctx) throws SQLException {
            return new Contestant(r.getInt("id"), r.getString("name"), r.getInt("difficulty"), r.getInt("opponent"));
        }
    }
}
