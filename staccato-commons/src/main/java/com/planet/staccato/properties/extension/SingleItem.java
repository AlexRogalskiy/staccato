package com.planet.staccato.properties.extension;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.planet.staccato.elasticsearch.annotation.Mapping;
import com.planet.staccato.elasticsearch.annotation.MappingType;
import com.planet.staccato.model.Provider;

import java.util.Collection;

/**
 * Defines the fieldsExtension and Jackson property values for fieldsExtension in the single item extension.
 * @see <a href="https://github.com/radiantearth/stac-spec/tree/master/extensions/single-item">Single Item Extension</a>
 * @author joshfix
 * Created on 2/11/19
 */
public interface SingleItem {

    String PREFIX = "item";

    @Mapping(type = MappingType.KEYWORD)
    @JsonProperty(PREFIX + ":license")
    String getLicense();
    void setLicense(String license);

    @JsonProperty(PREFIX + ":providers")
    Collection<Provider> getProviders();
    void setProviders(Collection<Provider> providers);

}
