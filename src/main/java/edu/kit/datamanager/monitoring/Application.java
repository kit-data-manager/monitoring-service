/*
 * Copyright 2018 Karlsruhe Institute of Technology.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.kit.datamanager.monitoring;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import io.netty.handler.ssl.SslContextBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import reactor.netty.http.client.HttpClient;
import edu.kit.datamanager.monitoring.configuration.KeycloakConfig;
import org.keycloak.OAuth2Constants;
import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootProperties;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;

/**
 *
 * @author jejkal
 */
@Configuration
@EnableAutoConfiguration
@EnableAdminServer
@ComponentScan({"edu.kit.datamanager"})
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
    }

    /**
     * The Keycloak Admin client that provides the service-account Access-Token
     *
     * @param props
     * @return
     */
    @Bean
    public Keycloak keycloak(KeycloakSpringBootProperties props) {
        return KeycloakBuilder.builder() //
                .serverUrl(props.getAuthServerUrl()) //
                .realm(props.getRealm()) //
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS) //
                .clientId(props.getResource()) //
                .clientSecret((String) props.getCredentials().get("secret")) //
                .build();
    }

    /**
     * Load Keycloak configuration from application.properties or
     * application.yml
     *
     * @return
     */
    @Bean
    public KeycloakConfigResolver keycloakConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }

    @Bean
    public ClientHttpConnector customHttpClient() {
        SslContextBuilder sslContext = SslContextBuilder.forClient();
        //Your sslContext customizations go here
        HttpClient httpClient = HttpClient.create().secure(
                ssl -> ssl.sslContext(sslContext)
        );
        return new ReactorClientHttpConnector(httpClient);
    }

}
