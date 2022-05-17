package test.task.SpringProject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "sum_entity")
public class SumEntity {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private Long value;
}
