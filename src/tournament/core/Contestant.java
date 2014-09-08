package tournament.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Table(name = "contestants")
@NamedQueries({
    @NamedQuery(
        name = "tournament.core.Contestant.findAll",
        query = "SELECT c FROM Contestant c"
    )
})
public class Contestant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    public Contestant() {
        // Jackson deserialization
    }

    public Contestant(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getName() {
        return name;
    }
}
