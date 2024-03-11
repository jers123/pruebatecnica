package org.javatest.assetdepreciation.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class ActiveResult extends ActiveResults {
    List<Depreciacion> depresiaciones;
}