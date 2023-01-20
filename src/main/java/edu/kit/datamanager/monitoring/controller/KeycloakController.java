/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.kit.datamanager.monitoring.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Torridity
 */
//@Controller
class KeycloakController {

    /**
     * Propagates the logout to the Keycloak infrastructure
     *
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/admin/logout")
    public String logout(HttpServletRequest request) throws Exception {
        request.logout();
        return "redirect:/admin";
    }
}
