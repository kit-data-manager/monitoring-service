/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.kit.datamanager.monitoring.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author jejkal
 */
//@Controller
//@RequestMapping(value = "/")
class KeycloakController {

//    /**
//     * Propagates the logout to the Keycloak infrastructure
//     *
//     * @param request
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "/admin/logout", method = RequestMethod.POST)
//    public String logout(HttpServletRequest request) throws Exception {
//      System.out.println(SecurityContextHolder.getContext().getAuthentication());
//        System.out.println("LOGOUT");
//        request.logout();
//        return "redirect:/admin";
//    }
}
