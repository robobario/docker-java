package com.github.dockerjava.httpclient5;

import com.github.dockerjava.transport.SSLConfig;

import java.net.URI;
import java.time.Duration;
import java.util.Objects;

public final class ApacheDockerHttpClient extends ApacheDockerHttpClientImpl {

    public static final class Builder {

        private URI dockerHost = null;

        private SSLConfig sslConfig = null;

        private int maxConnections = Integer.MAX_VALUE;

        private Integer maxConnectionsPerRoute = null;

        private Duration connectionTimeout;

        private Duration responseTimeout;

        private Duration connectionKeepAlive;

        public Builder dockerHost(URI value) {
            this.dockerHost = Objects.requireNonNull(value, "dockerHost");
            return this;
        }

        public Builder sslConfig(SSLConfig value) {
            this.sslConfig = value;
            return this;
        }

        public Builder maxConnections(int value) {
            this.maxConnections = value;
            return this;
        }

        public Builder maxConnectionsPerRoute(int value) {
            this.maxConnectionsPerRoute = value;
            return this;
        }

        public Builder connectionTimeout(Duration connectionTimeout) {
            this.connectionTimeout = connectionTimeout;
            return this;
        }

        public Builder connectionKeepAlive(Duration connectionKeepAlive) {
            this.connectionKeepAlive = connectionKeepAlive;
            return this;
        }

        public Builder responseTimeout(Duration responseTimeout) {
            this.responseTimeout = responseTimeout;
            return this;
        }

        public ApacheDockerHttpClient build() {
            Objects.requireNonNull(dockerHost, "dockerHost");
            int maxPerRoute = maxConnectionsPerRoute == null ? maxConnections : maxConnectionsPerRoute;
            return new ApacheDockerHttpClient(dockerHost, sslConfig, maxConnections, maxPerRoute, connectionTimeout, responseTimeout,
                connectionKeepAlive);
        }
    }

    private ApacheDockerHttpClient(URI dockerHost, SSLConfig sslConfig, int maxConnections, int maxConnectionsPerRoute,
        Duration connectionTimeout, Duration responseTimeout, Duration connectionKeepAlive) {
        super(dockerHost, sslConfig, maxConnections, maxConnectionsPerRoute, connectionTimeout, responseTimeout, connectionKeepAlive);
    }
}
