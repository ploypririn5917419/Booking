package com.makeup.sever.entity;
import javax.persistence.*;
import lombok.*;
@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Staff")
public class Staff {
    @Id
    @SequenceGenerator(name = "staff_seq", sequenceName = "staff_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "staff_seq")
    @Column(name = "StaffID", unique = true, nullable = false)
    private @NonNull Long stID;
    private  String staffIDs;
    private  String staffName;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Position.class)
    @JoinColumn(name = "positionId", insertable = true)
    private Position position;
}