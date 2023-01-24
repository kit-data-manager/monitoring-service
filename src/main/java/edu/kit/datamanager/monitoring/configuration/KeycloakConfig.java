/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.kit.datamanager.monitoring.configuration;
//@KeycloakConfiguration
//@EnableConfigurationProperties(KeycloakSpringBootProperties.class)
public class KeycloakConfig{// extends KeycloakWebSecurityConfigurerAdapter {

    /**
     * {@link HttpHeadersProvider} used to populate the {@link HttpHeaders} for
     * accessing the state of the disovered clients.
     *
     * @param keycloak
     * @return
     */
//    @Bean
//    public HttpHeadersProvider keycloakBearerAuthHeaderProvider(Keycloak keycloak) {
//        return (app) -> {
//            String accessToken = keycloak.tokenManager().getAccessTokenString();
//            HttpHeaders headers = new HttpHeaders();
//            headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
//            return headers;
//        };
//    }
//
//   
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//        
////
//                http.csrf().disable() // for the sake of brevity...
//                .authorizeRequests() //
//                .antMatchers("/**/*.css", "/admin/img/**", "/admin/third-party/**").permitAll() //
//                .antMatchers("/admin").hasRole("ADMIN") //
//                .anyRequest().permitAll() //
//                ;
//    }
//
//
//
//    /**
//     * Use {@link KeycloakAuthenticationProvider}
//     *
//     * @param auth
//     * @throws Exception
//     */
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//
//        SimpleAuthorityMapper grantedAuthorityMapper = new SimpleAuthorityMapper();
//        grantedAuthorityMapper.setPrefix("ROLE_");
//        grantedAuthorityMapper.setConvertToUpperCase(true);
//
//        KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
//        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(grantedAuthorityMapper);
//        auth.authenticationProvider(keycloakAuthenticationProvider);
//    }
//
//    @Bean
//    @Override
//    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
//        return new RegisterSessionAuthenticationStrategy(buildSessionRegistry());
//    }
//
//    @Bean
//    protected SessionRegistry buildSessionRegistry() {
//        return new SessionRegistryImpl();
//    }
//
//    /**
//     * Allows to inject requests scoped wrapper for
//     * {@link KeycloakSecurityContext}.
//     * <p>
//     * Returns the {@link KeycloakSecurityContext} from the Spring
//     * {@link ServletRequestAttributes}'s {@link Principal}.
//     * <p>
//     * The principal must support retrieval of the KeycloakSecurityContext, so
//     * at this point, only {@link KeycloakPrincipal} values and
//     * {@link KeycloakAuthenticationToken} are supported.
//     *
//     * @return the current <code>KeycloakSecurityContext</code>
//     */
//    @Bean
//    @Scope(scopeName = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
//    public KeycloakSecurityContext provideKeycloakSecurityContext() {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        Principal principal = attributes.getRequest().getUserPrincipal();
//        if (principal == null) {
//            return null;
//        }
//
//        if (principal instanceof KeycloakAuthenticationToken) {
//            principal = Principal.class.cast(KeycloakAuthenticationToken.class.cast(principal).getPrincipal());
//        }
//
//        if (principal instanceof KeycloakPrincipal) {
//            return KeycloakPrincipal.class.cast(principal).getKeycloakSecurityContext();
//        }
//
//        return null;
//    }
}
