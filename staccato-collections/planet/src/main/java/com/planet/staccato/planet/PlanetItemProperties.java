package com.planet.staccato.planet;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.planet.staccato.elasticsearch.annotation.Mapping;
import com.planet.staccato.elasticsearch.annotation.MappingType;
import com.planet.staccato.extension.EO;
import com.planet.staccato.model.CoreProperties;
import com.planet.staccato.model.Provider;
import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * @author joshfix
 * Created on 1/12/18
 */
@Data
@JsonTypeName("pl")
public class PlanetItemProperties implements CoreProperties, EO, Planet {

    // CoreProperties
    private String datetime;
    private String created;
    private String updated;
    private String title;
    private String license;
    private Set<Provider> providers;

    // Collection field as part of the commons extension (merged from the collection metadata)
    //private String collection = PlanetCollectionMetadata.ID;

    // EO
    private String platform;
    private String instrument;
    private Double cloudCover;
    private Integer offNadir;
    private Double gsd;
    private Double azimuth;
    private Double sunAzimuth;
    private Double sunElevation;
    private String epsg;
    private String constellation;
    private List<Band> bands;

    // Planet
    private Boolean groundControl;
    private String itemType;
    private String provider;
    private String published;
    private String qualityCategory;
    private Double satelliteAzimuth;
    @Mapping(type = MappingType.KEYWORD)
    private String satelliteId;
    @Mapping(type = MappingType.KEYWORD)
    private String stripId;
    @Mapping(type = MappingType.DATE)
    private String plUpdated;

}

