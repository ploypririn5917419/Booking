package com.makeup.sever.entity;
import javax.persistence.*;
import lombok.*;
@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Position") //ชื่อตาราง
public class Position {
    @Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
    @SequenceGenerator(name="position_seq",sequenceName="position_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="position_seq")
    @Column(name="PositionID",unique = true, nullable = false)
    private @NonNull Long positionId;
    private  String positionIds;
    private  String positionName;

    }