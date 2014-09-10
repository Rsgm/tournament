package tournament.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "contestants")
public class Contestant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    public Contestant() {
        // Jackson deserialization
    }

    public Contestant(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Column(name = "id")
    @JsonProperty
    public long getId() {
        return id;
    }

    @Column(name = "name")
    @JsonProperty
    public String getName() {
        return name;
    }
}
