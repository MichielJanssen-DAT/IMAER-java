/*
 * Copyright the State of the Netherlands
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 */
package nl.overheid.aerius.shared.domain.v2.scenario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import nl.overheid.aerius.shared.domain.scenario.SituationType;
import nl.overheid.aerius.shared.domain.v2.building.BuildingFeature;
import nl.overheid.aerius.shared.domain.v2.geojson.FeatureCollection;
import nl.overheid.aerius.shared.domain.v2.cimlk.CIMLKCorrection;
import nl.overheid.aerius.shared.domain.v2.cimlk.CIMLKDispersionLineFeature;
import nl.overheid.aerius.shared.domain.v2.cimlk.CIMLKMeasureFeature;
import nl.overheid.aerius.shared.domain.v2.source.EmissionSourceFeature;

/**
 * Object containing situation specific information.
 */
public class ScenarioSituation implements Serializable {

  private static final long serialVersionUID = 3L;

  // Initialize with random number, and strip first '0.' to make a dot-less number.
  private String id = String.valueOf(Math.random()).substring(2);
  private int year;
  private String name;
  private String reference;
  private SituationType type;
  private Double nettingFactor;
  private Definitions definitions = new Definitions();
  private final FeatureCollection<EmissionSourceFeature> sources = new FeatureCollection<>();
  private final FeatureCollection<CIMLKDispersionLineFeature> cimlkDispersionLines = new FeatureCollection<>();
  private final FeatureCollection<CIMLKMeasureFeature> cimlkMeasures = new FeatureCollection<>();
  private final List<CIMLKCorrection> cimlkCorrections = new ArrayList<>();
  private final FeatureCollection<BuildingFeature> buildings = new FeatureCollection<>();

  public String getId() {
    return id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public int getYear() {
    return year;
  }

  public void setYear(final int year) {
    this.year = year;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getReference() {
    return reference;
  }

  public void setReference(final String reference) {
    this.reference = reference;
  }

  public SituationType getType() {
    return type;
  }

  public void setType(final SituationType type) {
    this.type = type;
  }

  public Double getNettingFactor() {
    return nettingFactor;
  }

  public void setNettingFactor(final Double nettingFactor) {
    this.nettingFactor = nettingFactor;
  }

  public Definitions getDefinitions() {
    return definitions;
  }

  public void setDefinitions(final Definitions definitions) {
    this.definitions = definitions;
  }

  @JsonProperty("emissionSources")
  public FeatureCollection<EmissionSourceFeature> getSources() {
    return sources;
  }

  @JsonIgnore
  public List<EmissionSourceFeature> getEmissionSourcesList() {
    return sources.getFeatures();
  }

  @JsonProperty("cimlkDispersionLines")
  public FeatureCollection<CIMLKDispersionLineFeature> getCimlkDispersionLines() {
    return cimlkDispersionLines;
  }

  @JsonIgnore
  public List<CIMLKDispersionLineFeature> getCimlkDispersionLinesList() {
    return cimlkDispersionLines.getFeatures();
  }

  public FeatureCollection<CIMLKMeasureFeature> getCimlkMeasures() {
    return cimlkMeasures;
  }

  @JsonIgnore
  public List<CIMLKMeasureFeature> getCimlkMeasuresList() {
    return cimlkMeasures.getFeatures();
  }

  public List<CIMLKCorrection> getCimlkCorrections() {
    return cimlkCorrections;
  }

  public FeatureCollection<BuildingFeature> getBuildings() {
    return buildings;
  }

  @JsonIgnore
  public List<BuildingFeature> getBuildingsList() {
    return buildings.getFeatures();
  }

}
