package com.cartelera.infocarteapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.Arrays;

/**
 * Configuracion de Authorization Server.
 * La anotacion @EnableAuthorizationServer es usada para configurar el servidor de autorizacion OAuth 2.0
 * junto a cualquier @Beans que implemente AuthorizationServerConfigurer.
 */

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private PasswordEncoder passwordEncoder;

  /** ACA COMIENZA LA CONFIGURACION CON JWT **/
  /**
   * La clase AuthorizationServerEndpointsConfigurer define la autorizacion y los token de endpoints y servicios.
   * @param endpoints
   * @throws Exception
   */
  @Override
  public void configure(
    AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
    tokenEnhancerChain.setTokenEnhancers(
      Arrays.asList(tokenEnhancer(), accessTokenConverter()));

    endpoints.tokenStore(tokenStore())
      .tokenEnhancer(tokenEnhancerChain)
      .authenticationManager(authenticationManager);
  }

  @Bean
  public TokenEnhancer tokenEnhancer() {
    return new CustomTokenEnhancer();
  }

  @Bean
  public TokenStore tokenStore() {
    return new JwtTokenStore(accessTokenConverter());
  }

  @Bean
  public JwtAccessTokenConverter accessTokenConverter() {
    JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
    converter.setSigningKey("123");
    return converter;
  }

  @Bean
  @Primary
  public DefaultTokenServices tokenServices() {
    DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
    defaultTokenServices.setTokenStore(tokenStore());
    defaultTokenServices.setSupportRefreshToken(true);
    return defaultTokenServices;
  }

  /** ACA TERMINA CONFIGURACION JWT **/

  /**
   * Setting up the clients with a clientId, a clientSecret, a scope, the grant types and the authorities.
   * @param clients
   * @throws Exception
   */
  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    clients
      .inMemory()
      .withClient("my-trusted-client")
      .authorizedGrantTypes("client_credentials", "password")
      .authorities("ROLE_CLIENT","ROLE_TRUSTED_CLIENT")
      .scopes("read","write","trust")
      .resourceIds("oauth2-resource")
      .accessTokenValiditySeconds(5000)
      .secret(passwordEncoder.encode("secret"));
  }

  /**
   * We here defines the security constraints on the token endpoint.
   * We set it up to isAuthenticated, which returns true if the user is not anonymous
   * @param security the AuthorizationServerSecurityConfigurer.
   * @throws Exception
   */
  @Override
  public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
    security
      .checkTokenAccess("isAuthenticated()");
  }
}
