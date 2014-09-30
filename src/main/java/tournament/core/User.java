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
public class User {
    @Id
    @JsonProperty
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private int password;
    @JsonProperty
    private Contestant contestant;

    public User(int id, String name, int password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }


    static public class UserMapper implements ResultSetMapper<User> {
        @Override
        public User map(int index, ResultSet r, StatementContext ctx) throws SQLException {
            return new User(r.getInt("id"), r.getString("name"), r.getInt("password"));
        }
    }
}
