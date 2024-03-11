package org.javatest.assetdepreciation.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.javatest.assetdepreciation.model.Depreciation;

import java.time.LocalDate;

import static org.javatest.assetdepreciation.utils.SystemConstants.ACTIVE_TABLE;
import static org.javatest.assetdepreciation.utils.SystemConstants.DATABASE;
import static org.javatest.assetdepreciation.utils.SystemConstants.DEPRECIATION_TYPE;
import static org.javatest.assetdepreciation.utils.SystemConstants.DESCRIPTION;
import static org.javatest.assetdepreciation.utils.SystemConstants.DESCRIPTION_LENGTH;
import static org.javatest.assetdepreciation.utils.SystemConstants.ID;
import static org.javatest.assetdepreciation.utils.SystemConstants.NAME;
import static org.javatest.assetdepreciation.utils.SystemConstants.NAME_LENGTH;
import static org.javatest.assetdepreciation.utils.SystemConstants.PURCHASE_DATE;
import static org.javatest.assetdepreciation.utils.SystemConstants.PURCHASE_VALUE;
import static org.javatest.assetdepreciation.utils.SystemConstants.SCHEMA;
import static org.javatest.assetdepreciation.utils.SystemConstants.SERIAL;
import static org.javatest.assetdepreciation.utils.SystemConstants.SERIAL_LENGTH;

@Entity
@Table(name = ACTIVE_TABLE, catalog = DATABASE, schema = SCHEMA,
        uniqueConstraints = {
                @UniqueConstraint(name = ACTIVE_TABLE + "_" + SERIAL + "_uk", columnNames = {SERIAL})
        }
)
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Active {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ACTIVE_TABLE + "_" + ID)
    private Integer idActive;

    @Column(name = SERIAL, nullable = false, length = SERIAL_LENGTH, unique = true)
    private String serial;

    @Column(name = NAME, nullable = false, length = NAME_LENGTH)
    private String name;

    @Column(name = DESCRIPTION, length = DESCRIPTION_LENGTH)
    private String description;

    @Column(name = PURCHASE_DATE, nullable = false)
    private LocalDate purchaseDate;

    @Column(name = PURCHASE_VALUE, nullable = false)
    private Double purchaseValue;

    @Column(name = DEPRECIATION_TYPE, nullable = false)
    private Depreciation depreciationType;
}