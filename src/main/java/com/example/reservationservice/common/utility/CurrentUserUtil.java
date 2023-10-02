// package com.example.reservationservice.common.utility;

// import java.util.List;
// import java.util.stream.Collectors;
// import org.springframework.security.core.context.SecurityContextHolder;
// import com.example.reservationservice.security.authentication.User;

// public final class CurrentUserUtil {
//     public CurrentUserUtil() {}

//     public static User getCurrentUser() {
//         return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//     }

//     public static List<String> getAuthorities() {
//         return  SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
//         .map(authority -> authority.toString())
//         .collect(Collectors.toList());
//     }

//     public static Boolean hasRole(String role) {
//         return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().anyMatch(authority->{
//             return authority.getAuthority().equals(role);
//         });
//     }
    
//     public static Boolean hasAnyRole(List<String> roles) {
//         return roles.stream().anyMatch(role -> {    
//             return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().anyMatch(authority -> {
//                 return authority.getAuthority().equals(role);
//             });
//         });
//     }

//     public static Boolean hasAllRole(List<String> roles) {
//         return roles.stream().allMatch(role -> {
//             return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().anyMatch(authority -> {
//                 return authority.getAuthority().equals(role);
//             });
//         });
//     }
// }
