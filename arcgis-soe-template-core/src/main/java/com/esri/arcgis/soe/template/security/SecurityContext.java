package com.esri.arcgis.soe.template.security;

import java.security.Principal;
import java.util.Set;

public interface SecurityContext {

    Set<String> getUserRoles();

    Principal getUserPrincipal();
}
