package com.planet.staccato.extension;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.planet.staccato.elasticsearch.annotation.Mapping;
import com.planet.staccato.elasticsearch.annotation.MappingType;
import lombok.Data;

import java.util.List;

/**
 * Defines the fields and Jackson property values for fields in the EO extension.
 * @see <a href="https://github.com/radiantearth/stac-spec/tree/master/extensions/eo">EO Extension</a>
 * @author joshfix
 * Created on 4/18/18
 */
public interface EO {

    @Mapping(type = MappingType.KEYWORD)
    @JsonProperty("eo:constellation")
    String getConstellation();
    void setConstellation(String constellation);

    @Mapping(type = MappingType.KEYWORD)
    @JsonProperty("eo:platform")
    String getPlatform();
    void setPlatform(String platform);

    @Mapping(type = MappingType.KEYWORD)
    @JsonProperty("eo:instrument")
    String getInstrument();
    void setInstrument(String instrument);

    @JsonProperty("eo:gsd")
    Double getGsd();
    void setGsd(Double gsd);

    @JsonProperty("eo:cloud_cover")
    Double getCloudCover();
    void setCloudCover(Double cloudCover);

    @JsonProperty("eo:off_nadir")
    Integer getOffNadir();
    void setOffNadir(Integer offNadir);

    @JsonProperty("eo:azimuth")
    Double getAzimuth();
    void setAzimuth(Double azimuth);

    @JsonProperty("eo:sun_azimuth")
    Double getSunAzimuth();
    void setSunAzimuth(Double sunAzimuth);

    @JsonProperty("eo:sun_elevation")
    Double getSunElevation();
    void setSunElevation(Double sunElevation);

    @Mapping(type = MappingType.KEYWORD)
    @JsonProperty("eo:epsg")
    String getEpsg();
    void setEpsg(String epsg);

    @JsonProperty("eo:bands")
    List<Band> getBands();
    void setBands(List<Band> bands);

    @Data
    class Band {

        @Mapping(type = MappingType.KEYWORD)
        private String id;

        @Mapping(type = MappingType.KEYWORD)
        @JsonProperty("common_name")
        private String commmonName;

        private Integer gsd;

        @JsonProperty("center_wavelength")
        private Double centerWavelength;

        @JsonProperty("full_width_half_max")
        private Double fullWidthHalfMax;

        public static Band build() {
            return new Band();
        }

        @Mapping(type = MappingType.KEYWORD)
        public Band id(String id) {
            setId(id);
            return this;
        }

        @Mapping(type = MappingType.KEYWORD)
        public Band commonName(String commonName) {
            setCommmonName(commonName);
            return this;
        }

        public Band gsd(int gsd) {
            setGsd(gsd);
            return this;
        }

        public Band centerWavelength(double centerWavelength) {
            setCenterWavelength(centerWavelength);
            return this;
        }

        public Band fullWidthHalfMax(double fullWidthHalfMax) {
            setFullWidthHalfMax(fullWidthHalfMax);
            return this;
        }

    }
}
