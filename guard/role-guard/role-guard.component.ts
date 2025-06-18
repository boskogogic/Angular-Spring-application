import { Component, Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, GuardResult, MaybeAsync, Router, RouterStateSnapshot } from '@angular/router';
import { LoginService, RoleType } from '../../login/login.service';
import { LoginComponent } from '../../login/login/login.component';


@Injectable({
  providedIn: 'root',
})
export class RoleGuardComponent implements CanActivate {

  constructor(private loginService : LoginService, private router : Router) {

  }
  
  canActivate(
    route: ActivatedRouteSnapshot, 
    state: RouterStateSnapshot
  ) : MaybeAsync<GuardResult> {
    
    console.log("Can activate.....");
    //const requiredRoles = route.data['role'] as RoleType;
    const requiredRoles = localStorage.getItem("role") as RoleType;
    if (state.url === '/login') {
      this.router.navigate(['/login']);
      return false;
    }
    console.log("Can activate required roles " + requiredRoles);
    if (this.loginService.hasRole(requiredRoles)) {
      console.log("Role guard roles is equal");
      //this.router.navigate(['/admin-page']);
      return true;
      
    }
    return false;
  }

}
