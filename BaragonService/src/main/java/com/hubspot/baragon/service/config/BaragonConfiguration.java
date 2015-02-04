package com.hubspot.baragon.service.config;

import io.dropwizard.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Optional;
import com.hubspot.baragon.config.AuthConfiguration;
import com.hubspot.baragon.config.HttpClientConfiguration;
import com.hubspot.baragon.config.ZooKeeperConfiguration;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaragonConfiguration extends Configuration {
  public static final String DEFAULT_AGENT_REQUEST_URI_FORMAT = "%s/request/%s";

  @JsonProperty("zookeeper")
  @NotNull
  @Valid
  private ZooKeeperConfiguration zooKeeperConfiguration;

  @JsonProperty("httpClient")
  @NotNull
  @Valid
  private HttpClientConfiguration httpClientConfiguration = new HttpClientConfiguration();

  @JsonProperty("workerIntervalMs")
  @Deprecated
  private Long workerIntervalMs = null;

  @JsonProperty("worker")
  @NotNull
  @Valid
  private BaragonWorkerConfiguration workerConfiguration = new BaragonWorkerConfiguration();

  @JsonProperty("agentRequestUriFormat")
  @NotEmpty
  private String agentRequestUriFormat = DEFAULT_AGENT_REQUEST_URI_FORMAT;

  @JsonProperty("agentMaxAttempts")
  @Min(1)
  private int agentMaxAttempts = 5;

  @JsonProperty("auth")
  @NotNull
  @Valid
  private AuthConfiguration authConfiguration = new AuthConfiguration();

  @JsonProperty("hostname")
  private String hostname;

  @JsonProperty("masterAuthKey")
  private String masterAuthKey;

  public ZooKeeperConfiguration getZooKeeperConfiguration() {
    return zooKeeperConfiguration;
  }

  public HttpClientConfiguration getHttpClientConfiguration() {
    return httpClientConfiguration;
  }

  public void setHttpClientConfiguration(HttpClientConfiguration httpClientConfiguration) {
    this.httpClientConfiguration = httpClientConfiguration;
  }

  public void setZooKeeperConfiguration(ZooKeeperConfiguration zooKeeperConfiguration) {
    this.zooKeeperConfiguration = zooKeeperConfiguration;
  }

  public String getAgentRequestUriFormat() {
    return agentRequestUriFormat;
  }

  public void setAgentRequestUriFormat(String agentRequestUriFormat) {
    this.agentRequestUriFormat = agentRequestUriFormat;
  }

  public Optional<Long> getWorkerIntervalMs() {
    return Optional.fromNullable(workerIntervalMs);
  }

  public void setWorkerIntervalMs(Long workerIntervalMs) {
    this.workerIntervalMs = workerIntervalMs;
  }

  public int getAgentMaxAttempts() {
    return agentMaxAttempts;
  }

  public void setAgentMaxAttempts(int agentMaxAttempts) {
    this.agentMaxAttempts = agentMaxAttempts;
  }

  public String getHostname() {
    return hostname;
  }

  public void setHostname(String hostname) {
    this.hostname = hostname;
  }

  public AuthConfiguration getAuthConfiguration() {
    return authConfiguration;
  }

  public void setAuthConfiguration(AuthConfiguration authConfiguration) {
    this.authConfiguration = authConfiguration;
  }

  public String getMasterAuthKey() {
    return masterAuthKey;
  }

  public void setMasterAuthKey(String masterAuthKey) {
    this.masterAuthKey = masterAuthKey;
  }

  public BaragonWorkerConfiguration getWorkerConfiguration() {
    return workerConfiguration;
  }

  public void setWorkerConfiguration(BaragonWorkerConfiguration workerConfiguration) {
    this.workerConfiguration = workerConfiguration;
  }
}
