package net.tajzich.mt.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: vtajzich
 * Date: 8/21/13
 */
public class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Long id;

    @Version
    @Column(name = "version")
    Integer version;
}
