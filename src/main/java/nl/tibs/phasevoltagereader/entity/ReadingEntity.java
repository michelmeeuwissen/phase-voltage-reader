package nl.tibs.phasevoltagereader.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Getter
@Setter
@Table(name = "readings")
public class ReadingEntity {

    public ReadingEntity() {
        this.created = LocalDateTime.now();
        this.id = UUID.randomUUID();
    }

    @Id
    private UUID id;

    @NotNull
    @Column(name = "l1_v")
    private int l1Voltage;

    @NotNull
    @Column(name = "l2_v")
    private int l2Voltage;

    @NotNull
    @Column(name = "l3_v")
    private int l3Voltage;

    @NotNull
    @Column(name = "created")
    private LocalDateTime created;

}
